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
@RequestMapping("/admin")
public class AdminController {
    
   @Autowired
   CarsDao carsDao;

   @Autowired
   InquireDao inquireDao;

   @Autowired
   SpecialsDao specialsDao;
   
   @Autowired
   UsersDao usersDao;
   
   @GetMapping
    public String showAdminPage(Model model) {
        return "admin";
    }
    
    @GetMapping("cars")
    public String displayCars(Model model) {
        //List<Cars> cars = carsDao.getAllCars();
        //model.addAttribute("cars", cars);
        return "cars";
    }
    
    @GetMapping("users")
    public String displayUsers(Model model) {
        //List<Cars> cars = carsDao.getAllCars();
        //model.addAttribute("cars", cars);
        return "users";
    }
    
}
