/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metallica.fsd.tradeservice;

import java.util.List;
import javax.validation.Valid;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author myasir
 */
@RestController
public class TradeController {
    
    @Autowired
    private TradeRepository repository;
    
    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    @GetMapping("/trades")
    public List<Trade> getAllTrades(){
        return repository.findAll();
    }
    
    @PostMapping("/createtrade")
    public Trade createTrade(@Valid @RequestBody Trade trade) {
        Trade createdTrade = repository.save(trade);
        TradeCreationMessage msg = new TradeCreationMessage();
        msg.setTrade(createdTrade);
        msg.setMessage("Trade with trade id: "+createdTrade.getId()+" created successfully");
        rabbitTemplate.convertAndSend(TradeServiceApplication.EXCHANGE_NAME, TradeServiceApplication.ROUTING_KEY, msg);
        return createdTrade;
    }
}
