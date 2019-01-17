package com.sadarol.spotytimer.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;

public class DataCRUT {
    private View v;
    private DatabaseHelper dbHelper;
    Context context;
    private String DATABASE = "",TABLE ="training", NAME ="name", TIME = "time";

    public DataCRUT(View v, DatabaseHelper dbHelper, Context context) {
        this.v = v;
        this.dbHelper = dbHelper;
        this.context = context;
    }

    public void dbRead() {
        ContentValues cv = new ContentValues();
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Log.d("myinfo", "--- Rows in mytable: ---");
        // делаем запрос всех данных из таблицы mytable, получаем Cursor
        Cursor c = db.query(TABLE, null, null, null, null, null, null);

        // ставим позицию курсора на первую строку выборки
        // если в выборке нет строк, вернется false
        if (c.moveToFirst()) {

            // определяем номера столбцов по имени в выборке
            int idColIndex = c.getColumnIndex("id");
            int nameColIndex = c.getColumnIndex(NAME);
            int emailColIndex = c.getColumnIndex(TIME);

            do {
                // получаем значения по номерам столбцов и пишем все в лог
                Log.d("myinfo",
                        "ID = " + c.getInt(idColIndex) +
                                ", " + NAME +" = " + c.getString(nameColIndex) +
                                ", " + TIME +" = " + c.getString(emailColIndex));
                // переход на следующую строку
                // а если следующей нет (текущая - последняя), то false - выходим из цикла
            } while (c.moveToNext());
        } else
            Log.d("myinfo", "0 rows");
        c.close();
        dbHelper.close();
    }

    public void dbAdd(String name, String time) {
        ContentValues cv = new ContentValues();
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Log.d("myinfo", "--- Insert in mytable: ---");
        // подготовим данные для вставки в виде пар: наименование столбца - значение
        cv.put(NAME, name);
        cv.put(TIME, time);
        // вставляем запись и получаем ее ID
        long rowID = db.insert(TABLE, null, cv);
        Log.d("myinfo", "row inserted, ID = " + rowID);
        dbHelper.close();
    }

    public void dbClear() {
        ContentValues cv = new ContentValues();
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Log.d("myinfo", "--- Clear mytable: ---");
        // удаляем все записи
        int clearCount = db.delete(TABLE, null, null);
        Log.d("myinfo", "deleted rows count = " + clearCount);
        dbHelper.close();
    }
}
