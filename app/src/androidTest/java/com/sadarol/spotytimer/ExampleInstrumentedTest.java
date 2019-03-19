package com.sadarol.spotytimer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.sadarol.spotytimer.Data.DataCRUT;
import com.sadarol.spotytimer.Data.DatabaseHelper;

import androidx.test.InstrumentationRegistry;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.filters.SmallTest;
import androidx.test.internal.runner.InstrumentationConnection;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static java.lang.Math.toIntExact;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="С">Testing documentation</a>
 */

public class ExampleInstrumentedTest {
    private static final int TESTID = 543;
    private static final String dataForTest = "Test";

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = ApplicationProvider.getApplicationContext();
        assertEquals("com.sadarol.spotytimer", appContext.getPackageName());
    }

    @Test
    @SmallTest
    public void DD() throws Exception {
        Context appContext = ApplicationProvider.getApplicationContext();
        DatabaseHelper dbHelper = new DatabaseHelper(appContext);
        DataCRUT dataCRUT = new DataCRUT(dbHelper, appContext);
        dataCRUT.getCursorByID(TESTID);
    }

    @Test
    public void saveAndReadValues() throws Exception {
        Context appContext = ApplicationProvider.getApplicationContext();
        DatabaseHelper dbHelper = new DatabaseHelper(appContext);
        DataCRUT dataCRUT = new DataCRUT(dbHelper, appContext);
        ContentValues cv = new ContentValues();
        cv.put("name", dataForTest);
        long rowId = dataCRUT.dbAdd("training", cv);
        Cursor c = dataCRUT.getCursorByID(toIntExact(rowId));
        c.moveToNext();
        int ColInd = c.getColumnIndex("name");
        assertEquals(dataForTest, c.getString(ColInd));
        assertNotEquals(dataForTest, "wdfghntjywet");
    }
}
