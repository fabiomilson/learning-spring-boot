package com.learning.springboot.service;

import com.learning.springboot.service.event.EventActiveClient;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ServiceIssueInvoice {

    @EventListener
    public void clienctIssueInvoice(EventActiveClient event){
        System.out.println("Issue Invoice for " + event.getClient().getName());
    }

}
