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
import com.sg.carDealership.dto.Specials;
import com.sg.carDealership.dto.Users;
import java.util.ArrayList;
import java.util.List;
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
    public String showCars(Model model) {
        List<Cars> cars = carsDao.getAllCars();
        model.addAttribute("carsfiltered", cars);
        return "cars";
        
    }
    
    @GetMapping("addSpecial")
    public String addSpecialAdmin(Model model)
    {
        List<Specials> specials = specialsDao.getAllSpecials();
    
    
        model.addAttribute("specials", specials);
        
        return "addSpecials";
    }
    
    
    @PostMapping("addSpecial")
    public String addSpecialAdminRequest(String message)
    {
        Specials s = new Specials();
        s.setMessage(message);
        
        s = specialsDao.addSpecial(s);
        
        return "redirect:/admin"
        
        
    }
    
    @PostMapping("addCar")
    public String addCarRequest(Cars newcar, HttpServletRequest request)
    {
        String makeChoice = request.getParameter("make");
        String modelChoice = request.getParameter("model");
        String typeChoice = request.getParameter("carType");
        String colorChoice = request.getParameter("color");
        String interiorChoice = request.getParameter("interiorColor");
        String transChoice = request.getParameter("trans");
        String bodyChoice = request.getParameter("bodyStyle");
        
        String year = request.getParameter("year");
        String mileage = request.getParameter("mileage");
        String vinNumber = request.getParameter("vinNumber");
        String msrp = request.getParameter("msrp");
        String salesPrice = request.getParameter("salesPrice");
        String description = request.getParameter("description");
        String carName = request.getParameter("carName");
        String pictureURL = request.getParameter("pictureURL");
        
        
 
        newcar.setMake(makeChoice);
        newcar.setModel(modelChoice);
        newcar.setCarType(typeChoice);
        newcar.setBodyStyle(bodyChoice);
        newcar.setMakeYear(Integer.parseInt(year));
        newcar.setTrans(transChoice);
        newcar.setColor(colorChoice);
        newcar.setInteriorColor(interiorChoice);
        newcar.setMileage(Integer.parseInt(mileage));
        newcar.setVinNumber(vinNumber);
        newcar.setMsrp(Double.parseDouble(msrp));
        newcar.setSalesPrice(Double.parseDouble(salesPrice));
        newcar.setCarDescription(description);
        newcar.setNewCar(newcar.getMakeYear() == 2021);
        newcar.setCarName(carName);
        newcar.setPictureURL(pictureURL);
        
        
        carsDao.addCar(newcar);
        
        return "redirect:/admin/cars";
    }
    
    @GetMapping("addCar")
    public String addCarForm(Model model) {
        String[] makeList = {"Audi", "Honda", "China"};//dao get list of items
        model.addAttribute("makeList", makeList);
        
        String[] modelList = {"A4", "S", "S3"};
        model.addAttribute("modelList", modelList);
        
        String[] typeList = {"New", "Used", "Broken"};
        model.addAttribute("typeList", typeList);
        
        String[] bodyList = {"Car", "SUV", "COUPE"};
        model.addAttribute("bodyList", bodyList);
        
        String[] transList = {"Automatic", "Manual"};
        model.addAttribute("transList", transList);
        
        String[] colorList = {"Black", "Red", "White"};
        model.addAttribute("colorList", colorList);
        
        String[] interList = {"Gold", "Black", "Silver"};
        model.addAttribute("interList", interList);
        
        return "addCar";
    }
    
    @GetMapping("deleteCar")
    public String deleteCar(Integer id) {
        carsDao.deleteCarById(id);
        return "redirect:/admin/cars";
    }
    
    @GetMapping("deleteUser")
    public String deleteUser(Integer id) {
        usersDao.deleteUserById(id);
        return "redirect:/admin/users";
    }
    
    @GetMapping("users")
    public String displayUsers(Model model) {
        List<Users> users = usersDao.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }
    
    
    @GetMapping("addUser")
    public String addUser(Model model) {
        String[] roles = {"User", "Admin"};
        model.addAttribute("roles", roles);
        return "addUser";
    }
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

    
    
    @GetMapping("editCar")
    public String editCar(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        Cars car = carsDao.getCarById(id);
        
        String[] makeList = {"Audi", "Honda", "China"};//dao get list of items
        model.addAttribute("makeList", makeList);
        
        String[] modelList = {"A4", "S", "S3"};
        model.addAttribute("modelList", modelList);
        
        String[] typeList = {"New", "Used", "Broken"};
        model.addAttribute("typeList", typeList);
        
        String[] bodyList = {"Car", "SUV", "COUPE"};
        model.addAttribute("bodyList", bodyList);
        
        String[] transList = {"Automatic", "Manual"};
        model.addAttribute("transList", transList);
        
        String[] colorList = {"Black", "Red", "White"};
        model.addAttribute("colorList", colorList);
        
        String[] interList = {"Gold", "Black", "Silver"};
        model.addAttribute("interList", interList);
        
        
        
        model.addAttribute("selectedCar", car);
        return "editCars";
    }
    
    @PostMapping("editCar")
    public String performEditCar(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Cars newcar = carsDao.getCarById(id);
        
        String makeChoice = request.getParameter("make");
        String modelChoice = request.getParameter("model");
        String typeChoice = request.getParameter("carType");
        String colorChoice = request.getParameter("color");
        String interiorChoice = request.getParameter("interiorColor");
        String transChoice = request.getParameter("trans");
        String bodyChoice = request.getParameter("bodyStyle");
        
        String year = request.getParameter("year");
        String mileage = request.getParameter("mileage");
        String vinNumber = request.getParameter("vinNumber");
        String msrp = request.getParameter("msrp");
        String salesPrice = request.getParameter("salesPrice");
        String description = request.getParameter("description");
        String carName = request.getParameter("carName");
        String pictureURL = request.getParameter("pictureURL");
        
        
 
        newcar.setMake(makeChoice);
        newcar.setModel(modelChoice);
        newcar.setCarType(typeChoice);
        newcar.setBodyStyle(bodyChoice);
        newcar.setMakeYear(Integer.parseInt(year));
        newcar.setTrans(transChoice);
        newcar.setColor(colorChoice);
        newcar.setInteriorColor(interiorChoice);
        newcar.setMileage(Integer.parseInt(mileage));
        newcar.setVinNumber(vinNumber);
        newcar.setMsrp(Double.parseDouble(msrp));
        newcar.setSalesPrice(Double.parseDouble(salesPrice));
        newcar.setCarDescription(description);
        newcar.setNewCar(newcar.getMakeYear() == 2021);
        newcar.setCarName(carName);
        newcar.setPictureURL(pictureURL);
        
        carsDao.updateCar(newcar);
        
        return "redirect:/admin/cars";
    }
     
    
//    @GetMapping("editUser")
//    public String editCar(HttpServletRequest request, Model model) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Teacher teacher = teacherDao.getTeacherById(id);
//        
//        model.addAttribute("teacher", teacher);
//        return "editTeacher";
//    }
//    
//    @PostMapping("editUser")
//    public String performEditTeacher(HttpServletRequest request) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Teacher teacher = teacherDao.getTeacherById(id);
//        
//        teacher.setFirstName(request.getParameter("firstName"));
//        teacher.setLastName(request.getParameter("lastName"));
//        teacher.setSpecialty(request.getParameter("specialty"));
//        
//        teacherDao.updateTeacher(teacher);
//        
//        return "redirect:/teachers";
//    }
//     
    
    
}
