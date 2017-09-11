package com.example.anh.mvpexample.data.database;

import android.provider.BaseColumns;

/**
 * Created by anh on 05/09/2017.
 */

public class UserUser {
    public UserUser() {
    }
    public static class USerEntry implements BaseColumns{
        public static final String TABLE_USERS = "user";
        public static final String ID = "id";
        public static final String USERNAME = "username";
        public static final String PASSWORD = "password";
    }
}
