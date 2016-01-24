package com.test.lipuhossain.livewallpaper;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

    private static final  int REQUEST_SET_LIVE_WALLPAPER = 1;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_SET_LIVE_WALLPAPER){
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent;

// try the new Jelly Bean direct android wallpaper chooser first
        try {
            ComponentName component = new ComponentName(getPackageName(), getPackageName() + ".GIFWallpaperService");
            intent = new Intent(WallpaperManager.ACTION_CHANGE_LIVE_WALLPAPER);
            intent.putExtra(WallpaperManager.EXTRA_LIVE_WALLPAPER_COMPONENT, component);
            startActivityForResult(intent, REQUEST_SET_LIVE_WALLPAPER);
        }
        catch (android.content.ActivityNotFoundException e3) {
            // try the generic android wallpaper chooser next
            try {
                intent = new Intent(WallpaperManager.ACTION_LIVE_WALLPAPER_CHOOSER);
                startActivityForResult(intent, REQUEST_SET_LIVE_WALLPAPER);
            }
            catch (android.content.ActivityNotFoundException e2) {
                // that failed, let's try the nook intent
                try {
                    intent = new Intent();
                    intent.setAction("com.bn.nook.CHANGE_WALLPAPER");
                    startActivity(intent);
                }
                catch (android.content.ActivityNotFoundException e) {
                    // everything failed, let's notify the user
                    //showDialog(DIALOG_NO_WALLPAPER_PICKER);
                    Log.e("Error:" , "DIALOG_NO_WALLPAPER_PICKER");
                }
            }
        }
    }
}
