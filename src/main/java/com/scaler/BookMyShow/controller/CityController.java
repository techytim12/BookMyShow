package com.scaler.BookMyShow.controller;

import com.scaler.BookMyShow.dto.CityRequestDTO;
import com.scaler.BookMyShow.dto.CityResponseDTO;
import com.scaler.BookMyShow.model.City;
import com.scaler.BookMyShow.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/city/{name}")
    public ResponseEntity getCityByName(@PathVariable String name){
        System.out.println("IN SOUT");
        try{
            City city = cityService.getCityByName(name);
            return ResponseEntity.ok(city);
        } catch (Exception e){
            e.printStackTrace();
        }

        return ResponseEntity.ok("Not Found");
    }

    @GetMapping("/city")
    public ResponseEntity getCities(){
        List<City> cities = cityService.getAllCities();
        List<CityResponseDTO> responseDTOS = new ArrayList<>();

        for(City city : cities){
            CityResponseDTO dto = new CityResponseDTO();
            dto.setName(city.getName());
            responseDTOS.add(dto);
        }

        return ResponseEntity.ok(responseDTOS);
    }

    @PostMapping("/city")
    public ResponseEntity createCity(@RequestBody CityRequestDTO cityRequestDTO){

        try{
            String cityName = cityRequestDTO.getName();
            if(cityName == null ||  cityName.isEmpty() || cityName.isBlank()){
                throw new Exception("City name is invalid");
            }
            City savedCity = cityService.saveCity(cityName);
            return ResponseEntity.ok(savedCity);

        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @DeleteMapping("/city/{id}")
    public ResponseEntity deleteCity(@PathVariable("id") int cityId){
        boolean isDeleted = cityService.deleteCity(cityId);
        if(isDeleted){
            return ResponseEntity.ok("Deleted city id: "+cityId);
        } else {
            return ResponseEntity.ok("Not found");
        }
    }
}
