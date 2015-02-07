package com.enrique.eventbusarchitecture;

import android.app.Application;

public class EDApplication extends Application {
    private static EDApplication sInstance;
    private EDEventBusRegistry mRegistry;

    public static EDApplication getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        sInstance = this;
        super.onCreate();
        startEventProcessing();
    }

    private void startEventProcessing() {
        mRegistry = new EDEventBusRegistry(this);
        mRegistry.registerDefaultSubscribers();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        sInstance = null;
        mRegistry.unregisterAllSubscribers();
        mRegistry = null;
    }
}
