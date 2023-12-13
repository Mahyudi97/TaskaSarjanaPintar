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
public class Parent {
    int parentId;
    String parentAddress;
    String fatherName;
    String fatherIC;
    String fatherContact;
    String fatherOccupation;
    String fatherOccupAddress;
    String motherName;
    String motherIC;
    String motherContact;
    String motherOccupation;
    String motherOccupAddress;

    public Parent(int parentId, String parentAddress,String fatherName, String fatherIC, String fatherContact, String fatherOccupation, String fatherOccupAddress, String motherName, String motherIC, String motherContact, String motherOccupation, String motherOccupAddress) {
        this.parentId = parentId;
        this.parentAddress=parentAddress;
        this.fatherName = fatherName;
        this.fatherIC = fatherIC;
        this.fatherContact = fatherContact;
        this.fatherOccupation = fatherOccupation;
        this.fatherOccupAddress = fatherOccupAddress;
        this.motherName = motherName;
        this.motherIC = motherIC;
        this.motherContact = motherContact;
        this.motherOccupation = motherOccupation;
        this.motherOccupAddress = motherOccupAddress;
    }

    public int getParentId() {
        return parentId;
    }
    
    public String getParentAddress() {
        return parentAddress;
    }
    
    public String getFatherName() {
        return fatherName;
    }

    public String getFatherIC() {
        return fatherIC;
    }

    public String getFatherContact() {
        return fatherContact;
    }

    public String getFatherOccupation() {
        return fatherOccupation;
    }

    public String getFatherOccupAddress() {
        return fatherOccupAddress;
    }

    public String getMotherName() {
        return motherName;
    }

    public String getMotherIC() {
        return motherIC;
    }

    public String getMotherContact() {
        return motherContact;
    }

    public String getMotherOccupation() {
        return motherOccupation;
    }

    public String getMotherOccupAddress() {
        return motherOccupAddress;
    }
    
    
    
}
