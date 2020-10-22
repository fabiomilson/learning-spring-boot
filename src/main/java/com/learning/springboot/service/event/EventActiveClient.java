package com.learning.springboot.service.event;

import com.learning.springboot.model.Client;

public class EventActiveClient {

    private Client client;

    public EventActiveClient(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }
}
