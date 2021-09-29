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
public class Make 
{
    private int id;
    private String make;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.id;
        hash = 79 * hash + Objects.hashCode(this.make);
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
        final Make other = (Make) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.make, other.make)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() 
    {
        return "Make{" + "id=" + id + ", make=" + make + '}';
    }
    
    
    
    
}
