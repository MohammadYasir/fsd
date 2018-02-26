/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metallica.fsd.marketdata.datagen;

import com.metallica.fsd.common.MarketDataEvent;
import com.metallica.fsd.marketdata.MarketDataServiceApplication;
import java.util.Random;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.broker.BrokerAvailabilityEvent;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * @author myasir
 */
@Component
public class MarketDataGenerator implements ApplicationListener<BrokerAvailabilityEvent>{

    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    @Override
    public void onApplicationEvent(BrokerAvailabilityEvent e) {}
    
    @Scheduled(fixedDelay = 5000)
    public void sendDataUpdate(){
        Random ran = new Random();
        MarketDataEvent dataEvent = new MarketDataEvent();
        dataEvent.setPrice(ran.nextDouble());
        System.out.println(dataEvent.getPrice());
        rabbitTemplate.convertAndSend(MarketDataServiceApplication.EXCHANGE_NAME, MarketDataServiceApplication.ROUTING_KEY, dataEvent);
    }
}
