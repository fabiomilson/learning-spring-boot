package com.learning.springboot.notification;

import com.learning.springboot.model.Client;

public class NotifierSMS implements Notifier {

    public NotifierSMS() {
        System.out.println("NotifierSMS -> OK");
    }

    @Override
    public void notify(Client client, String message) {
        System.out.printf("Notify SMS %s - Message: %s%n", client.getName(), message);
    }
}
