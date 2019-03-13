package com.sadarol.spotytimer.Presentation.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.sadarol.spotytimer.Domain.Notification.StartTrainingNotif;
import com.sadarol.spotytimer.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class NotificationSetting extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(R.style.myThemeLight_NoBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notyfication_setting);


        TextView textView = (TextView) findViewById(R.id.notif_name);

        Intent intent = getIntent();
        String notifName = intent.getStringExtra("notifName");
        textView.setText(notifName);
    }
    public void onClickStart(View v) { startService(new Intent(this, StartTrainingNotif.class));
    }


    public void onClickStop(View v) {
        stopService(new Intent(this, StartTrainingNotif.class));
    }
}
