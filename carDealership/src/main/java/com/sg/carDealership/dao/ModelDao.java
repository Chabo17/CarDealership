/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.carDealership.dao;

import com.sg.carDealership.dto.MyModel;
import java.util.List;

/**
 *
 * @author pierre
 */
public interface ModelDao 
{
    
    MyModel getMyModelById(int id);
    
    List<MyModel> getAllMyModels();
    
    MyModel addMyModel(MyModel myModel);
    
    void updateMyModel(MyModel myModel);
    
    void deleteMyModelById(int id);
    
}
