package com.test.lipuhossain.livewallpaper;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Lipu Hossain on 24/01/2016.
 */
public class Prefs extends PreferenceActivity
        implements  SharedPreferences.OnSharedPreferenceChangeListener {

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        Log.w("Prefs", "prefs onCreate");
        setContentView(R.layout.button);
        addPreferencesFromResource(R.xml.settings);
//        getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Your event
                Toast.makeText(Prefs.this, "Developed by Md. Munir Hossain", Toast.LENGTH_LONG).show();
            }
        });
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Your event
                Toast.makeText(Prefs.this,"NOt available now",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onDestroy()
    {
        getPreferenceManager().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        super.onDestroy();
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key)
    {
        if(key.equals("timer_key")){

        }
    }
}
