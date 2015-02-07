package com.enrique.eventbusarchitecture.events;

import lombok.Data;

@Data
public class DoLoginEvent {
    private String username;
    private String password;

    public DoLoginEvent(String username, String password) {
        this.username = username;
        this.password = password;
    }
}