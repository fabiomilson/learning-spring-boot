package com.learning.springboot.notification;

import com.learning.springboot.model.Client;

public class NotifierEmail implements Notifier {

    private boolean upperCase;
    private String hostSmtp;

    public NotifierEmail(String hostSmtp) {
        this.hostSmtp = hostSmtp;
        System.out.println("NotifierEmail -> Real OK");
    }

    @Override
    public void notify(Client client, String message) {
        if(this.upperCase){
            message = message.toUpperCase();
        }
        System.out.printf("Notify %s - Message: %s%n - Host: %s%n", client.getName(),
                message, hostSmtp);
    }

    public void setUpperCase(boolean upperCase) {
        this.upperCase = upperCase;
    }
}
