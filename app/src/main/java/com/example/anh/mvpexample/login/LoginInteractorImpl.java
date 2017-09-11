package com.example.anh.mvpexample.login;


import android.content.Context;
import android.os.Handler;

import com.example.anh.testmvp.data.database.UserLocalDataSource;

/**
 * Created by anh on 09/09/2017.
 */

public class LoginInteractorImpl implements LoginInteractor {
    @Override
    public void Login(final String username, final String password, final OnLoginFinishesListener listener, final Context context) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean error = false;
                UserLocalDataSource source = UserLocalDataSource.getInstance(context);
                if (!source.checkUserName(username)) {
                    listener.onUserNameError();
                    error = true;
                    return;
                }
                if (!source.checkUser(username, password)) {
                    listener.onPasswordError();
                    error = true;
                    return;
                }
                if (!error) {
                    listener.onSuccess();

                }
            }
        }, 2000);
    }
}
