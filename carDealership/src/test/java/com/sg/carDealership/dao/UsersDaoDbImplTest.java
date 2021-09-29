package com.sg.carDealership.dao;

import com.sg.carDealership.dto.Users;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UsersDaoDbImplTest {

    @Autowired
    UsersDao userDao;

    UsersDaoDbImplTest() {
    }

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
    @Order(1)
    void testAddGetUser() {
        Users user1 = new Users();
        user1.setFirstName("Van");
        user1.setLastName("Diesel");
        user1.setEmail("diesel@gmail.com");
        user1.setUserPassword("fastAndTedious");
        user1.setUserRole("Admin");
        userDao.addUser(user1);

        Users user2 = new Users();
        user2.setFirstName("Jamie");
        user2.setLastName("Choco");
        user2.setEmail("jchoho@gmail.com");
        user2.setUserPassword("bigger");
        user2.setUserRole("User");
        userDao.addUser(user2);

        Users returnedValue = userDao.getUserById(user2.getId());

        assertEquals(user2, returnedValue, "UsersDaoDbImplTest.java : TEST 1");
    }

    @Test
    @Order(2)
    void updateUser() {
        Users user = new Users();
        user.setId(1);
        user.setFirstName("Ben");
        user.setLastName("Jizzel");
        user.setEmail("jizzel@gmail.com");
        user.setUserPassword("badboy");
        user.setUserRole("User");

        userDao.updateUser(user);
        Users returnedValue = userDao.getUserById(1);
        assertEquals(user, returnedValue, "UsersDaoDbImplTest.java : TEST 2");
    }

    @Test
    @Order(3)
    void getAllUsers() {
        List<Users> testList = userDao.getAllUsers();
        assertEquals(2, testList.size(), "UsersDaoDbImplTest.java : TEST 3");
    }

    /**
     * This will remove everything created in the SQL table
     */
    @Test
    @Order(4)
    void deleteUserById() {
        userDao.deleteUserById(1);
        userDao.deleteUserById(2);
        assertEquals(null, userDao.getUserById(1), "UsersDaoDbImplTest.java : TEST 4");
    }
}