/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.LoginDao;
import dao.LoginDaoImpl;
import java.io.Serializable;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;
import model.LoginBean;

/**
 *
 * @author bmgrayb
 */
@Named(value = "loginController")
@SessionScoped
public class LoginController implements Serializable {

    // This is the model that captures the user profile info
    private LoginBean theModel;
    // This corresponds to the response to be sent back to the client
    private String response;
    //max number of login tries
    private final int MAXTRIES = 3;
    //current number of tries
    private int numTries = 0;
    
    /**
     * Creates a new instance of LoginController
     */
    public LoginController() {
        theModel = new LoginBean();
    }

    /**
     * @return the theModel
     */
    public LoginBean getTheModel() {
        return theModel;
    }

    /**
     * @param theModel the theModel to set
     */
    public void setTheModel(LoginBean theModel) {
        this.theModel = theModel;
    }

    /**
     * @return the response
     */
    public String getResponse() {
        numTries++;
        if (numTries < MAXTRIES)
            if(!validate())
                return "Sorry, Incorrect Login!";     
       
        return "Exceeded total number of tries...";
        
    }

    /**
     * @param response the response to set
     */
    public void setResponse(String response) {
        this.response = response;
    }
    
    public String submitHandler(){
        //numTries++;
        if(numTries < MAXTRIES){
            if(validate())
                return "LoginGood.xhtml";
            else
                return "LoginBad.xhtml";
        }
        else
            return "LoginBad.xhtml";
    }
    
    private boolean validate(){
        LoginDao dao = new LoginDaoImpl();
        boolean valid = dao.validate(theModel.getUsername(), theModel.getPassword());
        return valid;
    }
    
    public void checkIfLoggedIn(){
        boolean loggedIn = false;
                
        if(theModel.getUsername() != null && theModel.getUsername().length() > 0)
            loggedIn = true;
       
        String theURL;

        if (!loggedIn) { // Assume that if the time (sec) is even, then the user has NOT logged in
            theURL = "./index.xhtml"; // redirects to the Login/index page
            // Below is a long-winded (but sometime necessary) way of redirecting to another page
            FacesContext faces = FacesContext.getCurrentInstance();
            ExternalContext context = faces.getExternalContext();
            HttpServletResponse response = (HttpServletResponse) context.getResponse();
            try {
                response.sendRedirect(theURL);
                faces.responseComplete(); // need this or will get "Cannot forward after response has been committed"
                // exception. It bypasses the Render Response phase
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            ; // Do nothing and stay at the current page
        }
        
        
    }
    
}
