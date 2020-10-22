package com.learning.springboot.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Crud {

    @PersistenceContext
    private EntityManager manager;

    public EntityManager getManager() {
        return manager;
    }

}
