package com.learning.springboot.infrastructure.repository;

import com.learning.springboot.domain.model.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryRestaurant extends CrudRepository<Restaurant, Integer> {
}
