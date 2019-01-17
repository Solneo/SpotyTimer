package com.sadarol.spotytimer.Data.Model;

import android.database.Cursor;
import android.util.Log;

public class ModelTr {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public static ModelTr fromCursor(Cursor cursor) {
        ModelTr modelTr = new ModelTr();
        int nameColIndex = cursor.getColumnIndex("name");
        Log.i("ModelTr.fromCursor",Integer.toString(nameColIndex));
        modelTr.setName(cursor.getString(nameColIndex));
        return modelTr;
    }
}
