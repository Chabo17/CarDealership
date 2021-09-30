/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.carDealership.controller;

import com.sg.carDealership.dao.CarsDao;
import com.sg.carDealership.dao.Sales_Information_Record_DaoDbImpl;
import com.sg.carDealership.dto.Cars;
import com.sg.carDealership.dto.Sales_Information_Record;
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
@RequestMapping("/sales")
public class SalesController {
    
    @Autowired
    CarsDao carsDao;

    @Autowired
    Sales_Information_Record_DaoDbImpl Sales;

    

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
   
    @GetMapping("index")
    public String ShowAllModels(Model model){
        
        
        List<Cars> allSearch = carsDao.getAllCars();
        
        
        model = searchBoxPopulate(model);
        model.addAttribute("carsfiltered", allSearch);
        model.addAttribute("condition", "Sales");
        model.addAttribute("minpricevalue", price[0]);
        model.addAttribute("maxpricevalue", price[price.length-1]);
        model.addAttribute("maxyearvalue", year[0]);
        model.addAttribute("minyearvalue", year[price.length-1]);
        
        return "salesDisplay";
    }
    
    
    @PostMapping("salesSearch")
    public String performSalesSearch(HttpServletRequest request, Model model) {
        
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
                        c.getSalesPrice() <= maxprice)
                .collect(Collectors.toList());
            
        }else{
            tempList = carList
                .stream()
                .filter(c -> c.getMakeYear() >= minyear && 
                        c.getMakeYear() <= maxyear && 
                        c.getSalesPrice() >= minprice && 
                        c.getSalesPrice() <= maxprice &&
                        (c.getMakeYear() + " " + c.getMake() + " " + c.getModel()).toUpperCase().contains(searchBar.strip().toUpperCase()))
                .collect(Collectors.toList());
            
        }
        
        

        model.addAttribute("carsfiltered", tempList);
        
        return "salesSearch";
    }
    
    
    
    @GetMapping("purchase")
    public String SalesPurchase(HttpServletRequest request, Model model){
        int id = Integer.parseInt(request.getParameter("id"));
        Cars car = carsDao.getCarById(id);
        model.addAttribute("car", car);
        
        return "purchase";
    }
    
    @PostMapping("addSale")
    public String addSale(HttpServletRequest request){
        String name = request.getParameter("Name");
        String phone = request.getParameter("Phone");
        String email = request.getParameter("Email");
        String street1 = request.getParameter("Street1");
        String street2 = request.getParameter("Street2");
        String city = request.getParameter("City");
        String state = request.getParameter("State");
        String zip = request.getParameter("Zipcode");
        String pPrice = request.getParameter("pPrice"); 
        int Price = Integer.parseInt(pPrice);
        String pType = request.getParameter("pType");
        String fin = request.getParameter("Fin");
        
        Sales_Information_Record sir = new Sales_Information_Record();
        sir.setS_i_names(name);
        sir.setS_i_phone(phone);
        sir.setS_i_email(email);
        sir.setS_i_street_1(street1);
        sir.setS_i_street_2(street2);
        sir.setS_i_city(city);
        sir.setS_i_state(state);
        sir.setS_i_zipcode(zip);
        sir.setS_r_purchase_price(Price);
        sir.setS_r_purchase_type(pType);
        
        Sales.addSIR(sir);
        
        return "redirect:/featured";
    }
    
    /*
    @PostMapping("addUser")
    public String addUserRequest(Users newUser, HttpServletRequest request) {
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String cpassword = request.getParameter("cpassword");
        String role = request.getParameter("role");
        
        newUser.setFirstName(fname);
        newUser.setLastName(lname);
        newUser.setEmail(email);
        newUser.setUserPassword(password);
        newUser.setUserRole(role);
        
        usersDao.addUser(newUser);
        return "redirect:/admin/users";
    }
    */
    
}
