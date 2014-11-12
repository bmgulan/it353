/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import model.UserBean;

/**
 *
 * @author bmgrayb
 */
public interface UserDao {
    public int createUser(UserBean user);
    public UserBean returnUser(String id);
    public boolean validUserId(String id);
    public int updateUser(UserBean user);
}
