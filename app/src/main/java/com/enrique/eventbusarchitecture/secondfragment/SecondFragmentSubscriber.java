package com.enrique.eventbusarchitecture.secondfragment;

import com.enrique.eventbusarchitecture.EDEventBus;
import com.enrique.eventbusarchitecture.base.BaseSubscriber;
import com.enrique.eventbusarchitecture.events.AttachFragmentEvent;
import com.enrique.eventbusarchitecture.events.ShowSecondFragment;

public class SecondFragmentSubscriber extends BaseSubscriber {

    public void onEvent(ShowSecondFragment event) {
        EDEventBus.postEvent(new AttachFragmentEvent(new SecondFragment()));
    }
}