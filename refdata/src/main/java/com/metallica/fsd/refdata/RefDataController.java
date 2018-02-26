/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metallica.fsd.refdata;

import com.metallica.fsd.refdata.entities.Commodity;
import com.metallica.fsd.refdata.entities.CounterParty;
import com.metallica.fsd.refdata.entities.Location;
import com.metallica.fsd.refdata.repo.CommodityRepo;
import com.metallica.fsd.refdata.repo.CounterPartyRepo;
import com.metallica.fsd.refdata.repo.LocationsRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author myasir
 */
@RestController
public class RefDataController {
    
    @Autowired
    private LocationsRepo locationsRepo;
    
    @Autowired
    private CounterPartyRepo counterPartyRepo;
    
    @Autowired
    private CommodityRepo commodityRepo;
    
    
    @GetMapping("/locations")
    public List<Location> getLocations() {
        return locationsRepo.findAll();
    }
    
    @GetMapping("/counterparties")
    public List<CounterParty> getCounterParties() {
        return counterPartyRepo.findAll();
    }
    
    @GetMapping("/commodities")
    public List<Commodity> getCommodities() {
        return commodityRepo.findAll();
    }
    
}
