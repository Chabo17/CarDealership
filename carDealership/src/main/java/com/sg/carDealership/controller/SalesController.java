/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.carDealership.controller;

import com.sg.carDealership.dao.CarsDao;
import com.sg.carDealership.dao.Sales_Information_Record_DaoDbImpl;
import com.sg.carDealership.dto.Cars;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("/sales")
public class SalesController {
    
    @Autowired
    CarsDao carsDao;

    @Autowired
    Sales_Information_Record_DaoDbImpl Sales;

    @GetMapping("index")
    public String ShowAllModels(Model model){
        List<Cars> allSearch = carsDao.getAllCars();
        model.addAttribute("cars", allSearch);
        return "salesDisplay";
    }
    
    @GetMapping("purchase")
    public String SalesPurchase(HttpServletRequest request,Model model){
        int id = Integer.parseInt(request.getParameter("id"));
        Cars car = carsDao.getCarById(id);
        model.addAttribute("car", car);
        
        return "purchase";
    }
    
}
