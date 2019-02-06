package com.sadarol.spotytimer.Presentation.Activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.sadarol.spotytimer.Presentation.Adapter.AdapterTr;
import com.sadarol.spotytimer.Data.DatabaseHelper;
import com.sadarol.spotytimer.Presentation.Adapter.RecViewDbClick;
import com.sadarol.spotytimer.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TrTestActivity extends AppCompatActivity implements RecViewDbClick {
    private AdapterTr adapterTr;
    private RecyclerView recyclerView;
    private String TABLE = "training";
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.myThemeLight_NoBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tr_test_layout);
        getTr();
    }

    @Override
    public void recyclerViewListClicked(View v, int position, int id) {
        Intent intent = new Intent(this, TrainingActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }

    private void getTr() {
        recyclerView = (RecyclerView) findViewById(R.id.recycle_test);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        dbHelper = new DatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor c = db.query(TABLE, null, null, null, null, null, null);
        adapterTr = new AdapterTr(c, this, this);

        recyclerView.setAdapter(adapterTr);

    }
}
