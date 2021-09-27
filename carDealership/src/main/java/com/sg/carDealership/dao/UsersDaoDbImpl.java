/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.carDealership.dao;

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
public class UsersDaoDbImpl implements UsersDao 
{
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public Users getUserById(int id) 
    {
        try {
            final String SELECT_USER_BY_ID = "SELECT * FROM users WHERE id = ?";
            return jdbc.queryForObject(SELECT_USER_BY_ID, new UserMapper(), id);
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Users> getAllUsers() 
    {
        final String SELECT_ALL_USERS = "SELECT * FROM users";
        return jdbc.query(SELECT_ALL_USERS, new UserMapper());
    }

    @Override
    @Transactional
    public Users addUser(Users user) 
    {
        final String INSERT_USER = "INSERT INTO users(firstName, lastName, "
                                                    + "email, userPassword, userRole) "
                + "VALUES(?,?,?,?,?)";
        jdbc.update(INSERT_USER,
                user.getFirstName(),
                user.getLastName());
                user.getEmail();
                user.getUserPassword();
                user.getUserRole();
        
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        user.setId(newId);
        return user;
    }

    @Override
    public void updateUser(Users user) 
    {
        final String UPDATE_USER = "UPDATE users SET firstName = ?, lastName = ?, "
                                                + " email = ?, userPassword = ?, userRole = ?"
                + "WHERE id = ?";
        jdbc.update(UPDATE_USER,
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getUserPassword(),
                user.getUserRole(),
                user.getId());
    }

    @Override
    @Transactional
    public void deleteUserById(int id) 
    {
        
        
        final String DELETE_USER = "DELETE FROM users WHERE id = ?";
        jdbc.update(DELETE_USER, id);
        
    }
    
    
    
    
    public static final class UserMapper implements RowMapper<Users> {

        @Override
        public Users mapRow(ResultSet rs, int index) throws SQLException {
            Users user = new Users();
            user.setId(rs.getInt("id"));
            user.setFirstName(rs.getString("firstName"));
            user.setLastName(rs.getString("lastName"));
            user.setEmail(rs.getString("email"));
            user.setUserPassword(rs.getString("userPassword"));
            user.setUserRole(rs.getString("userRole"));
            return user;
        }
    }
    
    
    
}
