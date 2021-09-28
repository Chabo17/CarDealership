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
    public String displayCars(Model model) {
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
    
    @PostMapping("addCars")
    public String addCar(Cars car, HttpServletRequest request) {
        String makeChoice = request.getParameter("makelist");
        
//        String[] studentIds = request.getParameterValues("studentId");
//        
//        course.setTeacher(teacherDao.getTeacherById(Integer.parseInt(teacherId)));
//        
//        List<Student> students = new ArrayList<>();
//        for(String studentId : studentIds) {
//            students.add(studentDao.getStudentById(Integer.parseInt(studentId)));
//        }
//        course.setStudents(students);
//        courseDao.addCourse(course);
//        
        return "redirect:/admin/cars";
    }
    
    
    
}
