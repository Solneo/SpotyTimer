package com.sadarol.spotytimer;

import android.content.Context;

import com.sadarol.spotytimer.Data.DataCRUT;
import com.sadarol.spotytimer.Data.DatabaseHelper;

import androidx.test.InstrumentationRegistry;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.filters.SmallTest;
import androidx.test.internal.runner.InstrumentationConnection;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="С">Testing documentation</a>
 */

public class ExampleInstrumentedTest {
    private static final int TESTID = 543;

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = ApplicationProvider.getApplicationContext();
        assertEquals("com.sadarol.spotytimer", appContext.getPackageName());
    }

    @Test
    @SmallTest
    public void DD() throws Exception{
        Context appContext = ApplicationProvider.getApplicationContext();
        DatabaseHelper dbHelper = new DatabaseHelper(appContext);
        DataCRUT dataCRUT = new DataCRUT(dbHelper, appContext);
        dataCRUT.getCursorByID(TESTID);
    }
    @Test
    @SmallTest
    public void saveAndReadValues() throws Exception{
        Context appContext = ApplicationProvider.getApplicationContext();
        DatabaseHelper dbHelper = new DatabaseHelper(appContext);
        DataCRUT dataCRUT = new DataCRUT(dbHelper, appContext);
        dataCRUT.getCursorByID(TESTID);
    }
}
