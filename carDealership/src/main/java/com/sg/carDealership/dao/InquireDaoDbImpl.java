/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.carDealership.dao;

import com.sg.carDealership.dto.Inquire;
import com.sg.carDealership.dto.Specials;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pierre
 */
@Repository
public class InquireDaoDbImpl implements InquireDao
{
    
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public Inquire getInquireById(int id) 
    {
        try {
            final String SELECT_INQUIRE_BY_ID = "SELECT * FROM inquire WHERE id = ?";
            return jdbc.queryForObject(SELECT_INQUIRE_BY_ID, new InquireMapper(), id);
        } catch (DataAccessException ex) {
            return null;
        }
        
    }

    @Override
    public List<Inquire> getAllIquires() 
    {
        final String SELECT_ALL_INQUIRE = "SELECT * FROM inquire";
        return jdbc.query(SELECT_ALL_INQUIRE, new InquireMapper());
        
    }

    @Override
    @Transactional
    public Inquire addInquire(Inquire inquire) 
    {
        final String INSERT_INQUIRE = "INSERT INTO inquire(inquireName, email, phone, message) "
                + "VALUES(?,?,?,?)";
        jdbc.update(INSERT_INQUIRE,
                inquire.getInquireName(),
                inquire.getEmail(),
                inquire.getPhone(),
                inquire.getMessage()
                );
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        inquire.setId(newId);
        return inquire;
        
    }

    @Override
    public void updateInquire(Inquire inquire) 
    {
        final String UPDATE_INQUIRE = "UPDATE inquire SET inquireName = ?, email = ?, "
                                                + " phone = ?, message = ?"
                + "WHERE id = ?";
        jdbc.update(UPDATE_INQUIRE,
                inquire.getInquireName(),
                inquire.getEmail(),
                inquire.getPhone(),
                inquire.getMessage(),
                inquire.getId());
        
    }

    @Override
    @Transactional
    public void deleteInquireById(int id) 
    {
        final String DELETE_INQUIRE = "DELETE FROM Inquire WHERE id = ?";
        jdbc.update(DELETE_INQUIRE, id);
        
    }
    
    
    
    public static final class InquireMapper implements RowMapper<Inquire> {

        @Override
        public Inquire mapRow(ResultSet rs, int index) throws SQLException {
            Inquire inquire = new Inquire();
            
            inquire.setId(rs.getInt("id"));
            inquire.setInquireName(rs.getString("inquireName"));
            inquire.setEmail(rs.getString("email"));
            inquire.setPhone(rs.getString("phone"));
            inquire.setMessage(rs.getString("message"));
            
            
            
            
            /*
            
            
            rs.getInt("")
            rs.getString("")
            
            
            */
            return inquire;
        }
    }
    
    
    
}
