package com.learning.springboot.model.service;

import com.learning.springboot.domain.exception.EntityInUseException;
import com.learning.springboot.domain.exception.EntityNotFoundException;
import com.learning.springboot.domain.model.Restaurant;
import com.learning.springboot.infrastructure.repository.RepositoryRestaurant;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class RegisterRestaurant {

    @Autowired
    private RepositoryRestaurant repositoryRestaurant;

    public Iterable<Restaurant> findAll() {
        return repositoryRestaurant.findAll();
    }

    public Restaurant findById(Integer id) {
        return repositoryRestaurant.findById(id).get();
    }

    public Restaurant save(Restaurant body) {
        return repositoryRestaurant.save(body);
    }

    public Restaurant update(Integer id, Restaurant restaurant) {
        var restaurantById = findById(id);
        BeanUtils.copyProperties(restaurant, restaurantById, "id");
        return save(restaurantById);
    }

    public void delete(Integer id) throws EntityNotFoundException, EntityInUseException {
        try {
            Restaurant kitchen = repositoryRestaurant.findById(id).get();
            repositoryRestaurant.delete(kitchen);
        } catch(EmptyResultDataAccessException | NoSuchElementException e){
            throw new EntityNotFoundException(
                    String.format(
                            "Kitchen with id %s has not been found", id), e);
        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseException(
                    String.format(
                            "Kitchen with id %s is not removed as it is in use", id), e);
        }
    }
}
