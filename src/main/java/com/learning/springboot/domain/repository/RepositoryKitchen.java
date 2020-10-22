package com.learning.springboot.domain.repository;

import com.learning.springboot.domain.model.Kitchen;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryKitchen extends CrudRepository<Kitchen, Integer> {

}
