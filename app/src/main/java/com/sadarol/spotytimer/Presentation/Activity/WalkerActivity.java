package com.sadarol.spotytimer.Presentation.Activity;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.hardware.*;
import android.widget.Toast;

import com.sadarol.spotytimer.R;

import androidx.appcompat.app.AppCompatActivity;

public class WalkerActivity extends AppCompatActivity implements SensorEventListener{
    boolean activityRunning;
    SensorManager sensorManager;
    TextView count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.myThemeLight_NoBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walking);
        count = (TextView) findViewById(R.id.walker_count);

         sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

    }
    @Override
    protected void onResume() {
        super.onResume();
        activityRunning = true;
        Sensor countSensor = sensorManager
                .getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if (countSensor != null) {
            sensorManager.registerListener(this, countSensor,
                    SensorManager.SENSOR_DELAY_UI);
        } else {
            Toast.makeText(this, "Count sensor not available!",
                    Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        activityRunning = false;
        // if you unregister the last listener, the hardware will stop detecting
        // step events
        // sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (activityRunning) {
            count.setText(String.valueOf(event.values[0]));
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}
