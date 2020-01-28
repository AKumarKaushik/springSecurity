package com.example.SpringBoot.demoSpringBoot.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

public class Database {
    @Value("${database.port}")
    private int port;
    @Value("${database.name}")
    private String name;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Database(int port, String name) {
        this.port = port;
        this.name = name;
    }

    public Database(){

    }
}
