/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.carDealership.dao;

import com.sg.carDealership.dto.Sales_Information_Record;
import java.util.List;

/**
 *
 * @author pierre
 */
public interface Sales_Information_Record_Dao 
{
    Sales_Information_Record getSIRById(int id);
    
    List<Sales_Information_Record> getALLSIR();
    
    Sales_Information_Record addSIR(Sales_Information_Record sir);
    
    void updateSIR(Sales_Information_Record sir);
    
    void deleteSIRById(int id);
    
}
