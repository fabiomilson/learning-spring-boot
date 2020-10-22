package com.learning.springboot.service;

import com.learning.springboot.model.Client;
import com.learning.springboot.service.event.EventActiveClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class ServiceActivationClient {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public void activate(Client client){
        client.activate();
        eventPublisher.publishEvent(new EventActiveClient(client));
    }
}
