
package com.test.lipuhossain.livewallpaper;

import android.view.SurfaceHolder;

public class AquariumThread extends Thread {

	private Aquarium _aquarium;
	private boolean _running;
	private SurfaceHolder _surfaceHolder;

	public AquariumThread(Aquarium aquarium,SurfaceHolder surfaceHolder) {
		this._aquarium = aquarium;
		this._surfaceHolder = surfaceHolder;
	}
	
	public void switchOn(){
		this._running = true;
		this.start();
	}
	
	public void pause(){
		this._running = false;
		synchronized(this){
			this.notify();
		}
	}
	
	public void switchOff(){
		this._running = false;
		synchronized(this){
			this.notify();
		}
	}
	
	@Override
	public void run() {
		while(this._running){
			if(!this._surfaceHolder.getSurface().isValid()){
				continue;
			}
			this._aquarium.render();
		}
	}
}
