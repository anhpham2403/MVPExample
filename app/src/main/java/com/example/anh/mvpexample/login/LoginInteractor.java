package com.example.anh.mvpexample.login;

import android.content.Context;

/**
 * Created by anh on 09/09/2017.
 */

public interface LoginInteractor {
    interface OnLoginFinishesListener {
        void onUserNameError();

        void onPasswordError();

        void onSuccess();
    }

    void Login(String username, String password, OnLoginFinishesListener listener, Context context);
}
