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
public class Fees {
    int feesId;
    double feesAmount;
    String feesDueDate;
    String feesType; //register & monthly

    public Fees(int feesId, double feesAmount, String feesDueDate, String feesType) {
        this.feesId = feesId;
        this.feesAmount = feesAmount;
        this.feesDueDate = feesDueDate;
        this.feesType = feesType;
    }

    public int getFeesId() {
        return feesId;
    }

    public double getFeesAmount() {
        return feesAmount;
    }

    public String getFeesDueDate() {
        return feesDueDate;
    }

    public String getFeesType() {
        return feesType;
    }
    
    
    
}
