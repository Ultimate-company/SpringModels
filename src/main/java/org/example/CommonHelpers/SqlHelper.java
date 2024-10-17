package org.example.CommonHelpers;

public class SqlHelper {
    public static String generateWhereClause(String column, String condition, String filterExpr){
        return switch (condition) {
            case "contains" -> column + " like '%" + filterExpr + "%'";
            case "equals" -> column + " like '" + filterExpr + "'";
            case "startsWith" -> column + " like '" + filterExpr + "%'";
            case "endsWith" -> column + " like '%" + filterExpr + "'";
            case "isEmpty" -> "( " + column + " = '' ) IS NOT FALSE";
            case "isNotEmpty" -> "( " + column + " = '' ) IS NOT TRUE";
            default -> "TRUE = TRUE";
        };
    }
}
