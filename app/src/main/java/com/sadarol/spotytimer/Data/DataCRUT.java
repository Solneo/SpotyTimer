package com.sadarol.spotytimer.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;

import java.util.HashMap;

public class DataCRUT {
    private DatabaseHelper dbHelper;
    Context context;
    private String TABLE = "training", NAME = "name", TIME = "time";

    public DataCRUT(DatabaseHelper dbHelper, Context context) {

        this.dbHelper = dbHelper;
        this.context = context;
    }

    public void dbRead() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor c = db.query(TABLE, null, null, null, null, null, null);
        if (c.moveToFirst()) {
            int idColIndex = c.getColumnIndex("id");
            int nameColIndex = c.getColumnIndex(NAME);
            int emailColIndex = c.getColumnIndex(TIME);

            do {
                // получаем значения по номерам столбцов и пишем все в лог
                Log.d("myinfo",
                        "ID = " + c.getInt(idColIndex) +
                                ", " + NAME + " = " + c.getString(nameColIndex) +
                                ", " + TIME + " = " + c.getString(emailColIndex));
                // переход на следующую строку
                // а если следующей нет (текущая - последняя), то false - выходим из цикла
            } while (c.moveToNext());
        } else
            Log.d("myinfo", "0 rows");
        c.close();
        dbHelper.close();
    }

    public long dbAdd(String table_name, ContentValues cv) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        long rowID = db.insert(table_name, null, cv);
        Log.d("myinfo", "row inserted, ID = " + rowID);
        dbHelper.close();
        return rowID;
    }

    public void dbClearTable(String Table) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        int clearCount = db.delete(Table, null, null);
        Log.d("myinfo", "deleted rows count = " + clearCount);
        dbHelper.close();
    }

    public Cursor getCursorByID(int id) {//Вынести в отдельный класс с логикой
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        return db.rawQuery("select * from " + "training" + " where " +
                "id" + " like ?", new String[]{"%" + id + "%"});
    }

    public void deleteRow(int id) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL("DELETE FROM "+TABLE+" WHERE id = "+ id);
    }
}
