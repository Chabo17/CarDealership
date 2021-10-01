package com.sg.carDealership.controller;

import com.sg.carDealership.dao.CarsDao;
import com.sg.carDealership.dao.UsersDao;
import com.sg.carDealership.dto.Cars;
import com.sg.carDealership.dto.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/reports")
public class ReportController {
    @Autowired
    CarsDao carsDao;

    @Autowired
    UsersDao usersDao;

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
    public String salesReport(Model model)
    {
        List<Users> usersNames = usersDao.getAllUsers();
        model.addAttribute("userNames", usersNames);
//        int fromDate = Integer.parseInt(request.getParameter("fromDate"));
//        int toDate = Integer.parseInt(request.getParameter("toDate"));
        return "salesReport";
    }

    @GetMapping("salesReport/search")
    public String salesReport(Model model, HttpServletRequest request) {
        String keyword = request.getParameter("userId");
        Users user = usersDao.getUserById(Integer.parseInt(keyword));
        model.addAttribute("users", user);
        return "salesReportSearch";
    }
}