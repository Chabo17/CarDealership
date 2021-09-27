/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.carDealership.dao;

import com.sg.carDealership.dto.Inquire;
import com.sg.carDealership.dto.Specials;
import java.util.List;

/**
 *
 * @author pierre
 */
public interface InquireDao 
{
    
    Inquire getInquireById(int id);
    
    List<Inquire> getAllIquires();
    
    Inquire addInquire(Inquire inquire);
    
    void updateInquire(Inquire inquire);
    
    void deleteInquireById(int id);
    
}
