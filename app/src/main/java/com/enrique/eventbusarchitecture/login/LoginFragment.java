package com.enrique.eventbusarchitecture.login;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.enrique.eventbusarchitecture.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class LoginFragment extends Fragment {

    @InjectView(R.id.editTextUsername)
    TextView editTextUsername;

    @InjectView(R.id.editTextPassword)
    TextView editTextPassword;

    @InjectView(R.id.buttonLogin)
    Button buttonLogin;

    private LoginPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment, container, false);
        ButterKnife.inject(this, view);
        init();
        return view;
    }

    @OnClick(R.id.buttonLogin)
    public void performLogin() {
        presenter.performLogin(editTextUsername.getText().toString(),editTextPassword.getText().toString());
    }

    private void init() {
        presenter = new LoginPresenter();
    }
}
