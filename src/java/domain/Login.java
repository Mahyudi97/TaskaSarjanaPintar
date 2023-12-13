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
public class Login {
    
    int loginId;
    String loginPassword;

    public Login(int loginId, String loginPassword) {
        this.loginId=loginId;
        this.loginPassword=loginPassword;
    }
    
    public int getLoginId() {
        return loginId;
    }
    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginId(int loginId) {
        this.loginId = loginId;
    }
    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    
}
