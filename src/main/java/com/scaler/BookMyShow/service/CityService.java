package com.scaler.BookMyShow.service;

import com.scaler.BookMyShow.model.City;
import com.scaler.BookMyShow.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public City saveCity(String cityName){
        City city = new City();
        city.setName(cityName);
        return cityRepository.save(city);
    }

    public boolean deleteCity(int cityId){
        boolean cityExists = cityRepository.existsById(cityId);
        if(!cityExists){
            return false;
        }
        cityRepository.deleteById(cityId);
        return true;
    }

    public City getCityByName(String cityName){
        return cityRepository.findCityByName(cityName);
    }
}
