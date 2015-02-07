package com.enrique.eventbusarchitecture;

import android.content.Context;

import com.enrique.eventbusarchitecture.base.BaseEventBusRegistry;
import com.enrique.eventbusarchitecture.login.LoginSubscriber;
import com.enrique.eventbusarchitecture.secondfragment.SecondFragmentSubscriber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EDEventBusRegistry extends BaseEventBusRegistry {

    protected EDEventBusRegistry(Context applicationContext) {
        super(applicationContext);
    }

    @Override
    protected List<EventBusSubscriber> createDefaultSubscribers() {
        List<EventBusSubscriber> subscribers = new ArrayList<>();
        subscribers.addAll(Arrays.asList(
                new LoginSubscriber(),
                new SecondFragmentSubscriber()
        ));
        return subscribers;
    }
}