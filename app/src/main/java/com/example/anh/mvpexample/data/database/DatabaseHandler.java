package com.example.anh.mvpexample.data.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by anh on 04/09/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "test";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE " + UserUser.USerEntry.TABLE_USERS + " (" + UserUser.USerEntry.ID
                + " INTEGER PRIMARY KEY," + UserUser.USerEntry.USERNAME + " TEXT," + UserUser.USerEntry.PASSWORD
                + " TEXT" + " )";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + UserUser.USerEntry.TABLE_USERS);
        onCreate(sqLiteDatabase);
    }

}
