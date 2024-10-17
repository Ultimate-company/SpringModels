package org.example.Models.CommunicationModels.CarrierModels;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class PaymentInfo {
    private long paymentId;
    private double total;
    private double tax;
    private double serviceFee;
    private double discount;
    private double packagingFee;
    private int status;
    private int mode;
    private double subTotal;
    private double deliveryFee;
    private double pendingAmount;
    private String razorpayTransactionId;
    private String razorpayReceipt;
    private String razorpayOrderId;
    private String razorpayPaymentNotes;
    private String razorpaySignature;
    private Long promoId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String notes;
    private Long auditUserId;
}
