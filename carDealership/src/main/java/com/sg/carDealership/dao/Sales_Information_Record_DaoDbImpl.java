/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.carDealership.dao;

import com.sg.carDealership.dto.Sales_Information_Record;
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
public class Sales_Information_Record_DaoDbImpl implements Sales_Information_Record_Dao
{
    @Autowired
    JdbcTemplate jdbc;
    
    

    @Override
    public Sales_Information_Record getSIRById(int id) 
    {
        try {
            final String SELECT_SIR_BY_ID = "SELECT * FROM sales_information_record WHERE id = ?";
            return jdbc.queryForObject(SELECT_SIR_BY_ID, new SirMapper(), id);
        } catch (DataAccessException ex) {
            return null;
        }
        
    }

    @Override
    public List<Sales_Information_Record> getALLSIR() 
    {
        final String SELECT_ALL_SIR = "SELECT * FROM sales_information_record";
        return jdbc.query(SELECT_ALL_SIR, new SirMapper());
        
    }

    @Override
    @Transactional
    public Sales_Information_Record addSIR(Sales_Information_Record sir) 
    {
        final String INSERT_SIR = "INSERT INTO sales_information_record(s_i_names, s_i_phone,"
                                + "s_i_street_1, s_i_street_2, s_i_city, s_i_state, s_i_zipcode,"
                                + " s_r_purchase_price, s_r_purchase_type, user_id, car_id ) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        jdbc.update(INSERT_SIR,
                sir.getS_i_names(),
                sir.getS_i_phone(),
                sir.getS_i_street_1(),
                sir.getS_i_street_2(),
                sir.getS_i_city(),
                sir.getS_i_state(),
                sir.getS_i_email(),
                sir.getS_i_zipcode(),
                sir.getS_r_purchase_price(),
                sir.getS_r_purchase_type(),
                sir.getUser_id(),
                sir.getCar_id()
                );
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        sir.setId(newId);
        return sir;
        
    }
    /*
    private int id;
    private String s_i_names;
    private String s_i_phone;
    private String s_i_street_1;
    private String s_i_street_2;
    private String s_i_city;
    private String s_i_state;
    private String s_i_zipcode;
    private double s_r_purchase_price;
    private String s_r_purchase_type;
    private int user_id;
    private int car_id;
    
    
    id INT PRIMARY KEY AUTO_INCREMENT,
    s_i_names VARCHAR(50),
    s_i_phone VARCHAR(20),
    s_i_street_1 VARCHAR(50),
    s_i_street_2 VARCHAR(50),
    s_i_city VARCHAR(20),
    s_i_state VARCHAR(2),
    s_i_zipcode  VARCHAR(10),
    s_r_purchase_price DOUBLE,
    s_r_purchase_type VARCHAR(30),
    user_id INT,
    car_id INT,
    
    
    
    
    
    */

    @Override
    public void updateSIR(Sales_Information_Record sir) 
    {
        final String UPDATE_SIR = "UPDATE sales_information_record SET "
                + "s_i_names = ?, "
                + "s_i_phone = ?,"
                                + "s_i_street_1 = ?, s_i_street_2 = ?, s_i_city = ?, s_i_state = ?, s_i_zipcode = ?,"
                                + " s_r_purchase_price = ?, s_r_purchase_type = ?, user_id = ?, car_id = ? "
                                +"Where id = ?";
                
        jdbc.update(UPDATE_SIR,
                sir.getS_i_names(),
                sir.getS_i_phone(),
                sir.getS_i_street_1(),
                sir.getS_i_street_2(),
                sir.getS_i_city(),
                sir.getS_i_state(),
                sir.getS_i_zipcode(),
                sir.getS_r_purchase_price(),
                sir.getS_r_purchase_type(),
                sir.getUser_id(),
                sir.getCar_id(),
                sir.getId()
                );
        
        
    }

    @Override
    @Transactional
    public void deleteSIRById(int id) 
    {
        final String DELETE_SIR = "DELETE FROM sales_information_record WHERE id = ?";
        jdbc.update(DELETE_SIR, id);
        
    }
    
    
    
    
    
    public static final class SirMapper implements RowMapper<Sales_Information_Record> {

        @Override
        public Sales_Information_Record mapRow(ResultSet rs, int index) throws SQLException {
            Sales_Information_Record sir = new Sales_Information_Record();
            
            sir.setId(rs.getInt("id"));
            sir.setS_i_names(rs.getString("s_i_names"));
            sir.setS_i_phone(rs.getString("s_i_phone"));
            sir.setS_i_street_1(rs.getString("s_i_street_1"));
            sir.setS_i_street_2(rs.getString("s_i_street_2"));
            sir.setS_i_city(rs.getString("s_i_city"));
            sir.setS_i_state(rs.getString("s_i_state"));
            sir.setS_i_zipcode(rs.getString("s_i_zipcode"));
            sir.setS_r_purchase_price(rs.getDouble("s_r_purchase_price"));
            sir.setS_r_purchase_type(rs.getString("s_r_purchase_type"));
            sir.setCar_id(rs.getInt("car_id"));
            sir.setUser_id(rs.getInt("user_id"));
            
            
            
            
            /*
            
            
            rs.getInt("")
            rs.getString("")
            
            
            */
            return sir;
        }
    }
    
    
}
