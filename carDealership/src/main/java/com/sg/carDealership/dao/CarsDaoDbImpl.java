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
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pierre
 */
@Repository
public class CarsDaoDbImpl implements CarsDao {
    
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public Cars getCarById(int id) 
    {
        try {
            final String SELECT_CAR_BY_ID = "SELECT * FROM cars WHERE id = ?";
            return jdbc.queryForObject(SELECT_CAR_BY_ID, new CarMapper(), id);
        } catch (DataAccessException ex) {
            return null;
        }
        

    }

    @Override
    public List<Cars> getAllNewCars() 
    {
        final String SELECT_ALL_NEW_CARS = "SELECT * FROM cars WHERE carType = 'New' ";
        return jdbc.query(SELECT_ALL_NEW_CARS, new CarMapper());
    }

    @Override
    public List<Cars> getAllUsedCars() {
        final String SELECT_ALL_NEW_CARS = "SELECT * FROM cars WHERE carType = 'Used'";
        return jdbc.query(SELECT_ALL_NEW_CARS, new CarMapper());
    }

    @Override
    @Transactional
    public Cars addCar(Cars car) 
    {
        final String INSERT_CAR = "INSERT INTO cars("
                + "newCar,"
                + "carName,"
                + "make,"
                + "model,"
                + "carType,"
                + "bodyStyle,"
                + "makeYear,"
                + "trans,"
                + "color,"
                + "interiorColor,"
                + "mileage,"
                + "vinNumber,"
                + "salesPrice,"
                + "msrp,"
                + "carDescription,"
                + "pictureURL) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbc.update(INSERT_CAR,
                car.isNewCar(),
                car.getCarName(),
                car.getMake(),
                car.getModel(),
                car.getCarType(),
                car.getBodyStyle(),
                car.getMakeYear(),
                car.getTrans(),
                car.getColor(),
                car.getInteriorColor(),
                car.getMileage(),
                car.getVinNumber(),
                car.getSalesPrice(),
                car.getMsrp(),
                car.getCarDescription(),
                car.getPictureURL());
        
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        car.setId(newId);
        return car;
    }

    @Override
    public void updateCar(Cars car) 
    {
        final String UPDATE_CAR = "UPDATE cars SET "
                + "newCar = ?,"
                + "carName = ?,"
                + "make = ?,"
                + "model = ?,"
                + "carType = ?,"
                + "bodyStyle = ?,"
                + "makeYear = ?,"
                + "trans = ?,"
                + "color = ?,"
                + "interiorColor = ?,"
                + "mileage = ?,"
                + "vinNumber = ?,"
                + "salesPrice = ?,"
                + "msrp = ?,"
                + "carDescription = ?,"
                + "pictureURL = ? "
                + "WHERE id = ?";
        
        jdbc.update(UPDATE_CAR,
                car.isNewCar(),
                car.getCarName(),
                car.getMake(),
                car.getModel(),
                car.getCarType(),
                car.getBodyStyle(),
                car.getMakeYear(),
                car.getTrans(),
                car.getColor(),
                car.getInteriorColor(),
                car.getMileage(),
                car.getVinNumber(),
                car.getSalesPrice(),
                car.getMsrp(),
                car.getCarDescription(),
                car.getPictureURL(),
                car.getId());
    }

    @Override
    @Transactional
    public void deleteCarById(int id) 
    {
        final String DELETE_CAR = "DELETE FROM cars WHERE id = ?";
        jdbc.update(DELETE_CAR, id);
        
        
    }

    @Override
    public List<Cars> getAllCars() 
    {
        final String SELECT_ALL_NEW_CARS = "SELECT * FROM cars";
        return jdbc.query(SELECT_ALL_NEW_CARS, new CarMapper());    
    }

    @Override
    public List<Cars> getFeaturedCars() {
        final String SELECT_ALL_NEW_CARS = "SELECT * FROM cars LIMIT 8";
        return jdbc.query(SELECT_ALL_NEW_CARS, new CarMapper());
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
