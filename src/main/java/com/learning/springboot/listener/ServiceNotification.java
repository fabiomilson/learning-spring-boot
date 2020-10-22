package com.learning.springboot.listener;

import com.learning.springboot.UrgencyLevel;
import com.learning.springboot.notification.Notifier;
import com.learning.springboot.service.annotations.TypeNotifier;
import com.learning.springboot.service.event.EventActiveClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ServiceNotification {

    @Autowired
    @TypeNotifier(UrgencyLevel.NORMAL)
    private Notifier notifier;

    @EventListener
    public void acitiveClientListener(EventActiveClient event){
        notifier.notify(event.getClient(), "LISTENER CLIENT HAS BEEN ACTIVATED");
    }
}
