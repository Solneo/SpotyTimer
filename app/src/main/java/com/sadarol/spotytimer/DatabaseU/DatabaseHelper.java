package com.sadarol.spotytimer.DatabaseU;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        // конструктор суперкласса
        super(context, "myDBB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("myinfo", "--- onCreate database ---");
        // создаем таблицу с полями
        db.execSQL("create table training ("
                + "id integer primary key autoincrement,"
                + "name text,"
                + "time text" + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
