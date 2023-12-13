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
public class Registration {
    int registrationId;
    String registrationDate;

    public Registration(int registrationId, String registrationDate) {
        this.registrationId = registrationId;
        this.registrationDate = registrationDate;
    }

    public int getRegistrationId() {
        return registrationId;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }
    
    
}
