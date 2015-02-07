package com.enrique.eventbusarchitecture.login;

import com.enrique.eventbusarchitecture.EDEventBus;
import com.enrique.eventbusarchitecture.events.DoLoginEvent;

public class LoginPresenter {
    public void performLogin(String username, String password) {
        EDEventBus.postEvent(new DoLoginEvent(username, password));
    }
}
