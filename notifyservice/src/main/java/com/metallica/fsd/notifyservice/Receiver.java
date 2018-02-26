/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metallica.fsd.notifyservice;

import com.metallica.fsd.common.MarketDataEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.stereotype.Service;

/**
 *
 * @author myasir
 */
@Service
public class Receiver {
    
    @Autowired
    private MappingJackson2MessageConverter converter;
    
    @Autowired
    private BroadcastService service;
    
    @RabbitListener(queues = NotificationServiceApplication.QUEUE_GENERIC_NAME)
    public void receiveMessage(MarketDataEvent dataEvent) {
        System.out.println("price: "+dataEvent.getPrice());
        System.out.println("code: "+dataEvent.getCode());
        service.broadcast(dataEvent);
    }
}
