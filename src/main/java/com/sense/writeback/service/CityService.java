package com.sense.writeback.service;

import com.sense.writeback.models.City;
import com.sense.writeback.models.CityRepository;
import com.sense.writeback.models.TenantInterceptorCityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;


    @Autowired
    private TenantInterceptorCityRepository tenantInterceptorCityRepository;

    @Autowired
    private AsyncScheduler scheduler;

    public Mono<City> save(City city) {
        return scheduler.async(() -> cityRepository.save(city));
    }

    public Mono<Iterable<City>> findAll() {
        return scheduler.async(() -> cityRepository.findAll());
    }


}