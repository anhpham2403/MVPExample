package com.example.anh.mvpexample.data.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by anh on 09/09/2017.
 */

public class UserLocalDataSource extends DatabaseHandler {
    private static UserLocalDataSource dataSource;

    public UserLocalDataSource(Context context) {
        super(context);
    }

    public static UserLocalDataSource getInstance(Context context) {
        if (dataSource == null) {
            dataSource = new UserLocalDataSource(context);
        }
        return dataSource;
    }

    public boolean checkUser(String username, String password) {
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM " + UserUser.USerEntry.TABLE_USERS +
                " WHERE " + UserUser.USerEntry.USERNAME + " =? " + " AND " + UserUser.USerEntry.PASSWORD + " =?";
        Cursor cursor = db.rawQuery(sql, new String[]{username, password});
        if (cursor.getCount()==0){
            return false;
        }
        return true;
    }

    public boolean checkUserName(String username) {
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM " + UserUser.USerEntry.TABLE_USERS +
                " WHERE " + UserUser.USerEntry.USERNAME + " =? ";
        Cursor cursor = db.rawQuery(sql, new String[]{username});
        if (cursor.getCount()==0){
            return false;
        }
        return true;
    }
}