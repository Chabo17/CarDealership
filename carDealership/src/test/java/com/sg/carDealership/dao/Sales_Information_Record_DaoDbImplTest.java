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
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author chadb
 */
@SpringBootTest
public class Sales_Information_Record_DaoDbImplTest {
    
    @Autowired
    UsersDao userDao;
    
    @Autowired
    CarsDao carDao;
    
    @Autowired
    Sales_Information_Record_Dao sirDao;
    
    @Autowired
    SpecialsDao SDao;
    
    public Sales_Information_Record_DaoDbImplTest() {
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

    @Test
    public void testGetSIRById() {
        Users user = new Users();
        user.setFirstName("Van");
        user.setLastName("Diesel");
        user.setEmail("diesel@gmail.com");
        user.setUserPassword("fastAndTedious");
        user.setUserRole("Admin");

        userDao.addUser(user);
        
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
        
        Sales_Information_Record SR = new Sales_Information_Record();
        SR.setCar_id(car.getId());
        SR.setUser_id(user.getId());
        SR.setS_i_city("GROY");
        SR.setS_i_names("Van");
        SR.setS_i_phone("456123789");
        SR.setS_i_state("Ca");
        SR.setS_i_zipcode("95020");
        SR.setS_r_purchase_price(15000);
        SR.setS_r_purchase_type("That Type");
        
        sirDao.addSIR(SR);
        assertEquals(SR, sirDao.getSIRById(SR.getId()));
    }
    
    @Test
    public void testGetALLSIR() {
        Users user = new Users();
        user.setFirstName("Van");
        user.setLastName("Diesel");
        user.setEmail("diesel@gmail.com");
        user.setUserPassword("fastAndTedious");
        user.setUserRole("Admin");

        userDao.addUser(user);
        
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
        
        Sales_Information_Record SR = new Sales_Information_Record();
        SR.setCar_id(car.getId());
        SR.setUser_id(user.getId());
        SR.setS_i_city("GROY");
        SR.setS_i_names("Van");
        SR.setS_i_phone("456123789");
        SR.setS_i_state("Ca");
        SR.setS_i_zipcode("95020");
        SR.setS_r_purchase_price(15000);
        SR.setS_r_purchase_type("That Type");
        
        sirDao.addSIR(SR);
        assertEquals(SR, sirDao.getALLSIR().get(0));
    }
    
    @Test
    public void testAddSIR() {
        Users user = new Users();
        user.setFirstName("Van");
        user.setLastName("Diesel");
        user.setEmail("diesel@gmail.com");
        user.setUserPassword("fastAndTedious");
        user.setUserRole("Admin");

        userDao.addUser(user);
        
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
        
        Sales_Information_Record SR = new Sales_Information_Record();
        SR.setCar_id(car.getId());
        SR.setUser_id(user.getId());
        SR.setS_i_city("GROY");
        SR.setS_i_names("Van");
        SR.setS_i_phone("456123789");
        SR.setS_i_state("Ca");
        SR.setS_i_zipcode("95020");
        SR.setS_r_purchase_price(15000);
        SR.setS_r_purchase_type("That Type");
        
        sirDao.addSIR(SR);
        assertEquals(SR, sirDao.getSIRById(SR.getId()));
    }
    
    @Test
    public void testUpdateSIR() {
        Users user = new Users();
        user.setFirstName("Van");
        user.setLastName("Diesel");
        user.setEmail("diesel@gmail.com");
        user.setUserPassword("fastAndTedious");
        user.setUserRole("Admin");

        userDao.addUser(user);
        
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
        
        Sales_Information_Record SR = new Sales_Information_Record();
        SR.setCar_id(car.getId());
        SR.setUser_id(user.getId());
        SR.setS_i_city("GROY");
        SR.setS_i_names("Van");
        SR.setS_i_street_1("GVD");
        SR.setS_i_street_2("GVD2");
        SR.setS_i_phone("456123789");
        SR.setS_i_state("Ca");
        SR.setS_i_zipcode("95020");
        SR.setS_r_purchase_price(15000);
        SR.setS_r_purchase_type("That Type");
        
        SR = sirDao.addSIR(SR);
        SR.setS_i_city("Morgan Hill");
        sirDao.updateSIR(SR);
        assertEquals(SR, sirDao.getSIRById(SR.getId()));
    }
    
    @Test
    public void testDeleteSIRById() {
        Users user = new Users();
        user.setFirstName("Van");
        user.setLastName("Diesel");
        user.setEmail("diesel@gmail.com");
        user.setUserPassword("fastAndTedious");
        user.setUserRole("Admin");

        userDao.addUser(user);
        
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
        
        Sales_Information_Record SR = new Sales_Information_Record();
        SR.setCar_id(car.getId());
        SR.setUser_id(user.getId());
        SR.setS_i_city("GROY");
        SR.setS_i_names("Van");
        SR.setS_i_phone("456123789");
        SR.setS_i_state("Ca");
        SR.setS_i_zipcode("95020");
        SR.setS_r_purchase_price(15000);
        SR.setS_r_purchase_type("That Type");
        
        sirDao.addSIR(SR);
        
        sirDao.deleteSIRById(SR.getId());
        assertNull(sirDao.getSIRById(SR.getId()));
    }
}
