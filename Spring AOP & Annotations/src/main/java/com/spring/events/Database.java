package com.spring.events;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class Database implements ApplicationEventPublisherAware {
    private int port;
    private String name;

    ApplicationEventPublisher aef;

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

    @Override
    public String toString() {
        return "Database{" +
                "port=" + port +
                ", name='" + name + '\'' +
                '}';
    }

    public void connect(){
        CustomEvent customEvent = new CustomEvent(this);
        aef.publishEvent(customEvent);
        System.out.println("Database Connected");
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
//        System.out.println("Into Set Publisher");
        this.aef = applicationEventPublisher;
    }
}
