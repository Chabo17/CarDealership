package com.sg.carDealership.dao;

import com.sg.carDealership.dto.Sales_Information_Record;
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
    
    @Autowired
    Sales_Information_Record_Dao sirDao;

    UsersDaoDbImplTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }


    @BeforeEach
    public void setUp() 
    {
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
        user.setFirstName("Ben");
        user.setLastName("Jizzel");
        user.setEmail("jizzel@gmail.com");
        user.setUserPassword("badboy");
        user.setUserRole("User");
        
        user = userDao.addUser(user);
        
        user.setUserPassword("mybadboy");
        
        Users fromDao = userDao.getUserById(user.getId());
        
        assertFalse(fromDao.equals(user));
        
        
        userDao.updateUser(user);
        
        fromDao = userDao.getUserById(user.getId());
        
        assertEquals(fromDao, user, "UsersDaoDbImplTest.java : TEST 2");
    }

    @Test
    @Order(3)
    void getAllUsers() 
    {
        Users user1 = new Users();
        user1.setFirstName("Benoit");
        user1.setLastName("Jizzel");
        user1.setEmail("jizzel@gmail.com");
        user1.setUserPassword("badboy");
        user1.setUserRole("User");
        
        user1 = userDao.addUser(user1);
        
        
        
        Users user2 = new Users();
        user2.setFirstName("Benjamin");
        user2.setLastName("Jizzel");
        user2.setEmail("jizzel@gmail.com");
        user2.setUserPassword("badboy");
        user2.setUserRole("User");
        
        user2 = userDao.addUser(user2);
        
        
        
        List<Users> testList = userDao.getAllUsers();
        
        
        
        assertTrue(testList.size() == 2, "UsersDaoDbImplTest.java : TEST 3");
        
        
        assertTrue(testList.contains(user1));
        assertTrue(testList.contains(user2));
        
    }

    /**
     * This will remove everything created in the SQL table
     */
    @Test
    @Order(4)
    void deleteUserById() 
    {
        
        Users user = new Users();
        user.setFirstName("Ben");
        user.setLastName("Jizzel");
        user.setEmail("jizzel@gmail.com");
        user.setUserPassword("badboy");
        user.setUserRole("User");
        
        user = userDao.addUser(user);
        
        userDao.deleteUserById(user.getId());
        
        assertNull(userDao.getUserById(user.getId()));
        
        
    }
}