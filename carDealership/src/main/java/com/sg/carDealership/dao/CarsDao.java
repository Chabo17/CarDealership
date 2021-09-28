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
public interface CarsDao 
{
    
    
    Cars getCarById(int id);
    
    List<Cars> getAllNewCars();
    
    List<Cars> getAllCars();
    
    List<Cars> getAllUsedCars();
    
    List<Cars> getFeaturedCars();
    
    Cars addCar(Cars car);
    
    void updateCar(Cars car);
    
    void deleteCarById(int id);
    
    
    
}
