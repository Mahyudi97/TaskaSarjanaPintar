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
public class Receipt {
    int reciptId;
    String receiptDate;

    public Receipt(int reciptId, String receiptDate) {
        this.reciptId = reciptId;
        this.receiptDate = receiptDate;
    }

    public int getReciptId() {
        return reciptId;
    }

    public String getReceiptDate() {
        return receiptDate;
    }
    
}
