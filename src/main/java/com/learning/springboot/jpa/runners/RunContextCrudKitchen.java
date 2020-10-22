package com.learning.springboot.jpa.runners;

import com.learning.springboot.LearningSpringbootApplication;
import com.learning.springboot.domain.model.Kitchen;
import com.learning.springboot.domain.repository.RepositoryKitchen;
import com.learning.springboot.infrastructure.repository.RepositoryImplKitchen;
import com.learning.springboot.jpa.CrudKitchen;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class RunContextCrudKitchen {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new SpringApplicationBuilder(LearningSpringbootApplication.class)
                        .web(WebApplicationType.NONE)
                        .run(args);

        CrudKitchen crudKitchen = applicationContext.getBean(CrudKitchen.class);

        var kitchenBR = Kitchen.ofName("Brazilian");
        var kitchenEUA = Kitchen.ofName("United State");

        crudKitchen.add(kitchenBR);
        crudKitchen.add(kitchenEUA);

        List<Kitchen> kitchens = crudKitchen.listAll();
        kitchens.forEach(System.out::println);

        var kitchen = crudKitchen.find(1);
        System.out.printf("Search by id on database: %s%n", kitchen);

        kitchen = Kitchen.of(kitchen.getId(), "Chinese");
        kitchen = crudKitchen.add(kitchen);
        System.out.printf("Update by id on database: %s%n", kitchen);

        crudKitchen.remove(kitchen);
        kitchen = crudKitchen.find(1);
        System.out.printf("Delete by id on database: %s%n", kitchen);


        RepositoryKitchen repositoryImplKitchen = applicationContext.getBean(RepositoryKitchen.class);

        Kitchen rio_janeiro = repositoryImplKitchen.save(new Kitchen("Rio Janeiro"));
        Kitchen brasilia = repositoryImplKitchen.save(new Kitchen("Brasilia"));

        repositoryImplKitchen.save(rio_janeiro);
        repositoryImplKitchen.save(brasilia);

        Iterable<Kitchen> kitchensRepository = repositoryImplKitchen.findAll();
        kitchensRepository.forEach(System.out::println);

        var kitchenRepositoryResult = repositoryImplKitchen.findById(6).get();
        System.out.printf("Search by id on database using repository pattern: %s%n", kitchenRepositoryResult);

        kitchenRepositoryResult = Kitchen.of(kitchenRepositoryResult.getId(), "ChineseBrasilia");
        kitchenRepositoryResult = repositoryImplKitchen.save(kitchenRepositoryResult);
        System.out.printf("Update by id on database using repository: %s%n", kitchenRepositoryResult);
    }

}
