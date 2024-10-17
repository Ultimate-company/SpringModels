/**
 * This file inserts the categories in the db use this only when migrating dbs, do not run this anytime else.
 */
package org.example.StaticDataInsert;

//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.sql.*;

public class TPTEST {
//    private static final String FILE_PATH = "/Users/nraichura/Desktop/Ultimate Company/spring-api/SpringApi/src/main/java/categories.txt";
//    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/CentralDatabase";
//    private static final String USERNAME = "root";
//    private static final String PASSWORD = "Mysqladmin1892";
//
//    public static void entrypointfunction() {
//        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
//            String line;
//            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
//                while ((line = reader.readLine()) != null) {
//                    insertCategory(connection, line);
//                }
//            }
//        } catch (IOException | SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static void insertCategory(Connection connection, String line) throws SQLException {
//        String[] parts = line.split(" - ");
//        long id = Long.parseLong(parts[0].trim());
//
//        String[] cats = parts[1].split(">");
//        String name = cats[cats.length - 1].trim();
//        Long parentId = cats.length > 1 ? getCategoryId(cats[cats.length-2].trim())/*Get the category id of the parent from db*/ : null; // Assuming parent ID is optional
//
//        String sql = "INSERT INTO ProductCategory (Id, Name, ParentId) VALUES (?, ?, ?)";
//        try (PreparedStatement statement = connection.prepareStatement(sql)) {
//            statement.setLong(1, id);
//            statement.setString(2, name);
//            if (parentId != null) {
//                statement.setObject(3, parentId); // Set parentId if not null
//            } else {
//                statement.setNull(3, Types.BIGINT); // Set null for parentId
//            }
//            statement.executeUpdate();
//        }
//    }
//
//    private static long getCategoryId(String name) {
//        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
//            String sql = "SELECT CategoryId FROM ProductCategory WHERE Name = ?";
//            try (PreparedStatement statement = connection.prepareStatement(sql)) {
//                statement.setString(1, name);
//                try (ResultSet resultSet = statement.executeQuery()) {
//                    if (resultSet.next()) {
//                        return resultSet.getLong("CategoryId");
//                    } else {
//                        // Category not found
//                        return -1; // or throw an exception
//                    }
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return -1;
//        }
//    }
}
