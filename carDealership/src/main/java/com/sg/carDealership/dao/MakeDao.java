/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.carDealership.dao;

import com.sg.carDealership.dto.Make;
import java.util.List;

/**
 *
 * @author pierre
 */
public interface MakeDao 
{
    Make getMakeById(int id);
    
    List<Make> getAllMake();
    
    Make addMake(Make make);
    
    void updateMake(Make make);
    
    void deleteMakeById(int id);
}
