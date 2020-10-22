package com.learning.springboot.infrastructure.repository;

import com.learning.springboot.domain.model.Kitchen;
import com.learning.springboot.domain.repository.RepositoryKitchen;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

//@Component
public class RepositoryImplKitchen { //implements RepositoryKitchen<Kitchen, Integer> {
/*
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Kitchen> listAll(){
        return getManager().createQuery("from Kitchen").getResultList();
    }

    @Override
    @Transactional
    public Kitchen save(Kitchen kitchen){
        return getManager().merge(kitchen);
    }

    @Override
    public Kitchen find(int id) {
        return getManager().find(Kitchen.class, id);
    }

    @Override
    @Transactional
    public void remove(Kitchen kitchen) {
        getManager().remove(find(kitchen.getId()));
    }

    private EntityManager getManager() {
        return this.manager;
    }*/
}
