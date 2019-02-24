package com.sadarol.spotytimer.Presentation.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.widget.TextView;

import com.sadarol.spotytimer.R;

import androidx.annotation.Nullable;

public class MainSetting extends PreferenceActivity {
        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            setTheme(R.style.myThemeLight_NoBar);
            super.onCreate(savedInstanceState);
            /* setContentView(R.layout.activity_notyfication_setting);*/
            addPreferencesFromResource(R.layout.setting_res);

            TextView textView = (TextView) findViewById(R.id.notif_name);

            Intent intent = getIntent();
            String notifName = intent.getStringExtra("notifName");
            /* textView.setText(notifName);*/
        }
}
