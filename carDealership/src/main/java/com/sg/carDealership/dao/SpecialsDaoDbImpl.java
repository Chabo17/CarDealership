/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.carDealership.dao;

import com.sg.carDealership.dto.Specials;
import com.sg.carDealership.dto.Users;
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
public class SpecialsDaoDbImpl implements SpecialsDao
{
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public Specials getSpecialById(int id) 
    {
        try {
            final String SELECT_SPECIAL_BY_ID = "SELECT * FROM specials WHERE id = ?";
            return jdbc.queryForObject(SELECT_SPECIAL_BY_ID, new SpecialMapper(), id);
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Specials> getAllSpecials() 
    {
        final String SELECT_ALL_SPECIALS = "SELECT * FROM specials";
        return jdbc.query(SELECT_ALL_SPECIALS, new SpecialMapper() );
    }

    @Override
    @Transactional
    public Specials addSpecial(Specials special) 
    {
        final String INSERT_SPECIAL = "INSERT INTO specials(carId, message) "
                + "VALUES(?,?)";
        jdbc.update(INSERT_SPECIAL,
                special.getCarId(),
                special.getMessage());
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        special.setId(newId);
        return special;
    }

    @Override
    public void updateSpecial(Specials special) 
    {
        final String UPDATE_SPECIAL = "UPDATE specials SET carId = ?, message = ? WHERE id = ?";
        jdbc.update(UPDATE_SPECIAL, special.getCarId(), 
                special.getMessage(),
                special.getId()
                
                );    
    }

    @Override
    @Transactional
    public void deleteSpecialById(int id) 
    {
        final String DELETE_SPECIAL = "DELETE FROM specials WHERE id = ?";
        jdbc.update(DELETE_SPECIAL, id);    
    
    }
    
    
    
    
    
    
    
    
    
    public static final class SpecialMapper implements RowMapper<Specials> {

        @Override
        public Specials mapRow(ResultSet rs, int index) throws SQLException {
            Specials special = new Specials();
            
            special.setId(rs.getInt("id"));
            special.setCarId(rs.getInt("carId"));
            special.setMessage(rs.getString("message"));
            
            
            
            
            /*
            
            
            rs.getInt("")
            rs.getString("")
            
            
            */
            return special;
        }
    }
    
    
    
    
}
