/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.carDealership.dao;

import com.sg.carDealership.dto.Inquire;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author chadb
 */
@SpringBootTest
public class InquireDaoDbImplTest {
    
    @Autowired
    InquireDao I; 

        
    public InquireDaoDbImplTest() {
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

    @Test
    public void testGetInquireById() {
        Inquire Ink = new Inquire();
        Ink.setId(0);
        Ink.setInquireName("Test Inquire By ID");
        Ink.setEmail("mail@mail.com");
        Ink.setPhone("408798132");
        Ink.setMessage("This is the message");
        
        I.addInquire(Ink);
        assertEquals(Ink,I.getInquireById(Ink.getId()));
    }
    
    @Test
    public void testGetAllIquires() {
        List<Inquire> list = new ArrayList<Inquire>();
        
       
        Inquire Ink = new Inquire();
        Ink.setId(0);
        Ink.setInquireName("Name");
        Ink.setEmail("email@email.com");
        Ink.setPhone("408123465");
        Ink.setMessage("This is a Message");
        list.add(Ink);
        I.addInquire(Ink);
        assertEquals(Ink,I.getAllIquires().get(Ink.getId()-1));
    }
    
    @Test
    public void testAddInquire() {
        Inquire Ink = new Inquire();
        Ink.setId(0);
        Ink.setInquireName("Name");
        Ink.setEmail("email@email.com");
        Ink.setPhone("408123465");
        Ink.setMessage("This is a Message");
        
        I.addInquire(Ink);
        for(Inquire ink: I.getAllIquires()){
            if(ink.getId()==Ink.getId()){
                assertEquals(Ink,ink);
            }
        }
       
    }
    
    @Test
    public void testUpdateInquire() {
        Inquire Ink = new Inquire();
        Ink.setId(0);
        Ink.setInquireName("Name");
        Ink.setEmail("email@email.com");
        Ink.setPhone("408123465");
        Ink.setMessage("This is a Message");
        
        I.addInquire(Ink);
        Ink.setInquireName("New Name");
        I.updateInquire(Ink);
        
        for(Inquire ink: I.getAllIquires()){
            if(ink.getId()==Ink.getId()){
                assertEquals(Ink,ink);
            }
        }
        
    }
    
    
    
    
    
    
}
