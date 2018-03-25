package io.jittakal.ms.restaurant.controller;

import com.google.common.collect.ImmutableList;
import io.jittakal.ms.restaurant.data.entity.City;
import io.jittakal.ms.restaurant.data.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public List<City> all(){
        return ImmutableList.copyOf(cityRepository.findAll());
    }

    @RequestMapping(value = "/v1/cities", method = RequestMethod.GET, produces = "application/json")
    public List<City> cities(){
        return ImmutableList.copyOf(cityRepository.findAll());
    }

    @RequestMapping(value ="/v1/city", method= RequestMethod.GET, produces = "application/json")
    public City cityByName(@RequestParam String name){
        return cityRepository.findByName(name);
    }

    // TODO: create city

    // TODO: update city

    // TODO: delete city

}
