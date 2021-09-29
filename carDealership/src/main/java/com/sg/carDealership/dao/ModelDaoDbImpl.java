/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.carDealership.dao;

import com.sg.carDealership.dto.MyModel;
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
public class ModelDaoDbImpl implements ModelDao 
{
    @Autowired
    JdbcTemplate jdbc;
    
    @Override
    public MyModel getMyModelById(int id) 
    {
        try {
            final String SELECT_MODEL_BY_ID = "SELECT * FROM model WHERE id = ?";
            return jdbc.queryForObject(SELECT_MODEL_BY_ID, new ModelMapper(), id);
        } catch (DataAccessException ex) {
            return null;
        }
        
        
    }

    @Override
    public List<MyModel> getAllMyModels() 
    {
        
        final String SELECT_ALL_MODELS = "SELECT * FROM model";
        return jdbc.query(SELECT_ALL_MODELS, new ModelMapper() );
        
    }

    @Override
    public MyModel addMyModel(MyModel myModel) 
    {
        final String INSERT_MODEL = "INSERT INTO model(model) "
                + "VALUES(?)";
        jdbc.update(INSERT_MODEL,
                myModel.getModel());
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        myModel.setId(newId);
        return myModel;
        
    }

    @Override
    public void updateMyModel(MyModel myModel) 
    {
        final String UPDATE_MODEL = "UPDATE model SET model = ? WHERE id = ?";
        jdbc.update(UPDATE_MODEL,
                myModel.getModel(),
                myModel.getId());    
        
        
    }

    @Override
    public void deleteMyModelById(int id) 
    {
        final String DELETE_MODEL = "DELETE FROM model WHERE id = ?";
        jdbc.update(DELETE_MODEL, id);    
        
    }
    
    
    
    
    public static final class ModelMapper implements RowMapper<MyModel> {

        @Override
        public MyModel mapRow(ResultSet rs, int index) throws SQLException {
            MyModel model = new MyModel();
            
            model.setId(rs.getInt("id"));
            model.setModel(rs.getString("model"));
            
            return model;
            
            /*
            
            
            rs.getInt("")
            rs.getString("")
            
            
            */
            
        }
    }
    
}
