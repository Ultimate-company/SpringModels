package org.example.CommonHelpers;

import java.io.IOException;

import com.nimbusds.jose.shaded.gson.Gson;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.multipart.MultipartFile;

public class ExcelHelper {
    public static String[][] readExcelTo2DArray(MultipartFile multipartFile) {

        try (Workbook workbook = WorkbookFactory.create(multipartFile.getInputStream())) {
            Sheet sheet = workbook.getSheetAt(0); // Assuming you're reading the first sheet

            // Get the number of rows and columns in the sheet
            int numRows = sheet.getPhysicalNumberOfRows();
            int numCols = sheet.getRow(0).getPhysicalNumberOfCells();

            // Create a 2D array to store the sheet data
            String[][] data = new String[numRows][numCols];

            // Iterate through each row in the sheet
            for (int i = 0; i < numRows; i++) {
                Row row = sheet.getRow(i);
                // Iterate through each cell in the row
                for (int j = 0; j < numCols; j++) {
                    Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    // Get the cell value as string and store it in the array
                    data[i][j] = cell.toString();
                }
            }
            return data;
        } catch (IOException | EncryptedDocumentException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static String serialize2DWorkbookToString(String[][] data) {
        Gson gson = new Gson();
        return gson.toJson(data);
    }
    public static String[][] deSerializeStringTo2DWorkbook(String serializedData) {
        Gson gson = new Gson();
        return gson.fromJson(serializedData, String[][].class);
    }
}

