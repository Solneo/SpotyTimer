package com.sadarol.spotytimer.Adapters;

import android.database.Cursor;

public class ModelTr {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public static ModelTr fromCursor(Cursor cursor) {
        int nameColIndex = cursor.getColumnIndex("name");
        ModelTr modelTr = new ModelTr();
        modelTr.setName(cursor.getString(nameColIndex));
        return modelTr;
    }
}
