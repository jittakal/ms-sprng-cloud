package io.jittakal.ms.restaurant.data.repository;

import io.jittakal.ms.restaurant.data.entity.City;
import io.jittakal.ms.restaurant.data.entity.Restaurant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {

    List<Restaurant> findByCity(City city);

}
