/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.carDealership.controller;

import com.sg.carDealership.dao.CarsDao;
import com.sg.carDealership.dao.InquireDao;
import com.sg.carDealership.dao.SpecialsDao;
import com.sg.carDealership.dto.Inquire;
import com.sg.carDealership.dto.Specials;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author pierre
 */

@Controller
@RequestMapping("/home")
public class HomeController 
{
    @Autowired
    SpecialsDao specialDao;
    
    @Autowired
    CarsDao carDao;
    
    @Autowired
    InquireDao inquireDao;
    
    
    
    @GetMapping("/specials")
    public String displaySpecials(Model model) {
   
        
        List<Specials> specials = specialDao.getAllSpecials();
    
    
        model.addAttribute("specials", specials);
        
        return "specials";
    }
 
    
    @PostMapping("/addInquire")
    public String addSpecial(String name, String email, String phone, String message)
    {
        Inquire inquire = new Inquire();
        
        inquire.setInquireName(name);
        inquire.setEmail(email);
        inquire.setPhone(phone);
        inquire.setMessage(message);
        
        inquireDao.addInquire(inquire);
        
        
        return "index";
        
    }
    
    
    
    
}
