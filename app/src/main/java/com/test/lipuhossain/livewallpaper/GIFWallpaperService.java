package com.test.lipuhossain.livewallpaper;

import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.Handler;
import android.service.wallpaper.WallpaperService;
import android.util.Log;
import android.view.SurfaceHolder;

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

        public AquariumWallpaperEngine() {
            this._aquarium = new Aquarium();
            this._aquarium.initialize(getBaseContext(), getSurfaceHolder());
        }

        @Override
        public void onVisibilityChanged(boolean visible) {
            if (visible) {
                if (getSurfaceHolder().getSurface().isValid())
                    this._aquarium.render();
            }
        }

        @Override
        public void onSurfaceChanged(SurfaceHolder holder, int format,
                                     int width, int height) {
            super.onSurfaceChanged(holder, format, width, height);
        }

        @Override
        public void onSurfaceCreated(SurfaceHolder holder) {
            super.onSurfaceCreated(holder);
            this._aquarium.start();
        }

        @Override
        public void onSurfaceDestroyed(SurfaceHolder holder) {
            super.onSurfaceDestroyed(holder);
            this._aquarium.stop();


        }
    }


}
