package com.sg.carDealership.dao;

import com.sg.carDealership.dto.Cars;
import com.sg.carDealership.dto.Sales_Information_Record;
import com.sg.carDealership.dto.Users;
import org.apache.catalina.User;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UsersDaoDbImplTest {

    @Autowired
    UsersDao userDao;

    @Autowired
    CarsDao carDao;

    @Autowired
    Sales_Information_Record_Dao sirDao;

    UsersDaoDbImplTest(){}

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }


    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /////////////

    @Test
    void getUserById() {
        Users user = new Users();
        user.setId(01);
        user.setFirstName("Van");
        user.setLastName("Diesel");
        user.setEmail("diesel@gmail.com");
        user.setUserPassword("fastAndTedious");
        user.setUserRole("Admin");

        userDao.addUser(user);

        Users returnedValue = userDao.getUserById(user.getId());
        System.out.println(user.getId());

        assertEquals(user, returnedValue, "UsersDaoDbImplTest.java : TEST 1");
    }

    @Test
    void testAddGetUser() {
        Users user = new Users();
        user.setId(01);
        user.setFirstName("Van");
        user.setLastName("Diesel");
        user.setEmail("diesel@gmail.com");
        user.setUserPassword("fastAndTedious");
        user.setUserRole("Admin");

        userDao.addUser(user);

        Users returnedValue = userDao.getUserById(user.getId());
        System.out.println(user.getId());

        assertEquals(user, returnedValue, "UsersDaoDbImplTest.java : TEST 2");
    }


    @Test
    void getAllUsers() {

    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUserById() {
    }
}