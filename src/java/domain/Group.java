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
public class Group {
    int groupId;
    int groupAge;

    public Group(int groupId, int groupAge) {
        this.groupId = groupId;
        this.groupAge = groupAge;
    }

    public int getGroupId() {
        return groupId;
    }

    public int getGroupAge() {
        return groupAge;
    }
    
}
