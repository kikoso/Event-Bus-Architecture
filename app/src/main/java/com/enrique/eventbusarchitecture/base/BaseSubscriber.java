package com.enrique.eventbusarchitecture.base;

import com.enrique.eventbusarchitecture.EDEventBus;

import de.greenrobot.event.EventBus;

public abstract class BaseSubscriber implements BaseEventBusRegistry.EventBusSubscriber {

        private EDEventBus mEventBus;

        @Override
        public final Object register(EDEventBus eventBus) {
            mEventBus = eventBus;
            mEventBus.register(this);
            return this;
        }

        public final void unregister(EDEventBus eventBus) {
            eventBus.unregister(this);
            mEventBus = null;
        }

        protected void post(Object event) {
            if (mEventBus == null) {
                throw new NullPointerException("PluginController.register() was not called. Is the controller registered in the EventBusRegistry?");
            }
            mEventBus.post(event);
        }

        protected void postSticky(Object event) {
            if (mEventBus == null) {
                throw new NullPointerException("PluginController.register() was not called. Is the controller registered in the EventBusRegistry?");
            }
            mEventBus.postSticky(event);
        }

        protected <T> T removeStickyEvent(Class<T> eventType) {
            if (mEventBus == null) {
                throw new NullPointerException("PluginController.register() was not called. Is the controller registered in the EventBusRegistry?");
            }
            return mEventBus.removeStickyEvent(eventType);
        }

        protected boolean removeStickyEvent(Object event) {
            if (mEventBus == null) {
                throw new NullPointerException("PluginController.register() was not called. Is the controller registered in the EventBusRegistry?");
            }
            return mEventBus.removeStickyEvent(event);
        }

        protected <T> T getStickyEvent(Class<T> eventType) {
            if (mEventBus == null) {
                throw new NullPointerException("PluginController.register() was not called. Is the controller registered in the EventBusRegistry?");
            }
            return mEventBus.getStickyEvent(eventType);
        }
  }