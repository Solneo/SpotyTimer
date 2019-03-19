package com.sadarol.spotytimer.Presentation.Activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.sadarol.spotytimer.Data.DataCRUT;
import com.sadarol.spotytimer.Presentation.Adapter.AdapterTr;
import com.sadarol.spotytimer.Data.DatabaseHelper;
import com.sadarol.spotytimer.Presentation.Adapter.RecViewDbClick;
import com.sadarol.spotytimer.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TrTestActivity extends AppCompatActivity implements RecViewDbClick {
    private AdapterTr adapterTr;
    private RecyclerView recyclerView;
    private String TABLE = "training";
    private DatabaseHelper dbHelper;
    private Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.myThemeLight_NoBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tr_test_layout);
        getTr();
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

    @Override
    public void recyclerViewListClicked(View v, int position, int id) {
        Intent intent = new Intent(this, TrainingActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }

    @Override
    public void deleteButtonClicked(int position, int id) {
        DataCRUT dataCRUT = new DataCRUT(dbHelper, this);
        dataCRUT.deleteRow(id);
        updateAdapter(position);
    }

    private void getTr() {
        recyclerView = (RecyclerView) findViewById(R.id.recycle_test);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        dbHelper = new DatabaseHelper(this);
        cursorCreate();
        adapterTr = new AdapterTr(c, this, this);
        recyclerView.setAdapter(adapterTr);

    }

    public void updateAdapter(int position) {
        adapterTr.changeCursor(cursorCreate());
        recyclerView.removeViewAt(position);
        adapterTr.notifyItemRemoved(position);
        adapterTr.notifyItemRangeChanged(position, c.getCount());
        recyclerView.invalidate();
        adapterTr.notifyDataSetChanged();

    }

    private Cursor cursorCreate() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        c = db.query(TABLE, null, null, null, null, null, null);
        return c;
    }

    @Override
    protected void onDestroy() {
        c.close();
        dbHelper.close();
        super.onDestroy();
    }
}
