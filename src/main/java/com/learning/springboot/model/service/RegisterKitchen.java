package com.learning.springboot.model.service;

import com.learning.springboot.api.controller.ControllerKitchen;
import com.learning.springboot.domain.exception.BusinessException;
import com.learning.springboot.domain.exception.EntityInUseException;
import com.learning.springboot.domain.exception.EntityNotFoundException;
import com.learning.springboot.domain.model.Kitchen;
import com.learning.springboot.domain.repository.RepositoryKitchen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class RegisterKitchen {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerKitchen.class);

    @Autowired
    private RepositoryKitchen repositoryKitchen;

    public Kitchen save(Kitchen kitchen){
        return repositoryKitchen.save(kitchen);
    }

    public Iterable<Kitchen> findAll() {
        return repositoryKitchen.findAll();
    }

    public Optional<Kitchen> findById(Integer id) {
        return repositoryKitchen.findById(id);
    }

    public void delete(Integer id) throws EntityNotFoundException, EntityInUseException {
        try {
            Kitchen kitchen = repositoryKitchen.findById(id).get();
            repositoryKitchen.delete(kitchen);
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
