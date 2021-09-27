/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.carDealership.controller;

import com.sg.carDealership.dao.CarsDao;
import com.sg.carDealership.dao.InquireDao;
import com.sg.carDealership.dao.SpecialsDao;
import com.sg.carDealership.dao.UsersDao;
import com.sg.carDealership.dto.Cars;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author xwang2945
 */
@Controller
@RequestMapping("/inventory")
public class InventoryController {
   @Autowired
   CarsDao carsDao;

   @Autowired
   InquireDao inquireDao;

   @Autowired
   SpecialsDao specialsDao;
   
   @Autowired
   UsersDao usersDao;
   
   @GetMapping("/used")
    public String showUsedSearch(Model model) {
    /*
        // Pierre
        // Added these commented lines
        
        // Uncomment to make effective
        
        // List<Cars> usedcars = carsDao.getAllUsedCars();
        // model.addAttribute("condition", "Used");             // IDK if this line is still useful
        // model.addAttribute("myInventory", usedcars);
        // return "inventory";
        
        //POL
    */
        
        model.addAttribute("condition", "Used");
        return "inventory";
    }
   @GetMapping("/new")
    public String showNewSearch(Model model) {
         /*
        // Pierre
        // Added these commented lines
        
        // Uncomment to make effective
        
        // List<Cars> usedcars = carsDao.getAllNewCars();
        // model.addAttribute("condition", "New");              // IDK if this line is still useful
        // model.addAttribute("myInventory", usedcars);         // call text="${myInventory.attribute}" attribute in inventory.html
        // return "inventory";                                  // lead to inventory.html
        
        //POL
    */
        model.addAttribute("condition", "New");
        return "inventory";
    }
   
   
}
