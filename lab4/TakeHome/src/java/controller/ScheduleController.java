/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ScheduleDAO;
import dao.ScheduleDAOImpl;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.ScheduleBean;

/**
 *
 * @author brando
 */
@ManagedBean
@SessionScoped
public class ScheduleController {

    private String response ="";
    private ArrayList<ScheduleBean> schedule;
    private String groupName;
    private int index;

    public ScheduleController(){
        schedule = new ArrayList<ScheduleBean>();
    }
    
    /**
     * @return the response
     */
    public String getResponse() {

        ScheduleDAO dao = new ScheduleDAOImpl();
        ScheduleBean temp = new ScheduleBean();
        temp.setGroupName(groupName);
        temp.setId(index);
       
        int status = dao.update(temp);
        
        if(status ==1)
            return "success.xhtml";
        
        return "error.xhtml";
    }

    /**
     * @param response the response to set
     */
    public void setResponse(String response) {
        this.response = response;
    }

    /**
     * @return the schedule
     */
    public ArrayList<ScheduleBean> getSchedule() {
        schedule = (new ScheduleDAOImpl().getAll());
        return schedule;
    }

    /**
     * @param schedule the schedule to set
     */
    public void setSchedule(ArrayList<ScheduleBean> schedule) {
        this.schedule = schedule;
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

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(int index) {
        this.index = index;
    }
    
}
