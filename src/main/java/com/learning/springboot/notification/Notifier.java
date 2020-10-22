package com.learning.springboot.notification;

import com.learning.springboot.model.Client;

public interface Notifier {

    void notify(Client client, String message);

}
