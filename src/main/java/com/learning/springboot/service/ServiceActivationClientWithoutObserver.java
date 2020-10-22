package com.learning.springboot.service;

import com.learning.springboot.UrgencyLevel;
import com.learning.springboot.model.Client;
import com.learning.springboot.notification.Notifier;
import com.learning.springboot.service.annotations.TypeNotifier;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class ServiceActivationClientWithoutObserver {

    @Autowired
    //@Qualifier("sms")
    @TypeNotifier(UrgencyLevel.NORMAL)
    private Notifier notifier;

    @PostConstruct
    public void init(){
        System.out.println("Init Bean -> ServiceActivationClient");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroy Bean -> ServiceActivationClient");
    }

    public void activate(Client client){
        client.activate();
        notifier.notify(client, "Client has been activated.");
    }
}
