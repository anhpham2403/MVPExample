package com.example.anh.mvpexample.login;

/**
 * Created by anh on 09/09/2017.
 */

public interface LoginView {
    void showProgress();

    void hideProgress();

    void setUserNameError();

    void setPasswordError();

    void setLoginSuccess();
}
