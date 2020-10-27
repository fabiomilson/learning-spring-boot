package com.learning.springboot.domain.repository;

import com.learning.springboot.domain.model.State;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryState extends CrudRepository<State, Integer>  {
}
