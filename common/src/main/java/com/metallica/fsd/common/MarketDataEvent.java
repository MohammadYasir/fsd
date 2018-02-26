/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metallica.fsd.common;

import java.io.Serializable;

/**
 *
 * @author myasir
 */
public class MarketDataEvent implements Serializable{
    private String code;
    private double price;

    public MarketDataEvent() {
        code = "LN";
        price = 67.0;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
}
