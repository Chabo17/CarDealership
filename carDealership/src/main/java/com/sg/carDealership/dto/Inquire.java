/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.carDealership.dto;

import java.util.Objects;

/**
 *
 * @author pierre
 */
public class Inquire 
{
    /*
    id INT PRIMARY KEY AUTO_INCREMENT,
    inquireName VARCHAR(60) NOT NULL,
    email VARCHAR(30) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    message VARCHAR(200) NOT NULL
    */
    
    private int id;
    private String inquireName;
    private String email;
    private String phone;
    private String message;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInquireName() {
        return inquireName;
    }

    public void setInquireName(String inquireName) {
        this.inquireName = inquireName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.id;
        hash = 53 * hash + Objects.hashCode(this.inquireName);
        hash = 53 * hash + Objects.hashCode(this.email);
        hash = 53 * hash + Objects.hashCode(this.phone);
        hash = 53 * hash + Objects.hashCode(this.message);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Inquire other = (Inquire) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.inquireName, other.inquireName)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.message, other.message)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Inquire{" + "id=" + id + ", inquireName=" + inquireName + ", email=" + email + ", phone=" + phone + ", message=" + message + '}';
    }
    
    
    
    
    
}
