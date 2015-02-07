package com.enrique.eventbusarchitecture.login;

import com.enrique.eventbusarchitecture.EDEventBus;
import com.enrique.eventbusarchitecture.base.BaseSubscriber;
import com.enrique.eventbusarchitecture.events.DoLoginEvent;
import com.enrique.eventbusarchitecture.events.ShowSecondFragment;

public class LoginSubscriber extends BaseSubscriber {

    public void onEvent(DoLoginEvent event) {
        /**
         * Here is where we should perform a HTTP request to check the login credentials. Let's
         * assume the login is right
         */
        EDEventBus.postEvent(new ShowSecondFragment());
    }
}