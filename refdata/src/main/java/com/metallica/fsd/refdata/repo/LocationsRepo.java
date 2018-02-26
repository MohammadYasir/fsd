/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metallica.fsd.refdata.repo;

import com.metallica.fsd.refdata.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author myasir
 */
public interface LocationsRepo extends JpaRepository<Location, Long>{}
