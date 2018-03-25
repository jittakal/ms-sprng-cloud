package io.jittakal.ms.restaurant.controller;

import com.google.common.collect.ImmutableList;
import io.jittakal.ms.restaurant.data.entity.City;
import io.jittakal.ms.restaurant.data.entity.Restaurant;
import io.jittakal.ms.restaurant.data.repository.CityRepository;
import io.jittakal.ms.restaurant.data.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private CityRepository cityRepository;

    @RequestMapping(value = "/v1/restaurant", method= RequestMethod.GET, produces = "application/json")
    public List<Restaurant> restaurants() {
        return ImmutableList.copyOf(restaurantRepository.findAll());
    }

    @RequestMapping(value = "/v1/restaurant", method = RequestMethod.GET, produces = "application/json")
    public List<Restaurant> restaurantsByCity(@RequestParam String city){
        City reqCity = cityRepository.findByName(city);
        return ImmutableList.copyOf(restaurantRepository.findByCity(reqCity));
    }

}
