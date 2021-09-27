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


public class Cars 
{
    
    private int id;
    private boolean newCar;
    private String carName;
    private String make;
    private String model;
    private String carType;
    private String bodyStyle;
    private int makeYear;
    private String trans;
    private String color;
    private String interiorColor;
    private int mileage;
    private String vinNumber;
    private double salesPrice;
    private double msrp;
    private String carDescription;
    private String pictureURL;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isNewCar() {
        return newCar;
    }

    public void setNewCar(boolean newCar) {
        this.newCar = newCar;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getBodyStyle() {
        return bodyStyle;
    }

    public void setBodyStyle(String bodyStyle) {
        this.bodyStyle = bodyStyle;
    }

    public int getMakeYear() {
        return makeYear;
    }

    public void setMakeYear(int makeYear) {
        this.makeYear = makeYear;
    }

    public String getTrans() {
        return trans;
    }

    public void setTrans(String trans) {
        this.trans = trans;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getInteriorColor() {
        return interiorColor;
    }

    public void setInteriorColor(String interiorColor) {
        this.interiorColor = interiorColor;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public double getMsrp() {
        return msrp;
    }

    public void setMsrp(double msrp) {
        this.msrp = msrp;
    }

    public String getCarDescription() {
        return carDescription;
    }

    public void setCarDescription(String carDescription) {
        this.carDescription = carDescription;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.id;
        hash = 29 * hash + (this.newCar ? 1 : 0);
        hash = 29 * hash + Objects.hashCode(this.carName);
        hash = 29 * hash + Objects.hashCode(this.make);
        hash = 29 * hash + Objects.hashCode(this.model);
        hash = 29 * hash + Objects.hashCode(this.carType);
        hash = 29 * hash + Objects.hashCode(this.bodyStyle);
        hash = 29 * hash + this.makeYear;
        hash = 29 * hash + Objects.hashCode(this.trans);
        hash = 29 * hash + Objects.hashCode(this.color);
        hash = 29 * hash + Objects.hashCode(this.interiorColor);
        hash = 29 * hash + this.mileage;
        hash = 29 * hash + Objects.hashCode(this.vinNumber);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.salesPrice) ^ (Double.doubleToLongBits(this.salesPrice) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.msrp) ^ (Double.doubleToLongBits(this.msrp) >>> 32));
        hash = 29 * hash + Objects.hashCode(this.carDescription);
        hash = 29 * hash + Objects.hashCode(this.pictureURL);
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
        final Cars other = (Cars) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.newCar != other.newCar) {
            return false;
        }
        if (this.makeYear != other.makeYear) {
            return false;
        }
        if (this.mileage != other.mileage) {
            return false;
        }
        if (Double.doubleToLongBits(this.salesPrice) != Double.doubleToLongBits(other.salesPrice)) {
            return false;
        }
        if (Double.doubleToLongBits(this.msrp) != Double.doubleToLongBits(other.msrp)) {
            return false;
        }
        if (!Objects.equals(this.carName, other.carName)) {
            return false;
        }
        if (!Objects.equals(this.make, other.make)) {
            return false;
        }
        if (!Objects.equals(this.model, other.model)) {
            return false;
        }
        if (!Objects.equals(this.carType, other.carType)) {
            return false;
        }
        if (!Objects.equals(this.bodyStyle, other.bodyStyle)) {
            return false;
        }
        if (!Objects.equals(this.trans, other.trans)) {
            return false;
        }
        if (!Objects.equals(this.color, other.color)) {
            return false;
        }
        if (!Objects.equals(this.interiorColor, other.interiorColor)) {
            return false;
        }
        if (!Objects.equals(this.vinNumber, other.vinNumber)) {
            return false;
        }
        if (!Objects.equals(this.carDescription, other.carDescription)) {
            return false;
        }
        if (!Objects.equals(this.pictureURL, other.pictureURL)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cars{" + "id=" + id + ", newCar=" + newCar + ", carName=" + carName + ", make=" + make + ", model=" + model + ", carType=" + carType + ", bodyStyle=" + bodyStyle + ", makeYear=" + makeYear + ", trans=" + trans + ", color=" + color + ", interiorColor=" + interiorColor + ", mileage=" + mileage + ", vinNumber=" + vinNumber + ", salesPrice=" + salesPrice + ", msrp=" + msrp + ", carDescription=" + carDescription + ", pictureURL=" + pictureURL + '}';
    }
    
    

    
    
    
    
    
    
}
