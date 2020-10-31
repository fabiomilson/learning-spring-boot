package com.learning.springboot.api.controller;

import com.learning.springboot.domain.exception.EntityInUseException;
import com.learning.springboot.domain.exception.EntityNotFoundException;
import com.learning.springboot.domain.model.Restaurant;
import com.learning.springboot.model.service.RegisterRestaurant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurants")
public class ControllerRestaurant {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerRestaurant.class);

    @Autowired
    private RegisterRestaurant registerRestaurant;

    @GetMapping
    public ResponseEntity<Iterable<Restaurant>> listAll(){
        return ResponseEntity.ok(registerRestaurant.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> findById(@PathVariable Integer id){
        return ResponseEntity.ok(registerRestaurant.findById(id));
    }

    @PostMapping
    public ResponseEntity<Restaurant> save(@RequestBody Restaurant body){
        return ResponseEntity.status(HttpStatus.CREATED).body(registerRestaurant.save(body));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> update(@PathVariable Integer id, @RequestBody Restaurant body){
        return ResponseEntity.ok(registerRestaurant.update(id, body));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        try {
            registerRestaurant.delete(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            LOGGER.error("EntityNotFoundException", e);
            return ResponseEntity.notFound().build();
        } catch (EntityInUseException e) {
            LOGGER.error("EntityNotFoundException", e);
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
