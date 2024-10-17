package org.example.Translators.CarrierDatabaseTranslators.Interfaces;

import org.example.Models.CommunicationModels.CarrierModels.PaymentInfo;
import org.example.Models.ResponseModels.Response;

public interface IPaymentInfoSubTranslator {
    /**
     * Adds new payment information to the system.
     *
     * @param paymentInfo The payment information object containing details of the payment.
     * @return A response containing the ID of the newly created payment information.
     */
    Response<Long> insertPaymentInfo(PaymentInfo paymentInfo);

    /**
     * Updates existing payment information in the system.
     *
     * @param paymentInfo The payment information object containing updated details of the payment.
     * @return A response containing the ID of the updated payment information.
     */
    Response<Long> updatePaymentInfo(PaymentInfo paymentInfo);
}
