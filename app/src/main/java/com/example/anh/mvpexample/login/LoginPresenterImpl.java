package com.example.anh.mvpexample.login;

import android.content.Context;

/**
 * Created by anh on 09/09/2017.
 */

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFinishesListener {
    private LoginView loginView;
    private LoginInteractor loginInteractor;
    private Context context;

    public LoginPresenterImpl(LoginView loginView,Context context) {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();
        this.context = context;
    }

    @Override
    public void validateUser(String username, String password) {
        loginView.showProgress();
        loginInteractor.Login(username,password,this,context);
    }

    @Override
    public void onUserNameError() {
        loginView.hideProgress();
        loginView.setUserNameError();
    }

    @Override
    public void onPasswordError() {
        loginView.hideProgress();
        loginView.setPasswordError();
    }

    @Override
    public void onSuccess() {
        loginView.hideProgress();
        loginView.setLoginSuccess();
    }
}
