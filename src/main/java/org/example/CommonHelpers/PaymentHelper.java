package org.example.CommonHelpers;

public class PaymentHelper {
    public enum PaymentMode{
        COD,
        DEFER,
        PAYNOW
    }

    public static PaymentMode getPaymentMode(int mode) {
        switch(mode){
            case 1: return PaymentMode.PAYNOW;
            case 2: return PaymentMode.DEFER;
            case 3: return PaymentMode.COD;
        }
        return null;
    }
}
