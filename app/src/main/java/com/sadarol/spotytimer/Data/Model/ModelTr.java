package com.sadarol.spotytimer.Data.Model;

import android.database.Cursor;
import android.util.Log;

public class ModelTr {
    private String name;
    private String description;
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static ModelTr fromCursor(Cursor cursor) {
        ModelTr modelTr = new ModelTr();
        int nameColIndex = cursor.getColumnIndex("name");
        Log.i("ModelTr.fromCursor", Integer.toString(nameColIndex));
        modelTr.setName(cursor.getString(nameColIndex));
        nameColIndex = cursor.getColumnIndex("time");
        modelTr.setDescription(cursor.getString(nameColIndex));
        nameColIndex = cursor.getColumnIndex("id");
        modelTr.setId(cursor.getInt(nameColIndex));
        return modelTr;
    }
}
