/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.carDealership.controller;

import com.sg.carDealership.dao.CarsDao;
import com.sg.carDealership.dao.CarsSearchDao;
import com.sg.carDealership.dao.InquireDao;
import com.sg.carDealership.dao.SpecialsDao;
import com.sg.carDealership.dao.UsersDao;
import com.sg.carDealership.dto.Cars;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
   
       
    @Autowired
    CarsSearchDao searchDao;
   
   private int[] price = new int[20];
   private int[] year = new int[20];

   
   private Model searchBoxPopulate(Model model){
        for(int i=0; i < price.length; i++){
            price[i] = (i*5000);
        }

        model.addAttribute("minprices", price);
        model.addAttribute("maxprices", price);
        

        int counter = 0;
        for(int i=2021; i > 2021-(year.length*5); i-=5){
            year[counter] = i;
            counter++;
        }
        
        model.addAttribute("minyears", year);
        model.addAttribute("maxyears", year);
       
       return model;
   }
   
   
   @GetMapping("used")
    public String showUsedSearch(Model model) {

    
        model = searchBoxPopulate(model);
        List<Cars> cars = carsDao.getAllCars();
        List<Cars> usedCars = cars.stream().filter(c -> c.getMileage() > 0).collect(Collectors.toList());
        model.addAttribute("carsfiltered", usedCars);
        
        
        model.addAttribute("condition", "Used");
        model.addAttribute("minpricevalue", price[0]);
        model.addAttribute("maxpricevalue", price[price.length-1]);
        model.addAttribute("minyearvalue", year[0]);
        model.addAttribute("maxyearvalue", year[price.length-1]);
        
        return "inventoryUsed";
    }
   @GetMapping("new")
    public String showNewSearch(Model model) {
        
        
        model = searchBoxPopulate(model);
        List<Cars> cars = carsDao.getAllCars();
        List<Cars> newCars = cars.stream().filter(c -> c.getMileage() == 0).collect(Collectors.toList());
        model.addAttribute("carsfiltered", newCars);
        model.addAttribute("condition", "New");
        model.addAttribute("minpricevalue", price[0]);
        model.addAttribute("maxpricevalue", price[price.length-1]);
        model.addAttribute("minyearvalue", year[0]);
        model.addAttribute("maxyearvalue", year[price.length-1]);
        
        
        return "inventoryNew";
    }
    
    @PostMapping("inventoryNewSearch")
    public String performNewSearch(HttpServletRequest request, Model model) {
        
        String minpriceString = request.getParameter("minprice");
        String maxpriceString = request.getParameter("maxprice");
        String minyearString = request.getParameter("minyear");
        String maxyearString = request.getParameter("maxyear");
        String searchBar = request.getParameter("searchName");
        
        
        
        
        double minprice = Double.parseDouble(minpriceString);
        double maxprice = Double.parseDouble(maxpriceString);
        double minyear = Double.parseDouble(minyearString);
        double maxyear = Double.parseDouble(maxyearString);
        
        model = searchBoxPopulate(model);
        model.addAttribute("condition", "New");
        
        model.addAttribute("minpricevalue", minprice);
        model.addAttribute("maxpricevalue", maxprice);
        model.addAttribute("minyearvalue", minyear);
        model.addAttribute("maxyearvalue", maxyear);
        model.addAttribute("searchvalue", searchBar);
        
        List<Cars> carList = carsDao.getAllCars();
        
        List<Cars> tempList;
        if(searchBar == null || searchBar.strip().isEmpty()){
            //search bar is empty
            tempList = carList
                .stream()
                .filter(c -> c.getMakeYear() >= minyear && c.getMakeYear() <= maxyear && c.getSalesPrice() >= minprice && c.getSalesPrice() <= maxprice && c.getMileage() == 0)
                .collect(Collectors.toList());
            
        }else{
            tempList = carList
                .stream()
                .filter(c -> c.getMakeYear() >= minyear && 
                        c.getMakeYear() <= maxyear && 
                        c.getSalesPrice() >= minprice && 
                        c.getSalesPrice() <= maxprice && 
                        c.getMileage() == 0 && 
                        (c.getMakeYear() + " " + c.getMake() + " " + c.getModel()).toUpperCase().contains(searchBar.strip().toUpperCase()))
                .collect(Collectors.toList());
            
        }
        

        model.addAttribute("carsfiltered", tempList);
        
        return "inventoryNewSearch";
    }
    
    
    @PostMapping("inventoryUsedSearch")
    public String performUsedSearch(HttpServletRequest request, Model model) {
        
        String minpriceString = request.getParameter("minprice");
        String maxpriceString = request.getParameter("maxprice");
        String minyearString = request.getParameter("minyear");
        String maxyearString = request.getParameter("maxyear");
        String searchBar = request.getParameter("searchName");
        
        
        double minprice = Double.parseDouble(minpriceString); //needs to be double
        double maxprice = Double.parseDouble(maxpriceString);
        double minyear = Double.parseDouble(minyearString);
        double maxyear = Double.parseDouble(maxyearString);
        
        model = searchBoxPopulate(model);
        model.addAttribute("condition", "Used");
        
        model.addAttribute("minpricevalue", minprice);
        model.addAttribute("maxpricevalue", maxprice);
        model.addAttribute("minyearvalue", minyear);
        model.addAttribute("maxyearvalue", maxyear);
        model.addAttribute("searchvalue", searchBar);
        
        List<Cars> carList = carsDao.getAllCars();
        List<Cars> tempList;
        if(searchBar == null || searchBar.strip().isEmpty()){
            //search bar is empty
            tempList = carList
                .stream()
                .filter(c -> c.getMakeYear() >= minyear && 
                        c.getMakeYear() <= maxyear && 
                        c.getSalesPrice() >= minprice && 
                        c.getSalesPrice() <= maxprice && 
                        c.getMileage() > 0)
                .collect(Collectors.toList());
            
        }else{
            tempList = carList
                .stream()
                .filter(c -> c.getMakeYear() >= minyear && 
                        c.getMakeYear() <= maxyear && 
                        c.getSalesPrice() >= minprice && 
                        c.getSalesPrice() <= maxprice && 
                        c.getMileage() > 0 && 
                        (c.getMakeYear() + " " + c.getMake() + " " + c.getModel()).toUpperCase().contains(searchBar.strip().toUpperCase()))
                .collect(Collectors.toList());
            
        }
        
        

        model.addAttribute("carsfiltered", tempList);
        
        return "inventoryUsedSearch";
    }
    
    @GetMapping("details")
    public String getCarDetails(HttpServletRequest request, Model model){
        int id = Integer.parseInt(request.getParameter("id"));
        Cars cars = carsDao.getCarById(id);
        model.addAttribute("car", cars);
        
        return "carDetails";
    }

 
   
   
}
