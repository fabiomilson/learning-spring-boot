package com.learning.springboot.api.controller;


import com.learning.springboot.domain.model.Kitchen;
import com.learning.springboot.domain.repository.RepositoryKitchen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

//@Controller
//@ResponseBody
@RestController
@RequestMapping("/kitchens")
public class ControllerKitchen {

    @Autowired
    private RepositoryKitchen repositoryKitchen;

    @RequestMapping
    public Iterable<Kitchen> findAll(){
        return repositoryKitchen.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Kitchen> findById(@PathVariable("id") Integer id){
        return repositoryKitchen.findById(id);
    }

}
