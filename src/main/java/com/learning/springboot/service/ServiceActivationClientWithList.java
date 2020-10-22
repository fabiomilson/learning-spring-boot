package com.learning.springboot.service;

import com.learning.springboot.model.Client;
import com.learning.springboot.notification.Notifier;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ServiceActivationClientWithList {

    @Autowired
    private List<Notifier> notifiers;

    public void activate(Client client){
        client.activate();
        notifiers.forEach((notifier -> {
            notifier.notify(client, "Client has been activated.");
        }));
    }
}
