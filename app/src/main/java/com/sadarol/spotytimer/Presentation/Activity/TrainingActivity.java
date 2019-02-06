package com.sadarol.spotytimer.Presentation.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import com.sadarol.spotytimer.Data.DatabaseHelper;
import com.sadarol.spotytimer.R;

public class TrainingActivity extends AppCompatActivity {
    private DatabaseHelper dbHelper;
    private String TIME = "time", NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        getData(id);
    }

    protected void getData(int id) {
        dbHelper = new DatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor c = db.query("training", null, null, null, null, null, null);
        Cursor cur = gdt(db, id);
        int idColIndex = cur.getColumnIndex("id");
        int nameColIndex = cur.getColumnIndex(NAME);
        int emailColIndex = cur.getColumnIndex(TIME);
        if (cur.moveToNext()) {
            Log.d("myinfo",
                    "ID = " + cur.getInt(idColIndex) +
                            ", " + NAME + " = " + cur.getString(nameColIndex) +
                            ", " + TIME + " = " + cur.getString(emailColIndex));
        } else {
            Log.d("myinfo", "0 rows");
        }
       /* if (c.moveToPosition(c.getColumnIndex("id"))) {
            // определяем номера столбцов по имени в выборке
            int idColIndex = c.getColumnIndex("id");
            int nameColIndex = c.getColumnIndex(NAME);
            int emailColIndex = c.getColumnIndex(TIME);

            Log.d("myinfo",
                    "ID = " + c.getInt(idColIndex) +
                            ", " + NAME +" = " + c.getString(nameColIndex) +
                            ", " + TIME +" = " + c.getString(emailColIndex));
*//*
            do {
                // получаем значения по номерам столбцов и пишем все в лог
                Log.d("myinfo",
                        "ID = " + c.getInt(idColIndex) +
                                ", " + NAME +" = " + c.getString(nameColIndex) +
                                ", " + TIME +" = " + c.getString(emailColIndex));
                // переход на следующую строку
                // а если следующей нет (текущая - последняя), то false - выходим из цикла
            } while (c.moveToNext());*//*
        } else
            Log.d("myinfo", "0 rows");*/
        c.close();
        cur.close();
        dbHelper.close();

    }

    private Cursor gdt(SQLiteDatabase db, int id) {
        return db.rawQuery("select * from " + "training" + " where " +
                "id" + " like ?", new String[]{"%" + id + "%"});
    }
}
