/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Universities;

/**
 *
 * @author brando
 */
public class UniversityDoaImpl implements UniversityDao{

    @Override
    public ArrayList<Universities> getAll() {

        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://localhost:1527/linkedu";
        Connection DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");

        String query = "SELECT * FROM LINKEDU.UNIVERSITY";
        
        ArrayList<Universities> univ = new ArrayList<Universities>();
        
        try{
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            String username, password, officialName;
            int universityID;

            while(rs.next()){
                
                username = rs.getString("username");
                password = rs.getString("password");
                officialName = rs.getString("officialName");
                universityID = rs.getInt("universityID");
                
                Universities temp = new Universities();
                
                temp.setUnivesityID(universityID);
                temp.setUsername(username);
                temp.setPassword(password);
                temp.setOfficialName(officialName);
            
                univ.add(temp);
            } 
            
        } catch (Exception e) {
            System.err.println("ERROR: Problems with SQL select");
            e.printStackTrace();
        }
        try {
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    
        return univ;
    
    }

    @Override
    public Universities findByID(int id) {
        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://localhost:1527/linkedu";
        Connection DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");

        String query = "SELECT * FROM LINKEDU.UNIVERSITY WHERE UNIVERSITYID = " + id;
        
        Universities univ = null;
        try{
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            String username, password, officialName;
            int universityID;

            if(rs.next()){
                username = rs.getString("username");
                password = rs.getString("password");
                officialName = rs.getString("officialName");
                //universityID = rs.getInt("universityID");
                univ = new Universities();
                univ.setUnivesityID(id);
                univ.setUsername(username);
                univ.setPassword(password);
                univ.setOfficialName(officialName);
            
            } 
            
        } catch (Exception e) {
            System.err.println("ERROR: Problems with SQL select");
            e.printStackTrace();
        }
        try {
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    
        return univ;
    }
    
}