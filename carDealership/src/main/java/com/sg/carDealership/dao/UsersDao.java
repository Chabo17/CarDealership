/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.carDealership.dao;

import com.sg.carDealership.dto.Users;
import java.util.List;

/**
 *
 * @author pierre
 */
public interface UsersDao 
{
    Users getUserById(int id);
    
    List<Users> getAllUsers();
    
    
    Users addUser(Users user);
    
    void updateUser(Users user);
    
    void deleteUserById(int id);    
    
    
}
