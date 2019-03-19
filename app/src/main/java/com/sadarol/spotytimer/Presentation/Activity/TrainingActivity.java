package com.sadarol.spotytimer.Presentation.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.sadarol.spotytimer.Data.DataCRUT;
import com.sadarol.spotytimer.Data.DatabaseHelper;
import com.sadarol.spotytimer.R;

public class TrainingActivity extends AppCompatActivity {
    private DatabaseHelper dbHelper;
    private String DESCRIPTION = "time", NAME = "name";
    private TextView description, name;
    DataCRUT dataCRUT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.myThemeLight_NoBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);
        name = (TextView) findViewById(R.id.training_name);
        description = (TextView) findViewById(R.id.training_desk);
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        getDataById(id);
    }

    protected void getDataById(int id) {
//TODO Косяк
        dbHelper = new DatabaseHelper(this);
        dataCRUT = new DataCRUT(dbHelper, this);
        Cursor cur = dataCRUT.getCursorByID(id);
        int nameColIndex = cur.getColumnIndex(NAME);
        int emailColIndex = cur.getColumnIndex(DESCRIPTION);
        if (cur.moveToNext()) {
            name.setText(cur.getString(nameColIndex));
            description.setText(cur.getString(emailColIndex));
        } else {
            Log.d("myinfo", "0 rows");
        }
        cur.close();
        dbHelper.close();

    }


}
