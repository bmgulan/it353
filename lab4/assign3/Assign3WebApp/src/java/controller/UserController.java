/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.LoginDao;
import dao.LoginDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import java.io.Serializable;
import java.util.Properties;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import model.UserBean;

/**
 *
 * @author bmgrayb
 */
@Named(value = "userController")
@SessionScoped
public class UserController implements Serializable {

    private UserBean theModel;
    private String confirmPassword;
    private String response;
    private String updateStatus;
    
    /**
     * Creates a new instance of UserController
     */
    public UserController() {
        theModel = new UserBean();
    }

    /**
     * @return the theModel
     */
    public UserBean getTheModel() {
        return theModel;
    }

    /**
     * @param theModel the theModel to set
     */
    public void setTheModel(UserBean theModel) {
        this.theModel = theModel;
    }

    /**
     * @return the response
     */
    public String getResponse() {
        String resultStr = "";
        resultStr += "Hello " + theModel.getFirstName() + " " + theModel.getLastName() + "! ";
        resultStr += "We see that you have created a user account.<br/><br/>";
        
        resultStr += "<b>Account Information Entered: </b> <br/>";
        resultStr += "UserID: " + theModel.getUserid() + "<br/>";
        resultStr += "Password: " + theModel.getPassword() + "<br/>";
        resultStr += "Email: " + theModel.getEmail() + "<br/>";
        resultStr += "Security Question: " + theModel.getQuestion() + "<br/>";
        resultStr += "Answer: " + theModel.getAnswer() + "<br/><br/>";
        
        resultStr += "If any of the information is incorrect, feel free to update it. <br/>";
        
        sendEmail(resultStr, theModel.getEmail());
        
        response = resultStr;
        return response;
    }

    /**
     * @param response the response to set
     */
    public void setResponse(String response) {
        this.response = response;
    }

    /**
     * @return the confirmPassword
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * @param confirmPassword the confirmPassword to set
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    
    public String createUser(){
        int user = 0;
        int login = 0;
        if(checkPassword()){
            UserDao dao = new UserDaoImpl();
            user = dao.createUser(theModel);
            LoginDao lDao = new LoginDaoImpl();
            login = lDao.insertUser(theModel); 
        }
        
        if(login == 1 && user == 1)
            return "echo.xhtml";
        else
            return "error.xhtml";
    }
    
    private boolean checkPassword(){
        boolean valid = false;
        
        if(confirmPassword.equals(theModel.getPassword()))
            valid = true;
        
        return valid;
    }
    
    private boolean sendEmail(String text, String email){
        boolean valid = false;
        
         // Recipient's email ID needs to be mentioned.
        String to = email;

        // Sender's email ID needs to be mentioned
        String from = "bmgrayb@ilstu.edu";

        // Assuming you are sending email from this host
        String host = "smtp.ilstu.edu";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.user", "yourID"); // if needed
        properties.setProperty("mail.password", "yourPassword"); // if needed

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("User Account Creation");

            // Send the actual HTML message, as big as you like
            message.setContent(text,
                    "text/html");

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
        
        return valid;
    }
    
    public void updateThis() {
        UserDao aProfileDAO = new UserDaoImpl();    // Creating a new object each time.
        int status = aProfileDAO.updateUser(theModel); // Doing anything with the object after this?
        if (status != 0) {
            setUpdateStatus("Record updated successfully ...");
        } else {
            setUpdateStatus("Record update failed!");
        }

    }

    /**
     * @return the updateStatus
     */
    public String getUpdateStatus() {
        return updateStatus;
    }

    /**
     * @param updateStatus the updateStatus to set
     */
    public void setUpdateStatus(String updateStatus) {
        this.updateStatus = updateStatus;
    }
    
}
