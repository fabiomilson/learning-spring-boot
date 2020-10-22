package com.learning.springboot.jpa;

import com.learning.springboot.domain.model.Kitchen;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class CrudKitchen extends Crud {

    public List<Kitchen> listAll(){
        return getManager().createQuery("from Kitchen").getResultList();
    }

    @Transactional
    public Kitchen add(Kitchen kitchen){
        return getManager().merge(kitchen);
    }

    public Kitchen find(int id) {
        return getManager().find(Kitchen.class, id);
    }

    @Transactional
    public void remove(Kitchen kitchen) {
        getManager().remove(find(kitchen.getId()));
    }
}
