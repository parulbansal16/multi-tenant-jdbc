package com.sense.writeback.controller;

import com.sense.writeback.models.City;
import com.sense.writeback.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.sql.SQLException;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping
    public Mono<City> save(@RequestBody City city) throws SQLException {
        return cityService.save(city);
    }

    @GetMapping
    public Mono<Iterable<City>> getAll() throws SQLException {
        return cityService.findAll();
    }

}
