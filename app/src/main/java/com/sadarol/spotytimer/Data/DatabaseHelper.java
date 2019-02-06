package com.sadarol.spotytimer.Data;

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

        db.execSQL("create table TemplateExercise ("
                + "id integer primary key autoincrement,"
                + "name text,"
                + "time text" + ");");

        db.execSQL("create table Exercise ("
                + "id integer primary key autoincrement,"
                + "template_id integer,"
                + "time text,"
                + "training_id integer,"
                + " FOREIGN KEY(training_id) REFERENCES training(id),"
                + " FOREIGN KEY(template_id) REFERENCES TemplateExercise(id)"
                + ");");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /*db.execSQL("create table training ("
                + "id integer primary key autoincrement,"
                + "name text,"
                + "time text" + ");");
*/
        db.execSQL("create table TemplateExercise ("
                + "id integer primary key autoincrement,"
                + "name text,"
                + "time text" + ");");

        db.execSQL("create table Exercise ("
                + "id integer primary key autoincrement,"
                + "template_id integer,"
                + "time text,"
                + "training_id integer,"
                + " FOREIGN KEY(training_id) REFERENCES training(id),"
                + " FOREIGN KEY(template_id) REFERENCES TemplateExercise(id)"
                + ");");
    }
}
