package com.sg.carDealership.controller;

import com.sg.carDealership.dao.CarsDao;
import com.sg.carDealership.dto.Cars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/reports")
public class ReportController {
    @Autowired
    CarsDao carsDao;

    @GetMapping
    public String showReportsPage() {
        return "reports";
    }

    @GetMapping("inventoryReport")
    public String inventoryReport(Model model) {
        List<Cars> newCars = carsDao.getAllNewCars();
        List<Cars> usedCars = carsDao.getAllUsedCars();
        model.addAttribute("newCars", newCars);
        model.addAttribute("usedCars", usedCars);
        return "inventoryReport";
    }

    @GetMapping("salesReport")
    public String salesReport() {
        return "salesReport";
    }
}