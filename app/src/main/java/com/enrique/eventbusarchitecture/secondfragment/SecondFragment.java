package com.enrique.eventbusarchitecture.secondfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.enrique.eventbusarchitecture.R;

import butterknife.ButterKnife;

public class SecondFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_fragment, container, false);
        ButterKnife.inject(this, view);
        return view;
    }
}
