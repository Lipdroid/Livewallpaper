package com.test.lipuhossain.livewallpaper;

import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.Handler;
import android.service.wallpaper.WallpaperService;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by Lipu Hossain on 24/01/2016.
 */
public class GIFWallpaperService extends WallpaperService {
    @Override
    public Engine onCreateEngine() {
        return new AquariumWallpaperEngine();
    }


    class AquariumWallpaperEngine extends Engine {

        private Aquarium _aquarium;
        private float xOffset = 0;
        private float yOffset = 0;

        public AquariumWallpaperEngine() {
            Log.e("WALLPAPERSERVICE", "Constructor");
            this._aquarium = new Aquarium();
            this._aquarium.initialize(getBaseContext(), getSurfaceHolder());
        }

        @Override
        public void onVisibilityChanged(boolean visible) {
            Log.e("WALLPAPERSERVICE", "onVisibilityChanged");
            if (visible) {
                if (getSurfaceHolder().getSurface().isValid())
                    this._aquarium.render();
            }
        }

        @Override
        public void onSurfaceChanged(SurfaceHolder holder, int format,
                                     int width, int height) {
            Log.e("WALLPAPERSERVICE", "onSurfaceChanged");

            super.onSurfaceChanged(holder, format, width, height);
        }


        @Override
        public void onSurfaceCreated(SurfaceHolder holder) {
            Log.e("WALLPAPERSERVICE", "onSurfaceCreated");
            super.onSurfaceCreated(holder);
            this._aquarium.start();
        }

        @Override
        public void onSurfaceDestroyed(SurfaceHolder holder) {
            Log.e("WALLPAPERSERVICE", "onSurfaceDestroyed");
            super.onSurfaceDestroyed(holder);
            this._aquarium.stop();


        }

        @Override
        public void onTouchEvent(MotionEvent event) {
            super.onTouchEvent(event);
           // Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onOffsetsChanged(float xOffset, float yOffset, float xOffsetStep, float yOffsetStep, int xPixelOffset, int yPixelOffset) {
          //  super.onOffsetsChanged(xOffset, yOffset, xOffsetStep, yOffsetStep, xPixelOffset, yPixelOffset);
//            this.xOffset = xOffset;
//            this.yOffset = yOffset;
           // this._aquarium.start();

            Toast.makeText(getApplicationContext(), xOffsetStep+""+yOffsetStep, Toast.LENGTH_SHORT).show();
        }
    }


}
