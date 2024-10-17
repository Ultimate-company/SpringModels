package org.example.CommonHelpers;

import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ProductHelper {
    public static Map<String, SortedSet<String>> ProductCategory_Mapping;
    public static Map<String, Integer> ProductCategrory_Id_Mapping;
    public static Map<Integer, Integer> CategoryId_LineNumber_Mapping;
    @Getter
    public static List<Map<String, String>> Colors = new ArrayList<>();
    public static Map<String, String> ColorIdLabelMapping = new HashMap<>();
    public static String[] lines;

    @Getter
    @Setter
    public static class ProductCategory {
        private String name;
        private boolean isEnd;
        private boolean isSelected;
    }

    static {
        ProductCategory_Mapping = new HashMap<>();
        ProductCategrory_Id_Mapping = new HashMap<>();
        CategoryId_LineNumber_Mapping = new HashMap<>();
        ProductCategory_Mapping.put("root", new TreeSet<>());

        try {
            // Read product categories from file
            var filePath = Paths.get(System.getProperty("user.dir") + "/src/main/resources/Datasets/ProductCategories.txt");
            lines = Files.readAllLines(filePath).toArray(new String[0]);

            int line = 0;
            for (String row : lines) {
                String[] rowSplit = row.split("-");
                String[] Categories = rowSplit[1].split(">");
                CategoryId_LineNumber_Mapping.put(Integer.parseInt(rowSplit[0].trim()), line++);

                if (Categories.length == 1) {
                    ProductCategory_Mapping.get("root").add(Categories[0].trim());
                    ProductCategrory_Id_Mapping.put(Categories[0].trim(), Integer.parseInt(rowSplit[0].trim()));
                    continue;
                }

                int ptr1 = 0;
                int ptr2 = 1;
                for (int i = 0; i < Categories.length; i++) {
                    String key = Categories[ptr1].trim();
                    if (ptr2 < Categories.length) {
                        String value = Categories[ptr2].trim();
                        ProductCategory_Mapping.putIfAbsent(key, new TreeSet<>());
                        ProductCategory_Mapping.get(key).add(value);
                        ptr1++;
                        ptr2++;
                    } else {
                        ProductCategory_Mapping.putIfAbsent(key, new TreeSet<>());
                        ProductCategrory_Id_Mapping.put(key, Integer.parseInt(rowSplit[0].trim()));
                    }
                }
            }

            // Read colors dataset
            List<String> colorLines = Files.readAllLines(Paths.get(System.getProperty("user.dir") + "/src/main/resources/Datasets/ColorDataSet.txt"));
            for (String row : colorLines) {
                String[] ColorProperties = row.split(",");
                String key = ColorProperties[2].trim();
                String value = ColorProperties[1].replace('"', ' ').trim();

                if (!ColorIdLabelMapping.containsKey(key)) {
                    Map<String, String> color = new HashMap<>();
                    color.put("label", value);
                    color.put("id", key);
                    Colors.add(color);
                    ColorIdLabelMapping.put(key, value);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace(); // Handle exceptions
        }
    }

    public static int getLineNumber(int CategoryId) {
        return CategoryId_LineNumber_Mapping.get(CategoryId);
    }

    public static String getParentForCategory(String CategoryName) {
        String row = lines[getLineNumber(getCategoryIdByName(CategoryName))];
        String[] rowSplit = row.split("-");
        String[] Categories = rowSplit[1].split(">");

        if (Categories.length > 1) {
            return Categories[Categories.length - 2].trim();
        } else {
            return "root";
        }
    }

    public static boolean isProductEnd(String key) {
        return !ProductCategory_Mapping.containsKey(key) || ProductCategory_Mapping.get(key).isEmpty();
    }

    public static int getCategoryIdByName(String key) {
        return ProductCategrory_Id_Mapping.get(key);
    }

    public static List<ProductCategory> getProducts(String key) {
        List<ProductCategory> data = new ArrayList<>();
        SortedSet<String> keys = ProductCategory_Mapping.getOrDefault(key, new TreeSet<>());

        for (String k : keys) {
            ProductCategory productCategory = new ProductCategory();
            productCategory.setName(k);
            productCategory.setEnd(isProductEnd(k));
            productCategory.setSelected(false);
            data.add(productCategory);
        }
        return data;
    }

    public static List<String> getAllParents(String CategoryName) {
        LinkedList<String> parents = new LinkedList<>();
        if (CategoryName.equals("root")) return parents;

        do {
            String parent = getParentForCategory(CategoryName).trim();
            parents.addFirst(parent);
            CategoryName = parent;
        } while (!CategoryName.equals("root"));

        return new ArrayList<>(parents);
    }

    public static String getColorLabel(String key) {
        return ColorIdLabelMapping.get(key.trim());
    }
}
