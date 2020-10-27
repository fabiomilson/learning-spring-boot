package com.learning.springboot.api.controller;

import com.learning.springboot.domain.model.State;
import com.learning.springboot.domain.repository.RepositoryState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/states")
public class ControllerState {

    @Autowired
    private RepositoryState repositoryState;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Iterable<State> findAll(){
        return repositoryState.findAll();
    }
}
