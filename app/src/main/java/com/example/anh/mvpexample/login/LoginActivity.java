package com.example.anh.mvpexample.login;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.anh.testmvp.R;

/**
 * Created by anh on 09/09/2017.
 */

public class LoginActivity extends Activity implements LoginView, View.OnClickListener{
    private ProgressBar progressBar;
    private EditText username;
    private EditText password;
    private Button login;
    private LoginPresenter presenter;
    private final static String PASSWORD_ERROR = "password error";
    private final static String USERNAME_ERROR = "username error";
    private final static String LOGIN_SUCCESS = "login success";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = findViewById(R.id.button);
        login.setOnClickListener(this);
        presenter = new LoginPresenterImpl(this,this);
    }

    @Override
    public void onClick(View view) {
        presenter.validateUser(username.getText().toString().trim(),password.getText().toString().trim());
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUserNameError() {
        Toast.makeText(this,USERNAME_ERROR,Toast.LENGTH_LONG).show();
    }

    @Override
    public void setPasswordError() {
        Toast.makeText(this,PASSWORD_ERROR,Toast.LENGTH_LONG).show();
    }

    @Override
    public void setLoginSuccess() {
        Toast.makeText(this,LOGIN_SUCCESS,Toast.LENGTH_LONG).show();
    }
}
