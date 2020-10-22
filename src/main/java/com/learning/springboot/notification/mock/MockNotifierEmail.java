package com.learning.springboot.notification.mock;

import com.learning.springboot.model.Client;
import com.learning.springboot.notification.Notifier;

public class MockNotifierEmail implements Notifier {

    private boolean upperCase;
    private String hostSmtp;

    public MockNotifierEmail(String hostSmtp) {
        this.hostSmtp = hostSmtp;
        System.out.println("NotifierEmail -> Mock OK");
    }

    @Override
    public void notify(Client client, String message) {
        if(this.upperCase){
            message = message.toUpperCase();
        }
        System.out.printf("MOCK - DEV - Notify %s - Message: %s%n - Host: %s%n", client.getName(),
                message, hostSmtp);
    }

    public void setUpperCase(boolean upperCase) {
        this.upperCase = upperCase;
    }
}
