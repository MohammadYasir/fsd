/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metallica.fsd.tradeservice;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author myasir
 */
@Entity
@Table(name = "trades")
public class Trade implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotBlank
    private Side side;
    
    @NotBlank
    private int quantity;
    
    @NotBlank
    private double price;
    
    @NotBlank
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date tradeDate;
    
    @NotBlank
    private TradeStatus status;
    
    @NotBlank
    private long commodityId;
    
    @NotBlank
    private long counterPartyId;
    
    @NotBlank
    private long locationId;

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
    }

    public TradeStatus getStatus() {
        return status;
    }

    public void setStatus(TradeStatus status) {
        this.status = status;
    }

    public long getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(long commodityId) {
        this.commodityId = commodityId;
    }

    public long getCounterPartyId() {
        return counterPartyId;
    }

    public void setCounterPartyId(long counterPartyId) {
        this.counterPartyId = counterPartyId;
    }

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
