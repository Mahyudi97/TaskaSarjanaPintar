/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Ahmad Mahyudi
 */
public class Payment {
    int paymentId;
    String dateOfPayment;
    String paymentStatus;

    public Payment(int paymentId, String dateOfPayment, String paymentStatus) {
        this.paymentId = paymentId;
        this.dateOfPayment = dateOfPayment;
        this.paymentStatus = paymentStatus;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public String getDateOfPayment() {
        return dateOfPayment;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }
    
    
}
