/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.carDealership.dao;

import com.sg.carDealership.dto.Specials;
import java.util.List;

/**
 *
 * @author pierre
 */
public interface SpecialsDao 
{
    
    
    Specials getSpecialById(int id);
    
    List<Specials> getAllSpecials();
    
    Specials addSpecial(Specials special);
    
    void updateSpecial(Specials special);
    
    void deleteSpecialById(int id);
    
    
}
