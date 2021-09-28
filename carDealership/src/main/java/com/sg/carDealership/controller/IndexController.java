package com.sg.carDealership.controller;

import com.sg.carDealership.dao.CarsDao;
import com.sg.carDealership.dao.CarsDaoDbImpl;
import com.sg.carDealership.dto.Cars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping("")
public class IndexController {

    @Autowired
    CarsDao carDao;

    @GetMapping("/featured")
    public String displayFeaturedCars(Model model){
        List<Cars> cars = carDao.getFeaturedCars();
        boolean isLoaded = cars.size() == 8;
        model.addAttribute("isLoaded", isLoaded);
        model.addAttribute("featuredCars", cars);
        return "featured";
    }

}
