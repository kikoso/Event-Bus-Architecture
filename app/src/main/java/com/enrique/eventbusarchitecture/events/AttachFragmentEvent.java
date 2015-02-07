package com.enrique.eventbusarchitecture.events;

import android.app.Fragment;

import lombok.Data;

@Data
public class AttachFragmentEvent {
    private Class<? extends android.app.Fragment> fragmentClass;

    private Fragment fragment;

    public AttachFragmentEvent(Class<? extends android.app.Fragment> fragmentClass) {
        this.fragmentClass = fragmentClass;
    }

    public AttachFragmentEvent(Fragment fragment) {
        this.fragment = fragment;
    }
}