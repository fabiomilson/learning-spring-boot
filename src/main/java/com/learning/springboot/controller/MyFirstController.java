package com.learning.springboot.controller;

import com.learning.springboot.model.Client;
import com.learning.springboot.service.ServiceActivationClient;
import com.learning.springboot.service.ServiceActivationClientWithoutObserver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyFirstController {

    private ServiceActivationClient serviceActivationClient;

    public MyFirstController(ServiceActivationClient serviceActivationClient) {
        this.serviceActivationClient = serviceActivationClient;
        System.out.println("MyFirstController -> OK");
    }

    @GetMapping("/helloWorld")
    @ResponseBody
    public String hello(){
        Client client = new Client("João", "joao@asd.com", "123456789");
        this.serviceActivationClient.activate(client);
        return "Hello World Spring asdsad!";
    }
}
