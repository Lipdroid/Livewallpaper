package com.test.lipuhossain.livewallpaper.fishes;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;

import com.test.lipuhossain.livewallpaper.Aquarium;
import com.test.lipuhossain.livewallpaper.AquaticAnimal;

public class ClownFish extends AquaticAnimal {
	private static final int TOTAL_FRAMES_IN_SPRITE = 20;
	private static final int CLOWN_FISH_FPS = 20; 
	
		
	public ClownFish(Context context, Aquarium aquarium, Point startPoint, int speed){
		super(context, aquarium);
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inPurgeable = true;
		Bitmap leftBitmap = BitmapFactory.decodeResource(getContext().getResources(), com.test.lipuhossain.livewallpaper.R.drawable.left, options);
		BitmapFactory.Options options1 = new BitmapFactory.Options();
		options1.inPurgeable = true;
		Bitmap rightBitmap = BitmapFactory.decodeResource(getContext().getResources(), com.test.lipuhossain.livewallpaper.R.drawable.right, options1);
		this.initialize(leftBitmap, rightBitmap, CLOWN_FISH_FPS, TOTAL_FRAMES_IN_SPRITE, startPoint, speed);
	}
	
	public void render(Canvas canvas){
		super.render(canvas);	
	}
}
