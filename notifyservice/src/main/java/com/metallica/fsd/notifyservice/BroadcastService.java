/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metallica.fsd.notifyservice;

import com.metallica.fsd.common.MarketDataEvent;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

/**
 *
 * @author myasir
 */
@Service
public class BroadcastService {
    
    @SendTo("/databroker/marketdata")
    public byte[] broadcast(byte[] bytes){
        System.out.println("broadcast()==> called");
        return bytes;
    }
}
