package com.learning.springboot.api.controller;


import com.learning.springboot.domain.model.Kitchen;
import com.learning.springboot.domain.model.XmlWrapperKitchen;
import com.learning.springboot.domain.repository.RepositoryKitchen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

//@Controller
//@ResponseBody
@RestController
@RequestMapping("/kitchens")
public class ControllerKitchen {

    private static final String DEFAULT_PATH = "/kitchens";

    @Autowired
    private RepositoryKitchen repositoryKitchen;

    @GetMapping
    public Iterable<Kitchen> findAll(){
        return repositoryKitchen.findAll();
    }

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public XmlWrapperKitchen findAllXml(){
        return new XmlWrapperKitchen(repositoryKitchen.findAll());
    }

    /**
     * Example response with entity using from my model
     * @GetMapping("/{id}")
     * public Kitchen findById(@PathVariable("id") Integer id){
     *   return repositoryKitchen.findById(id).orElseGet(() -> null);}
     **/

    @GetMapping("/{id}")
    public ResponseEntity<Kitchen> findById(@PathVariable("id") Integer id){
        var kitchen = repositoryKitchen.findById(id).orElseGet(() -> null);

        //return ResponseEntity.status(HttpStatus.OK).body(kitchen);
        //return ResponseEntity.ok(kitchen);

        /*var headers = new HttpHeaders();
        headers.add(HttpHeaders.LOCATION, "http://api.learning.springboot.local:8080/kitchens");
        return ResponseEntity.status(HttpStatus.FOUND).headers(headers).body(kitchen);*/

        if(kitchen != null) {
            return ResponseEntity.ok(kitchen);
        }

        //return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Kitchen add(@RequestBody Kitchen kitchen){
        return repositoryKitchen.save(kitchen);
    }
}
