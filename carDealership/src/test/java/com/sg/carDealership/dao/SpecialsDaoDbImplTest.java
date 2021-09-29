/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.carDealership.dao;

import com.sg.carDealership.dto.Cars;
import com.sg.carDealership.dto.Sales_Information_Record;
import com.sg.carDealership.dto.Specials;
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
public class SpecialsDaoDbImplTest {
    
    @Autowired
    SpecialsDao SDao;

    @Autowired
    Sales_Information_Record_Dao sirDao;
    
    
    
    public SpecialsDaoDbImplTest() {
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
        
        List<Specials> sList = SDao.getAllSpecials();
        for(Specials S : sList)
        {
            SDao.deleteSpecialById(S.getId());
        }    

        
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testGetSpecialById() {
       
        Specials S = new Specials();
        S.setMessage("This is the message");
        
        SDao.addSpecial(S);
        assertEquals(S,SDao.getSpecialById(S.getId()));
    }
    
    public void testGetAllSpecials() {
        Specials S = new Specials();
        S.setMessage("This is the message");
        SDao.addSpecial(S);
        
        assertEquals(S,SDao.getAllSpecials().get(S.getId()-1));
    }
    
    public void testAddSpecial() {
        Specials S = new Specials();
        S.setMessage("This is the message");
        
        SDao.addSpecial(S);
        assertEquals(S,SDao.getSpecialById(S.getId()));
    }
    
    public void testUpdateSpecial() {
        Specials S = new Specials();
        S.setMessage("This is the message");
        SDao.addSpecial(S);
        S.setMessage("This is the better message");
        SDao.updateSpecial(S);

        assertEquals(S,SDao.getSpecialById(S.getId()));
    }
    
    public void testDeleteSpecialById() {
        Specials S = new Specials();
        S.setMessage("This is the message");
        
        SDao.addSpecial(S);
        SDao.deleteSpecialById(S.getId());
        assertNull(SDao.getSpecialById(S.getId()));
        
    }
    
        
    
}
