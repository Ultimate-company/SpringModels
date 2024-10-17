package org.example.Models.Enums;

import java.util.Arrays;
import java.util.List;

public enum SalesOrderStatus {
    ORDER_RECEIVED(1),
    ORDER_PICKED(2),
    ORDER_IN_TRANSIT(3),
    OUT_FOR_DELIVERY(4),
    DELIVERED(5),
    CANCELLED(6);

    private final int code;

    SalesOrderStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static SalesOrderStatus fromCode(int code) {
        for (SalesOrderStatus status : SalesOrderStatus.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("No status with code " + code);
    }

    public static List<SalesOrderStatus> getAllSalesOrderStatus() {
        return Arrays.stream(SalesOrderStatus.values()).toList();
    }
}
