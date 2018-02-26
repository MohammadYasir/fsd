/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metallica.fsd.tradeservice;

import java.io.Serializable;

/**
 *
 * @author myasir
 */
public class TradeCreationMessage implements Serializable{
    private Trade trade;
    private String message;

    public Trade getTrade() {
        return trade;
    }

    public void setTrade(Trade trade) {
        this.trade = trade;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
