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
public class Universities {
    
    private String username;
    private String password;
    private int univesityID;
    private String officialName;
    private String availability;
    private String address;
    private String city;
    private String stabbr;
    private String zip;
    private String email;
    private boolean isFeatured;
    
    public Universities(){}

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the univesityID
     */
    public int getUnivesityID() {
        return univesityID;
    }

    /**
     * @param univesityID the univesityID to set
     */
    public void setUnivesityID(int univesityID) {
        this.univesityID = univesityID;
    }

    /**
     * @return the officialName
     */
    public String getOfficialName() {
        return officialName;
    }

    /**
     * @param officialName the officialName to set
     */
    public void setOfficialName(String officialName) {
        this.officialName = officialName;
    }

    /**
     * @return the availability
     */
    public String getAvailability() {
        return availability;
    }

    /**
     * @param availability the availability to set
     */
    public void setAvailability(String availability) {
        this.availability = availability;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the stabbr
     */
    public String getStabbr() {
        return stabbr;
    }

    /**
     * @param stabbr the stabbr to set
     */
    public void setStabbr(String stabbr) {
        this.stabbr = stabbr;
    }

    /**
     * @return the zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * @param zip the zip to set
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the isFeatured
     */
    public boolean isIsFeatured() {
        return isFeatured;
    }

    /**
     * @param isFeatured the isFeatured to set
     */
    public void setIsFeatured(boolean isFeatured) {
        this.isFeatured = isFeatured;
    }
    
}
