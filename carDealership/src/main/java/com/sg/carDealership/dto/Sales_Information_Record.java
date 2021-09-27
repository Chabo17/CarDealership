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
public class Sales_Information_Record {
    
    /*
    
    FIELDS
    
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getS_i_names() {
        return s_i_names;
    }

    public void setS_i_names(String s_i_names) {
        this.s_i_names = s_i_names;
    }

    public String getS_i_phone() {
        return s_i_phone;
    }

    public void setS_i_phone(String s_i_phone) {
        this.s_i_phone = s_i_phone;
    }

    public String getS_i_street_1() {
        return s_i_street_1;
    }

    public void setS_i_street_1(String s_i_street_1) {
        this.s_i_street_1 = s_i_street_1;
    }

    public String getS_i_street_2() {
        return s_i_street_2;
    }

    public void setS_i_street_2(String s_i_street_2) {
        this.s_i_street_2 = s_i_street_2;
    }

    public String getS_i_city() {
        return s_i_city;
    }

    public void setS_i_city(String s_i_city) {
        this.s_i_city = s_i_city;
    }

    public String getS_i_state() {
        return s_i_state;
    }

    public void setS_i_state(String s_i_state) {
        this.s_i_state = s_i_state;
    }

    public String getS_i_zipcode() {
        return s_i_zipcode;
    }

    public void setS_i_zipcode(String s_i_zipcode) {
        this.s_i_zipcode = s_i_zipcode;
    }

    public double getS_r_purchase_price() {
        return s_r_purchase_price;
    }

    public void setS_r_purchase_price(double s_r_purchase_price) {
        this.s_r_purchase_price = s_r_purchase_price;
    }

    public String getS_r_purchase_type() {
        return s_r_purchase_type;
    }

    public void setS_r_purchase_type(String s_r_purchase_type) {
        this.s_r_purchase_type = s_r_purchase_type;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.s_i_names);
        hash = 37 * hash + Objects.hashCode(this.s_i_phone);
        hash = 37 * hash + Objects.hashCode(this.s_i_street_1);
        hash = 37 * hash + Objects.hashCode(this.s_i_street_2);
        hash = 37 * hash + Objects.hashCode(this.s_i_city);
        hash = 37 * hash + Objects.hashCode(this.s_i_state);
        hash = 37 * hash + Objects.hashCode(this.s_i_zipcode);
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.s_r_purchase_price) ^ (Double.doubleToLongBits(this.s_r_purchase_price) >>> 32));
        hash = 37 * hash + Objects.hashCode(this.s_r_purchase_type);
        hash = 37 * hash + this.user_id;
        hash = 37 * hash + this.car_id;
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
        final Sales_Information_Record other = (Sales_Information_Record) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.s_r_purchase_price) != Double.doubleToLongBits(other.s_r_purchase_price)) {
            return false;
        }
        if (this.user_id != other.user_id) {
            return false;
        }
        if (this.car_id != other.car_id) {
            return false;
        }
        if (!Objects.equals(this.s_i_names, other.s_i_names)) {
            return false;
        }
        if (!Objects.equals(this.s_i_phone, other.s_i_phone)) {
            return false;
        }
        if (!Objects.equals(this.s_i_street_1, other.s_i_street_1)) {
            return false;
        }
        if (!Objects.equals(this.s_i_street_2, other.s_i_street_2)) {
            return false;
        }
        if (!Objects.equals(this.s_i_city, other.s_i_city)) {
            return false;
        }
        if (!Objects.equals(this.s_i_state, other.s_i_state)) {
            return false;
        }
        if (!Objects.equals(this.s_i_zipcode, other.s_i_zipcode)) {
            return false;
        }
        if (!Objects.equals(this.s_r_purchase_type, other.s_r_purchase_type)) {
            return false;
        }
        return true;
    }

    
    
    
    @Override
    public String toString() {
        return "Sales_information_record{" + "id=" + id + ", s_i_names=" + s_i_names + ", s_i_phone=" + s_i_phone + ", s_i_street_1=" + s_i_street_1 + ", s_i_street_2=" + s_i_street_2 + ", s_i_city=" + s_i_city + ", s_i_state=" + s_i_state + ", s_i_zipcode=" + s_i_zipcode + ", s_r_purchase_price=" + s_r_purchase_price + ", s_r_purchase_type=" + s_r_purchase_type + ", user_id=" + user_id + ", car_id=" + car_id + '}';
    }
    
    
    
    
    
    
    
    
}
