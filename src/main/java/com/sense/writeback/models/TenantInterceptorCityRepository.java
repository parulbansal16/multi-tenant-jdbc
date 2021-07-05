package com.sense.writeback.models;

import com.sense.writeback.interceptor.TenantContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TenantInterceptorCityRepository {
    @Autowired
    private CityRepository cityRepository;

    public List<City> findAll(String tanantId){
        TenantContext.setCurrentTenant(tanantId);
        List<City> cities = cityRepository.findAll();
        TenantContext.clear();
        return cities;
    }
}
