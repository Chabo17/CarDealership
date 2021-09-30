/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.carDealership.dao;

import com.sg.carDealership.dto.Cars;
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
public class CarsSearchDaoDbImpl implements CarsSearchDao
{
    @Autowired
    JdbcTemplate jdbc;
    
    
    @Override
    public List<Cars> getfilteredCars(String keyword) 
    {
        
        try {
            final String SELECT_CAR  = "SELECT * FROM cars WHERE carName LIKE ? "
                    + "OR make LIKE ? "
                    + "OR model LIKE ?" ;
            return jdbc.query(SELECT_CAR,
                    new CarMapper(),
                    keyword,
                    keyword,
                    keyword);
        } catch (DataAccessException ex) {
            return null;
        }
        
    }
    
    
    public static final class CarMapper implements RowMapper<Cars> {

        @Override
        public Cars mapRow(ResultSet rs, int index) throws SQLException {
            Cars car = new Cars();
            
            car.setId(rs.getInt("id"));
            
            car.setNewCar(rs.getBoolean("newCar"));
            
            car.setCarName(rs.getString("carName"));
            
            car.setMake(rs.getString("make"));
            
            car.setModel(rs.getString("model"));
            
            car.setCarType(rs.getString("carType"));
            
            car.setBodyStyle(rs.getString("bodyStyle"));
            
            car.setMakeYear(rs.getInt("makeYear"));
            
            car.setTrans(rs.getString("trans"));
            
            car.setColor(rs.getString("color"));
            
            car.setInteriorColor(rs.getString("interiorColor"));
            
            car.setMileage(rs.getInt("mileage"));
            
            car.setVinNumber(rs.getString("vinNumber"));
            
            car.setSalesPrice(rs.getDouble("salesPrice"));
            
            car.setMsrp(rs.getDouble("msrp"));
            
            car.setCarDescription(rs.getString("carDescription"));
            
            car.setPictureURL(rs.getString("pictureURL"));
            
            
            
            
            return car;
           
        }
    }
    
}
