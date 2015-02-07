package com.enrique.eventbusarchitecture;

import android.os.Bundle;

import com.enrique.eventbusarchitecture.base.BaseEventReportingActivity;
import com.enrique.eventbusarchitecture.events.AttachFragmentEvent;
import com.enrique.eventbusarchitecture.login.LoginFragment;

public class MainActivity extends BaseEventReportingActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        EDEventBusRegistry.getInstance().registerSubscriber(this);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction().add(R.id.container, new LoginFragment()).commit();
        }
    }

    @Override
    protected void onDestroy() {
        EDEventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    public void onEvent(AttachFragmentEvent event) throws IllegalAccessException, InstantiationException {
        getFragmentManager().beginTransaction().replace(R.id.container, event.getFragment()).addToBackStack(null).commit();
    }
}