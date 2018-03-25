package io.jittakal.ms.restaurant.data.repository;

import io.jittakal.ms.restaurant.data.entity.City;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, Long>{

    City findByName(String name);

}
