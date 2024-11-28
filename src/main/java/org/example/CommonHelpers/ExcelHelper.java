package org.example.CommonHelpers;

import java.io.*;
import java.lang.reflect.ParameterizedType;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Field;
import java.util.*;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.nimbusds.jose.shaded.gson.Gson;
import com.nimbusds.jose.shaded.gson.GsonBuilder;
import com.nimbusds.jose.shaded.gson.reflect.TypeToken;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.example.Adapters.DateAdapter;
import org.example.Adapters.LocalDateTimeAdapter;
import org.example.Annotations.FrontEndVariable;
import org.example.Annotations.IsRequired;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {
    //
    private static boolean isPrimitiveType(Class<?> clazz) {
        return clazz.isPrimitive() ||
                clazz == Date.class ||
                clazz == LocalDateTime.class ||
                clazz == LocalDate.class ||
                clazz == List.class ||
                clazz == Map.class ||
                clazz == String.class ||
                clazz == Long.class ||
                clazz == Integer.class ||
                clazz == Double.class ||
                clazz == Float.class ||
                clazz == Boolean.class ||
                clazz == Byte.class ||
                clazz == Short.class;
    }
    public static List<Map<String, String>> parseExcel(MultipartFile file) throws IOException {
        List<Map<String, String>> data = new ArrayList<>();
        try (Workbook workbook = WorkbookFactory.create(file.getInputStream())) {
            Sheet sheet = workbook.getSheetAt(0);
            if (sheet == null) {
                throw new IOException("No sheet found in the workbook");
            }

            // Read the section headers (first row, index 0) and column headers (second row, index 1)
            Row sectionRow = sheet.getRow(0);
            Row headerRow = sheet.getRow(1);
            if (headerRow == null || sectionRow == null) {
                throw new IOException("Header row or section row is missing");
            }

            // Create a map for section headers and their corresponding columns
            Map<Integer, String> sectionHeadersMap = new HashMap<>();
            for (CellRangeAddress mergedRegion : sheet.getMergedRegions()) {
                if (mergedRegion.getFirstRow() == sectionRow.getRowNum()) {
                    String sectionHeader = sectionRow.getCell(mergedRegion.getFirstColumn()).toString().trim();
                    for (int colIndex = mergedRegion.getFirstColumn(); colIndex <= mergedRegion.getLastColumn(); colIndex++) {
                        sectionHeadersMap.put(colIndex, sectionHeader);
                    }
                }
            }

            // In case there are no merged regions, add individual cells
            for (Cell cell : sectionRow) {
                int colIndex = cell.getColumnIndex();
                if (!sectionHeadersMap.containsKey(colIndex)) {
                    sectionHeadersMap.put(colIndex, cell.toString().trim());
                }
            }

            // Prepare a list of composite headers
            List<String> compositeHeaders = new ArrayList<>();
            for (Cell cell : headerRow) {
                int colIndex = cell.getColumnIndex();
                String sectionHeader = sectionHeadersMap.getOrDefault(colIndex, "");
                String columnHeader = cell.toString().trim();
                compositeHeaders.add(sectionHeader + ":" + columnHeader);
            }

            // Process each row in the sheet
            for (int rowIndex = 2; rowIndex <= sheet.getLastRowNum(); rowIndex++) { // Starting from the third row
                Row row = sheet.getRow(rowIndex);
                if (row == null) {
                    continue; // Skip empty rows
                }

                Map<String, String> rowData = new HashMap<>();
                for (int colIndex = 0; colIndex < compositeHeaders.size(); colIndex++) {
                    Cell cell = row.getCell(colIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    String cellValue = (cell == null || cell.getCellType() == CellType.BLANK) ? null : cell.toString().trim();
                    rowData.put(compositeHeaders.get(colIndex), cellValue);
                }
                data.add(rowData);
            }
        }
        return data; // Return the mapped data
    }
    private static Object parseValue(Class<?> fieldType, String value, boolean isImage) throws Exception {
        if(value == null) {
            return null;
        }

        if (fieldType == String.class) {
            // If isImage is true, parse the image URL to Base64
            if (isImage) {
                return parseImageUrlToBase64(value);
            }
            return value;
        }
        else if (fieldType == int.class || fieldType == Integer.class) {
            return (int) Double.parseDouble(value);
        }
        else if (fieldType == double.class || fieldType == Double.class) {
            return Double.parseDouble(value);
        }
        else if (fieldType == long.class || fieldType == Long.class) {
            return (long) Double.parseDouble(value);
        }
        else if (fieldType == boolean.class || fieldType == Boolean.class) {
            return Boolean.parseBoolean(value);
        }
        else if (fieldType == Date.class) {
            return new SimpleDateFormat("yyyy-MM-dd").parse(value);
        }
        else if (fieldType == LocalDate.class) {
            return LocalDate.parse(value);
        }
        else if (fieldType == LocalDateTime.class) {
            // Append default time if not present
            if (!value.contains("T")) {
                value = value + "T00:00:00";
            }
            return LocalDateTime.parse(value);
        }
        else if (fieldType == List.class) {
            // Remove brackets if value is in the form "[1, 2, 3]"
            if (value.startsWith("[") && value.endsWith("]")) {
                value = value.substring(1, value.length() - 1);
            }

            String[] elements = value.split(",");
            List<String> stringList = new ArrayList<>();
            boolean allNumeric = true;

            for (String element : elements) {
                element = element.trim();
                stringList.add(element);

                // Check if element is numeric
                if (!element.matches("-?\\d+")) {
                    allNumeric = false;
                }
            }

            // Convert to List<Long> using streams if all elements are numeric
            if (allNumeric) {
                return stringList.stream()
                        .map(Long::parseLong)
                        .toList();  // Requires Java 16+ for List<Long>
            }

            return stringList;
        }
        else if(fieldType == Map.class) {
            ObjectMapper objectMapper = new ObjectMapper();

            // Use reflection to determine generic key and value types if available
            ParameterizedType parameterizedType = (ParameterizedType) fieldType.getGenericSuperclass();
            Class<?> keyType = (Class<?>) parameterizedType.getActualTypeArguments()[0];
            Class<?> valueType = (Class<?>) parameterizedType.getActualTypeArguments()[1];

            // Construct the type reference dynamically for Map<keyType, valueType>
            return objectMapper.readValue(value, TypeFactory.defaultInstance().constructMapType(Map.class, keyType, valueType));
        }

        return null;
    }
    private static String parseImageUrlToBase64(String imageUrl) {
        try (InputStream inputStream = new URI(imageUrl).toURL().openStream();
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {

            // Read the image bytes from the URL
            byte[] buffer = new byte[8192];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, bytesRead);
            }

            // Convert to Base64
            byte[] imageBytes = byteArrayOutputStream.toByteArray();
            return Base64.getEncoder().encodeToString(imageBytes);

        } catch (Exception e) {
            return null;
        }
    }
    //

    public static byte[] generateExcelFileForBulkImportErrors(Map<String, String> errors) throws Exception {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Import Errors");
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Sr No");
        headerRow.createCell(1).setCellValue("Import Field");
        headerRow.createCell(2).setCellValue("Error");

        int rowIdx = 1;
        int srNo = 1;
        for (Map.Entry<String, String> entry : errors.entrySet()) {
            Row row = sheet.createRow(rowIdx++);
            row.createCell(0).setCellValue(srNo++);
            row.createCell(1).setCellValue(entry.getKey());
            row.createCell(2).setCellValue(entry.getValue());
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();
        return outputStream.toByteArray();
    }

    public static void populateObjectFields(Object obj, Map<String, String> row) throws Exception {
        if (obj == null) return;

        HashSet<String> imageFieldColumns = new HashSet<>(List.of("profilePictureBase64"));

        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);

            if (isPrimitiveType(field.getType())) {
                // Handle primitive and wrapper types
                if (field.isAnnotationPresent(FrontEndVariable.class)) {
                    String sectionHeader = "Additional";
                    String headerCell = field.getName();
                    String keyValue = sectionHeader + ":" + headerCell;

                    if (row.containsKey(keyValue)) {
                        field.set(obj,
                                parseValue(field.getType(),
                                        row.get(keyValue),
                                        imageFieldColumns.contains(field.getName())));
                    }
                }
            }
            else if (field.getType().getPackage().getName().startsWith("org.example.Models.CommunicationModels")) {
                // Handle second-level fields
                Object nestedObj = field.getType().getDeclaredConstructor().newInstance(); // Create new instance of nested class
                for (Field customField : field.getType().getDeclaredFields()) {
                    customField.setAccessible(true);
                    if (isPrimitiveType(customField.getType())) {
                        // Handle primitive and wrapper types
                        if (customField.isAnnotationPresent(FrontEndVariable.class)) {
                            String sectionHeader = field.getName();
                            String headerCell = customField.getName();
                            String keyValue = sectionHeader + ":" + headerCell;

                            if (row.containsKey(keyValue)) {
                                customField.set(nestedObj,
                                        parseValue(customField.getType(),
                                                row.get(keyValue),
                                                imageFieldColumns.contains(customField.getName())));
                            }
                        }
                    }
                }

                field.set(obj, nestedObj); // Set the populated nested object
            }
        }
    }

    public static Pair<Boolean, String> checkIfFileIsExcelType(MultipartFile multipartFile) {
        String fileType = multipartFile.getContentType();
        if (fileType == null || (!fileType.equals("application/vnd.ms-excel") &&
                !fileType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet") &&
                !fileType.equals("text/csv"))) {

            return Pair.of(false, "Invalid file type. Please upload an xlsx, xls, or csv file.");
        }

        return Pair.of(true, "Valid file type.");
    }

    public static byte[] createBulkImportModelTemplate(
            Map<String, Map<String, Boolean>> fieldMap,
            String fileName) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet(fileName);

        // Define styling for Section Headers
        CellStyle sectionHeaderStyle = workbook.createCellStyle();
        sectionHeaderStyle.setFillForegroundColor(IndexedColors.GREY_80_PERCENT.getIndex());
        sectionHeaderStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        sectionHeaderStyle.setAlignment(HorizontalAlignment.CENTER);
        sectionHeaderStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        Font sectionHeaderFont = workbook.createFont();
        sectionHeaderFont.setBold(true);
        sectionHeaderFont.setColor(IndexedColors.WHITE.getIndex());
        sectionHeaderStyle.setFont(sectionHeaderFont);

        // Track the current column position
        int column = 0;

        // Create header rows
        Row headerRow = sheet.createRow(0);
        Row fieldRow = sheet.createRow(1);

        for (Map.Entry<String, Map<String, Boolean>> section : fieldMap.entrySet()) {
            String sectionName = section.getKey();
            Map<String, Boolean> fields = section.getValue();

            // Merge cells for section header
            Cell sectionHeaderCell = headerRow.createCell(column);
            sectionHeaderCell.setCellValue(sectionName);
            sectionHeaderCell.setCellStyle(sectionHeaderStyle);

            // Merge cells only if the section has more than one field
            if (fields.size() > 1) {
                sheet.addMergedRegion(new CellRangeAddress(0, 0, column, column + fields.size() - 1));
            }

            // Create individual field headers
            for (Map.Entry<String, Boolean> field : fields.entrySet()) {
                Cell fieldCell = fieldRow.createCell(column);
                fieldCell.setCellValue(field.getKey());

                // Create and set field header style for each cell
                CellStyle fieldHeaderStyle = workbook.createCellStyle();
                fieldHeaderStyle.setFillForegroundColor(IndexedColors.GREY_80_PERCENT.getIndex());
                fieldHeaderStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                Font fieldHeaderFont = workbook.createFont();
                fieldHeaderFont.setBold(true);

                if (field.getValue()) {
                    fieldHeaderFont.setColor(IndexedColors.RED.getIndex());
                } else {
                    fieldHeaderFont.setColor(IndexedColors.WHITE.getIndex());
                }

                fieldHeaderStyle.setFont(fieldHeaderFont);
                fieldCell.setCellStyle(fieldHeaderStyle);

                // auto size the columns to fit the text
                sheet.autoSizeColumn(column);
                column++;
            }
        }

        // Write to ByteArrayOutputStream to return as byte array
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        workbook.close();
        return out.toByteArray();
    }

    public static void populateFieldMap(Class<?> clazz, Map<String, Map<String, Boolean>> fieldMap) {
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true); // Allow access to private fields

            // Check if the field has the required annotations
            boolean isRequired = field.isAnnotationPresent(IsRequired.class);
            boolean isFrontEndVariable = field.isAnnotationPresent(FrontEndVariable.class);

            // Get the field type
            Class<?> fieldType = field.getType();
            String variableName = field.getName();

            if (isFrontEndVariable) {
                // If it's a primitive type or String, handle it directly
                if (isPrimitiveType(fieldType)) {
                    fieldMap
                            .computeIfAbsent("Additional", k -> new LinkedHashMap<>())
                            .put(variableName, isRequired);
                }

                // If it's a custom class, handle its fields
                else if (fieldType.getPackage().getName().startsWith("org.example.Models.CommunicationModels")) {
                    Map<String, Boolean> customFieldMap = new LinkedHashMap<>();
                    Field[] customFields = fieldType.getDeclaredFields();

                    for (Field customField : customFields) {
                        if (customField.isAnnotationPresent(FrontEndVariable.class)) {
                            customField.setAccessible(true);
                            boolean customFieldIsRequired = customField.isAnnotationPresent(IsRequired.class);
                            String customFieldName = customField.getName();

                            // Handle primitive types for custom fields
                            if (isPrimitiveType(customField.getType())) {
                                customFieldMap.put(customFieldName, customFieldIsRequired);
                            }
                        }
                    }

                    fieldMap.putIfAbsent(variableName, customFieldMap);
                }
            }
        }
    }
}