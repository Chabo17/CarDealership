/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.carDealership.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import com.sg.carDealership.dto.MyModel;
import com.sg.carDealership.dto.Sales_Information_Record;
import java.util.List;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author chadb
 */
@SpringBootTest
public class ModelDaoDbImplTest {
    
    @Autowired
    ModelDaoDbImpl model;
    
    public ModelDaoDbImplTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {       
        List<MyModel> M = model.getAllMyModels();
        for(MyModel DM: M)
        {
            model.deleteMyModelById(DM.getId());
        }
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testGetMyModelById() {
        MyModel M = new MyModel();
        M.setModel("This is the Test model");
        
        model.addMyModel(M);
        assertEquals(M,model.getMyModelById(M.getId()));        
    }
    
    public void testGetAllMyModels() {
        MyModel M = new MyModel();
        M.setModel("This is the Test model");
        
        MyModel M2 = new MyModel();
        M2.setModel("This is the second Test model");
        
        model.addMyModel(M);
        model.addMyModel(M2);
        assertEquals(M,model.getAllMyModels().get(0));
        assertEquals(M2,model.getAllMyModels().get(1));        
    }
    
    @Test
    public void testAddMyModel() {
        MyModel M = new MyModel();
        M.setModel("This is the Test model");
        
        model.addMyModel(M);
        assertEquals(M,model.getMyModelById(M.getId()));        
    }
    
    @Test
    public void testUpdateMyModel() {
        MyModel M = new MyModel();
        M.setModel("This is the Test model");
        
        model.addMyModel(M);
        M.setModel("Je suis la modèle");
        model.updateMyModel(M);
        assertEquals(M,model.getMyModelById(M.getId()));        
    }
    
    @Test
    public void testDeleteMyModelById() {
        MyModel M = new MyModel();
        M.setModel("This is the Test model");
        
        model.addMyModel(M);
        model.deleteMyModelById(M.getId());
        assertNull(model.getMyModelById(M.getId()));       
    }
    
    
}
