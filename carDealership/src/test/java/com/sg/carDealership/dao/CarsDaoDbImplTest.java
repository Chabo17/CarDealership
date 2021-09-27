/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.carDealership.dao;

import com.sg.carDealership.dto.Cars;
import com.sg.carDealership.dto.Sales_Information_Record;
import com.sg.carDealership.dto.Users;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author pierre
 */

@SpringBootTest
public class CarsDaoDbImplTest {
    
    
    @Autowired
    UsersDao userDao;
    
    @Autowired
    CarsDao carDao;
    
    @Autowired
    Sales_Information_Record_Dao sirDao;
    
    
    public CarsDaoDbImplTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        
        
        
        
        List<Sales_Information_Record> sirs = sirDao.getALLSIR();
        for(Sales_Information_Record sir : sirs)
        {
            sirDao.deleteSIRById(sir.getId());
        }
        
        List<Users> users = userDao.getAllUsers();
        for(Users user : users)
        {
            userDao.deleteUserById(user.getId());
        }
        
        List<Cars> newcars = carDao.getAllNewCars();
        for(Cars car : newcars)
        {
            carDao.deleteCarById(car.getId());
        }

        List<Cars> usedcars = carDao.getAllUsedCars();
        for(Cars car : usedcars)
        {
            carDao.deleteCarById(car.getId());
        }        
        
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getCarById method, of class CarsDaoDbImpl.
     */
    @Test
    public void testAddGetCar() 
    {
        Cars car = new Cars();
        car.setBodyStyle("low");
        car.setCarDescription("Beautiful");
        car.setCarName("Civic");
        car.setCarType("Sport");
        car.setColor("Sunset");
        car.setInteriorColor("Leather");
        car.setMake("Honda");
        car.setMakeYear(2021);
        car.setMileage(0);
        car.setModel("Honda Civic");
        car.setMsrp(20000);
        car.setNewCar(true);
        car.setPictureURL("www.thisisanurl.co.uk");
        car.setTrans("Automatic");
        car.setVinNumber("#A21FDS6U9ER4Y46H");

        car.setSalesPrice(18000);
        
        car = carDao.addCar(car);
        
        Cars returnedValue = carDao.getCarById(car.getId());
        
        assertEquals(car, returnedValue, "CarsDaoDbImplTest.java : TEST 1 : line 115");
                
    }

    /**
     * Test of getAllNewCars method, of class CarsDaoDbImpl.
     */
    @Test
    public void testGetAllNewCars() {
    }

    /**
     * Test of getAllUsedCars method, of class CarsDaoDbImpl.
     */
    @Test
    public void testGetAllUsedCars() {
    }

    /**
     * Test of addCar method, of class CarsDaoDbImpl.
     */
    @Test
    public void testAddCar() {
    }

    /**
     * Test of updateCar method, of class CarsDaoDbImpl.
     */
    @Test
    public void testUpdateCar() {
    }

    /**
     * Test of deleteCarById method, of class CarsDaoDbImpl.
     */
    @Test
    public void testDeleteCarById() {
    }
    
}
