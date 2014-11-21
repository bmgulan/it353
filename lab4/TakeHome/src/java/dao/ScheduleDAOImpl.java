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
import model.ScheduleBean;

/**
 *
 * @author brando
 */
public class ScheduleDAOImpl implements ScheduleDAO {

    @Override
    public ArrayList<ScheduleBean> getAll() {

        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://localhost:1527/demotime";
        Connection DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");

        String query = "SELECT * FROM itkstu.Schedule";
        
        ArrayList<ScheduleBean> sched = new ArrayList<ScheduleBean>();
    
        try{
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            String slotTime, groupName;
            int id;

            while(rs.next()){
                
                slotTime = rs.getString("slotTime");
                groupName = rs.getString("groupName");
                id = rs.getInt("id");
                
                ScheduleBean temp = new ScheduleBean();
                
                temp.setId(id);
                temp.setGroupName(groupName);
                temp.setSlotTime(slotTime);
                
                sched.add(temp);
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
        
        
        return sched;
    }

    @Override
    public int update(ScheduleBean s) {

        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://localhost:1527/demotime";
        Connection DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");
        String query = "Select * from itkstu.schedule where id = " + s.getId();
        
        int row = 0;
        boolean canAdd = false;
        
        try{
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            String name="";
            
            if(rs.next())
                name = rs.getString("groupname");
            
            if(name ==  null)
                canAdd = true;
            
            System.out.println("Insert String: " + query);
            DBConn.close();
            
        } catch(SQLException e){
            System.err.println(e.getMessage());
        }
        
        if(canAdd)
            row = updateHelper(s);
        
        return row;
        
    }
    
    private int updateHelper(ScheduleBean s){
        int row = 0;
        
        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://localhost:1527/demotime";
        Connection DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");
        String update = "Update itkstu.schedule "
        + "set groupname = '" + s.getGroupName() + "' "
        + "where id = " + s.getId();

        try{
            Statement stmt = DBConn.createStatement();
            row = stmt.executeUpdate(update);
            System.out.println("Update String: " + update);
            DBConn.close();

        } catch(SQLException e){
            System.err.println(e.getMessage());
        }
        
        return row;
    }
    
}
