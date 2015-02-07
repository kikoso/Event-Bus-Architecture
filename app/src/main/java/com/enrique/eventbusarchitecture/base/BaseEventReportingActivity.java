package com.enrique.eventbusarchitecture.base;

import android.app.Activity;

import com.enrique.eventbusarchitecture.EDEventBus;
import com.enrique.eventbusarchitecture.EDEventBusRegistry;

public class BaseEventReportingActivity extends Activity implements EDEventBusRegistry.EventBusSubscriber {

    @Override
    public Object register(EDEventBus eventBus) {
        eventBus.registerSticky(this);
        return this;
    }

    @Override
    public void unregister(EDEventBus eventBus) {
        eventBus.unregister(this);
    }

}
