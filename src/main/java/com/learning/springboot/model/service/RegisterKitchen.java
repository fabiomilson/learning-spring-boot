package com.learning.springboot.model.service;

import com.learning.springboot.domain.model.Kitchen;
import com.learning.springboot.domain.repository.RepositoryKitchen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterKitchen {

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

    public void delete(Kitchen kitchen) {
        repositoryKitchen.delete(kitchen);
    }
}
