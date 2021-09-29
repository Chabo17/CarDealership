/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.carDealership.dao;

import com.sg.carDealership.dto.Make;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pierre
 */

@Repository
public class MakeDaoDbImpl implements MakeDao 
{
    @Autowired
    JdbcTemplate jdbc;
    
    
    @Override
    public Make getMakeById(int id) 
    {
        
        try {
            final String SELECT_MAKE_BY_ID = "SELECT * FROM make WHERE id = ?";
            return jdbc.queryForObject(SELECT_MAKE_BY_ID, new MakeMapper(), id);
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Make> getAllMake() 
    {
        final String SELECT_ALL_MAKES = "SELECT * FROM make";
        return jdbc.query(SELECT_ALL_MAKES, new MakeMapper() );
        
    }

    @Override
    public Make addMake(Make make) 
    {
        final String INSERT_MAKE = "INSERT INTO make(make) "
                + "VALUES(?)";
        jdbc.update(INSERT_MAKE,
                make.getMake());
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        make.setId(newId);
        return make;
    }

    @Override
    public void updateMake(Make make) 
    {
        final String UPDATE_MAKE = "UPDATE make SET make = ? WHERE id = ?";
        jdbc.update(UPDATE_MAKE,
                make.getMake(),
                make.getId());    
        
    }

    @Override
    public void deleteMakeById(int id) 
    {
        final String DELETE_MAKE = "DELETE FROM make WHERE id = ?";
        jdbc.update(DELETE_MAKE, id);    
        
    }
    
    
    
    public static final class MakeMapper implements RowMapper<Make> {

        @Override
        public Make mapRow(ResultSet rs, int index) throws SQLException {
            Make make = new Make();
            
            make.setId(rs.getInt("id"));
            make.setMake(rs.getString("make"));
            
            return make;
            
            /*
            
            
            rs.getInt("")
            rs.getString("")
            
            
            */
            
        }
    }
    
    
}
