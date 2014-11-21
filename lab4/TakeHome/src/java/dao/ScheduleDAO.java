/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.ScheduleBean;

/**
 *
 * @author brando
 */
public interface ScheduleDAO {
    
    public ArrayList<ScheduleBean> getAll();
    public int update(ScheduleBean s);
    
}
