/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.carDealership.dao;

import com.sg.carDealership.dto.Cars;
import java.util.List;

/**
 *
 * @author pierre
 */
public interface CarsSearchDao 
{
    
    List<Cars> getfilteredCars(String keyword);
    
    // List<Cars> getNewFilteredCars(String keyword);
    
    // List<Cars> getUsedFilteredCars(String keyword);
    
}
