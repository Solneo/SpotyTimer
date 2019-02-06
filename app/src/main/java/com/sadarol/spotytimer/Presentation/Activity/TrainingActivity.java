package com.sadarol.spotytimer.Presentation.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.sadarol.spotytimer.Data.DatabaseHelper;
import com.sadarol.spotytimer.R;

public class TrainingActivity extends AppCompatActivity {
private DatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);
        Intent intent = getIntent();
        int id = intent.getIntExtra("id",0);
        getData(id);
    }

    protected void getData(int id){
        dbHelper = new DatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor c = db.query("training", null, null, null, null, null, null);

    }
}
