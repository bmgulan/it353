/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author brando
 */
public class ScheduleBean {
    
    private int id;
    private String slotTime;
    private String groupName;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the slotTime
     */
    public String getSlotTime() {
        return slotTime;
    }

    /**
     * @param slotTime the slotTime to set
     */
    public void setSlotTime(String slotTime) {
        this.slotTime = slotTime;
    }

    /**
     * @return the groupName
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * @param groupName the groupName to set
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    
    
    
}
