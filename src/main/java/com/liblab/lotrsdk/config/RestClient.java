package com.liblab.lotrsdk.config;

import org.springframework.stereotype.Component;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

@Component
public class RestClient {

    private Client client = ClientBuilder.newClient();

    public Client getClient() {
        return client;
    }
}
