/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.carDealership.dao;

import com.sg.carDealership.dto.Cars;
import com.sg.carDealership.dto.Sales_Information_Record;
import com.sg.carDealership.dto.Specials;
import com.sg.carDealership.dto.Users;
import java.util.List;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    
    @Autowired
    SpecialsDao SDao;
    
    
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
        
        List<Specials> S = SDao.getAllSpecials();
        for(Specials sir : S)
        {
            SDao.deleteSpecialById(sir.getId());
        }
        
        
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
    public void testGetAllNewCars() 
    {
        Cars car1 = new Cars();
        car1.setBodyStyle("low");
        car1.setCarDescription("Beautiful");
        car1.setCarName("Civic");
        car1.setCarType("Sport");
        car1.setColor("Sunset");
        car1.setInteriorColor("Leather");
        car1.setMake("Honda");
        car1.setMakeYear(2021);
        car1.setMileage(0);
        car1.setModel("Honda Civic");
        car1.setMsrp(20000);
        car1.setNewCar(true);
        car1.setPictureURL("www.thisisanurl.co.uk");
        car1.setTrans("Automatic");
        car1.setVinNumber("#A21FDS6U9ER4Y46H");

        car1.setSalesPrice(18000);
        
        car1 = carDao.addCar(car1);
        
        
        Cars car2 = new Cars();
        car2.setBodyStyle("low");
        car2.setCarDescription("Beautiful");
        car2.setCarName("Civic");
        car2.setCarType("Sport");
        car2.setColor("Sunset");
        car2.setInteriorColor("Leather");
        car2.setMake("Honda");
        car2.setMakeYear(2021);
        car2.setMileage(0);
        car2.setModel("Honda Civic");
        car2.setMsrp(20000);
        car2.setNewCar(true);
        car2.setPictureURL("www.thisisanurl.co.uk");
        car2.setTrans("Automatic");
        car2.setVinNumber("#A21FDS6U9ER4Y46G");

        car2.setSalesPrice(18000);
        
        car2 = carDao.addCar(car2);
        
        
        List<Cars> cars = carDao.getAllCars();
        
        assertTrue(cars.contains(car1));
        assertTrue(cars.contains(car2));        
        
        List<Cars> newcars = carDao.getAllNewCars();

        assertTrue(newcars.contains(car1));
        assertTrue(newcars.contains(car2));        

        
    }

    /**
     * Test of getAllUsedCars method, of class CarsDaoDbImpl.
     */
    @Test
    public void testGetAllUsedCars() {
        Cars car1 = new Cars();
        car1.setBodyStyle("low");
        car1.setCarDescription("Beautiful");
        car1.setCarName("Civic");
        car1.setCarType("Sport");
        car1.setColor("Sunset");
        car1.setInteriorColor("Leather");
        car1.setMake("Honda");
        car1.setMakeYear(2021);
        car1.setMileage(5000);
        car1.setModel("Honda Civic");
        car1.setMsrp(20000);
        car1.setNewCar(false);
        car1.setPictureURL("www.thisisanurl.co.uk");
        car1.setTrans("Automatic");
        car1.setVinNumber("#A21FDS6U9ER4Y46H");

        car1.setSalesPrice(10000);

        car1 = carDao.addCar(car1);


        Cars car2 = new Cars();
        car2.setBodyStyle("low");
        car2.setCarDescription("Beautiful");
        car2.setCarName("Civic");
        car2.setCarType("Sport");
        car2.setColor("Sunset");
        car2.setInteriorColor("Leather");
        car2.setMake("Honda");
        car2.setMakeYear(2021);
        car2.setMileage(2000);
        car2.setModel("Honda Civic");
        car2.setMsrp(20000);
        car2.setNewCar(false);
        car2.setPictureURL("www.thisisanurl.co.uk");
        car2.setTrans("Automatic");
        car2.setVinNumber("#A21FDS6U9ER4Y46G");

        car2.setSalesPrice(12000);

        car2 = carDao.addCar(car2);

        assertEquals(2, carDao.getAllUsedCars().size());
    }

    /**
     * Test of updateCar method, of class CarsDaoDbImpl.
     */
    @Test
    public void testUpdateCar() 
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
        
        Cars fromDao = carDao.getCarById(car.getId());
        
        assertTrue(car.equals(fromDao), "\n\n POL\n\nSOMETHING IS WRONG\n\ncar Object\n"+ car +"\nfromDao Object\n"+ fromDao+"\n\n POL\n=========================");
        
        car.setBodyStyle("high");
        
        assertFalse(car.equals(fromDao));
        
        carDao.updateCar(car);
        fromDao = carDao.getCarById(car.getId());
        
        assertTrue(car.equals(fromDao));
        
        
        
        
    }

    /**
     * Test of deleteCarById method, of class CarsDaoDbImpl.
     */
    @Test
    public void testDeleteCarById() 
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
        
        Cars fromDao = carDao.getCarById(car.getId());
        
        assertTrue(car.equals(fromDao), "\n\n POL\n\nSOMETHING IS WRONG\n\ncar Object\n"+ car +"\nfromDao Object\n"+ fromDao+"\n\n POL\n=========================");
        
        carDao.deleteCarById(car.getId());
        
        fromDao = carDao.getCarById(car.getId());
        
        assertNull(fromDao);
    }
    
}
