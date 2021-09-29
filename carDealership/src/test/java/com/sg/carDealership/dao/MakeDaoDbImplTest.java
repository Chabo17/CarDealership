/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.carDealership.dao;

import com.sg.carDealership.dto.Make;
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
public class MakeDaoDbImplTest {
    
    @Autowired
    MakeDaoDbImpl maker;
    
    public MakeDaoDbImplTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
       List<Make> make = maker.getAllMake();
       for(Make M: make){
           maker.deleteMakeById(M.getId());
       }
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testGetMakeById() {
        Make M = new Make();
        M.setMake("Car Make");
        
        maker.addMake(M);
        assertEquals(M,maker.getMakeById(M.getId()));
    }
    
    @Test
    public void testGetAllMake() {
        Make M = new Make();
        M.setMake("Car Make");
        
        Make M2 = new Make();
        M.setMake("Car Make 2: return of the cars");
        
        maker.addMake(M);
        maker.addMake(M2);
        assertTrue(maker.getAllMake().contains(M));
        assertTrue(maker.getAllMake().contains(M2));
    } 
    
    public void testAddMake() {
        Make M = new Make();
        M.setMake("Car Make");
        
        Make M2 = new Make();
        M.setMake("Car Make 2: return of the cars");
        
        maker.addMake(M);
        maker.addMake(M2);
        assertEquals(M,maker.getMakeById(M.getId()));
        assertEquals(M2,maker.getMakeById(M2.getId()));
    }
    
    
    @Test
    public void testUpdateMake() {
        Make M = new Make();
        M.setMake("Car Make");
        
        maker.addMake(M);
        M.setMake("The change up");
        maker.updateMake(M);
        assertEquals(M,maker.getMakeById(M.getId()));
    }
        
    @Test
    public void testDeleteMakeById() {
        Make M = new Make();
        M.setMake("Car Make");
        
        maker.addMake(M);
        maker.deleteMakeById(M.getId());
        assertNull(maker.getMakeById(M.getId()));
    }
    
    
}
