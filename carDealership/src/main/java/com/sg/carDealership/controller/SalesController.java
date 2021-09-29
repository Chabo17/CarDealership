/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.carDealership.controller;

import com.sg.carDealership.dao.Sales_Information_Record_DaoDbImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author xwang2945
 */
@Controller
@RequestMapping("/sales")
public class SalesController {

    @Autowired
    Sales_Information_Record_DaoDbImpl Sales;

    @GetMapping("/Index")
    public String ShowAllModels(){
        
        return "/Index";
    }
    
}
