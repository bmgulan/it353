/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UniversityDao;
import dao.UniversityDoaImpl;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Universities;

/**
 *
 * @author brando
 */
@ManagedBean
@SessionScoped
public class UniversityBean {

    private String response;
    private ArrayList<Universities> univ;
    private String inputId;
    
    /**
     * Creates a new instance of UniversityBean
     */
    public UniversityBean() {
        univ = new ArrayList<Universities>();
        //inputId = -1;
    }

    /**
     * @return the response
     */
    public String getResponse() {
        return response;
    }

    /**
     * @param response the response to set
     */
    public void setResponse(String response) {
        this.response = response;
    }

    /**
     * @return the univ
     */
    public ArrayList<Universities> getUniv() {
        
        if(inputId.length() == 0){
           univ = (new UniversityDoaImpl().getAll());
        }
        else{
            univ = new ArrayList<Universities>();
            Universities temp = (new UniversityDoaImpl().findByID(Integer.parseInt(inputId)));
            univ.add(temp);
        }
     
        return univ;
    }

    /**
     * @param univ the univ to set
     */
    public void setUniv(ArrayList<Universities> univ) {
        this.univ = univ;
    }

    /**
     * @return the inputId
     */
    public String getInputId() {
        return inputId;
    }

    /**
     * @param inputId the inputId to set
     */
    public void setInputId(String inputId) {
        this.inputId = inputId;
    }
    
}
