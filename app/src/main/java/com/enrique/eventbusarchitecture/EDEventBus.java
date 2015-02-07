package com.enrique.eventbusarchitecture;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import de.greenrobot.event.EventBus;

public class EDEventBus extends EventBus {
    private static volatile EDEventBus defaultInstance;
    private final ScheduledExecutorService mExecutorService;

    private EDEventBus() {
        super();
        mExecutorService = Executors.newSingleThreadScheduledExecutor();
    }

    public ScheduledFuture<Object> postDelayed(Object event, long delay) {
        return mExecutorService.schedule(new PostEventCallable(this, event), delay, TimeUnit.MILLISECONDS);
    }

    private class PostEventCallable implements Callable<Object> {
        private final EDEventBus mEventBus;
        private final Object mEvent;

        public PostEventCallable(EDEventBus eventBus, Object event) {
            mEventBus = eventBus;
            mEvent = event;
        }

        @Override
        public Object call() throws Exception {
            mEventBus.post(mEvent);
            return null;
        }
    }

    public static EDEventBus getInstance() {
        if (defaultInstance == null) {
            synchronized (EDEventBus.class) {
                if (defaultInstance == null) {
                    defaultInstance = new EDEventBus();
                }
            }
        }
        return defaultInstance;
    }

    public static void postEvent(Object event) {
        getInstance().post(event);
    }

    public static void postStickyEvent(Object event) {
        getInstance().postSticky(event);
    }

    public static <T> T getSticky(Class<T> eventType) {
        return getInstance().getStickyEvent(eventType);
    }
}