package com.learning.springboot.api.controller;


import com.learning.springboot.domain.model.Kitchen;
import com.learning.springboot.domain.model.XmlWrapperKitchen;
import com.learning.springboot.domain.repository.RepositoryKitchen;
import com.learning.springboot.model.service.RegisterKitchen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

//@Controller
//@ResponseBody
@RestController
@RequestMapping("/kitchens")
public class ControllerKitchen {

    private static final String DEFAULT_PATH = "/kitchens";
    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerKitchen.class);

    @Autowired
    private RegisterKitchen registerKitchen;

    @GetMapping
    public Iterable<Kitchen> findAll() {
        return registerKitchen.findAll();
    }

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public XmlWrapperKitchen findAllXml() {
        return new XmlWrapperKitchen(registerKitchen.findAll());
    }

    /**
     * Example response with entity using from my model
     *
     * @GetMapping("/{id}") public Kitchen findById(@PathVariable("id") Integer id){
     * return repositoryKitchen.findById(id).orElseGet(() -> null);}
     **/

    @GetMapping("/{id}")
    public ResponseEntity<Kitchen> findById(@PathVariable("id") Integer id) {
        var kitchen = registerKitchen.findById(id).orElseGet(() -> null);

        //return ResponseEntity.status(HttpStatus.OK).body(kitchen);
        //return ResponseEntity.ok(kitchen);

        /*var headers = new HttpHeaders();
        headers.add(HttpHeaders.LOCATION, "http://api.learning.springboot.local:8080/kitchens");
        return ResponseEntity.status(HttpStatus.FOUND).headers(headers).body(kitchen);*/

        if (kitchen != null) {
            return ResponseEntity.ok(kitchen);
        }

        //return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Kitchen add(@RequestBody Kitchen kitchen) {
        return registerKitchen.save(kitchen);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Kitchen> update(@PathVariable Integer id, @RequestBody Kitchen kitchen) {
        try {
            Kitchen kitchenFromRepository = registerKitchen.findById(id).get();
            BeanUtils.copyProperties(kitchen, kitchenFromRepository, "id");
            Kitchen kitchenUpdated = registerKitchen.save(kitchenFromRepository);
            return ResponseEntity.ok(kitchenUpdated);
        } catch (NoSuchElementException e) {
            LOGGER.error("Update -> NoSuchElementException: ", e);
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Kitchen> delete(@PathVariable Integer id){
        try {
            Kitchen kitchen = registerKitchen.findById(id).get();
            registerKitchen.delete(kitchen);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (DataIntegrityViolationException e) {
            LOGGER.error("Update -> DataIntegrityViolationException: ", e);
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

    }

}
