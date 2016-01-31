package com.test.lipuhossain.livewallpaper;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;

public abstract class AquaticAnimal implements Renderable {

	private static int MAX_SPEED = 100;
	private Context _context;
	private Aquarium _aquarium;
	private FishSprite _leftSprite;
	private FishSprite _rightSprite;
	
	private int _direction = -1;
	private int _speedFraction;
	private long _previousTime;
	
	
	public AquaticAnimal(Context context, Aquarium aquarium){
		this._context = context;
		this._aquarium = aquarium;		
	}
	
	protected void initialize(Bitmap leftBitmap, Bitmap rightBitmap, int fps, int totalFrames, Point startPoint, int speed){
		this._leftSprite = new FishSprite(leftBitmap, fps, totalFrames, startPoint);
		this._rightSprite = new FishSprite(rightBitmap, fps, totalFrames, startPoint);		
		this._speedFraction = (MAX_SPEED / speed) * 10;
	}
	
	private FishSprite getSprite(){
		if(this._direction < 0){
			return this._leftSprite;
		}		
		return this._rightSprite;
	}
	
	public int getDirection(){
		FishSprite sprite = this.getSprite();
		int xPos = sprite.getXPos();
		if(this._direction < 0){
			xPos += sprite.getWidth();
		}
		if(xPos < this._aquarium.getLeft()){
			this._direction = 1;			
		}else if(xPos > this._aquarium.getRight()){
			this._direction = -1;
		}else{
			// Do nothing
		}
		
		return this._direction;
	}
	
	public Context getContext(){
		return this._context;
	}
	
	public Aquarium getAquarium(){
		return this._aquarium;
	}
	
	@Override
	public void render(Canvas canvas){
		long currentTime = System.currentTimeMillis();
		this.getSprite().render(canvas, currentTime);
		this.swim(currentTime+1000000);
	}
	
	public void swim(long currentTime){
		long diff = currentTime - this._previousTime;
		if(diff > this._speedFraction){
			int currentX = this.getSprite().getXPos();			
			this.getSprite().setXPos(currentX + this.getDirection());
			this._previousTime = currentTime;
		}		
	}

}
