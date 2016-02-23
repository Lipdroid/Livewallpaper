/**
 *
 */
package com.test.lipuhossain.livewallpaper;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;

/**
 * @author rajeesh
 */
public class FishSprite {

    /**
     * Private fields
     */
    private Bitmap _currentSpriteBitmap;
    private Rect _drawRect;
    private int _fps;
    private int _noOfFrames;
    private int _currentFrame;
    private long _timer;
    private int _spriteWidth;
    private int _spriteHeight;
    private Point _position;

    public FishSprite(Bitmap spriteBitmap, int fps, int frameCount, Point startPoint) {

        this.initialize();

        this._position = startPoint;
        this._currentSpriteBitmap = spriteBitmap;
        this._spriteHeight = spriteBitmap.getHeight();
        this._spriteWidth = spriteBitmap.getWidth() / frameCount;
        this._drawRect = new Rect(0, 0, this._spriteWidth, this._spriteHeight);
        this._fps = 1000 / fps;
        this._noOfFrames = frameCount;
    }

    private void initialize() {
        this._drawRect = new Rect(0, 0, 0, 0);
        this._timer = 0;
        this._currentFrame = 0;
    }

    private void Update(long currentTime) {
        if (currentTime > this._timer + this._fps) {
            this._timer = currentTime;
            this._currentFrame += 1;

            if (this._currentFrame >= this._noOfFrames) {
                this._currentFrame = 0;
            }
        }

        this._drawRect.left = this._currentFrame * this._spriteWidth;
        this._drawRect.right = this._drawRect.left + this._spriteWidth;
    }

    public void render(Canvas canvas, long currentTime) {

        this.Update(currentTime);

        Rect dest = new Rect(getXPos(), getYPos(), getXPos() + this._spriteWidth,
                getYPos() + this._spriteHeight);

        canvas.drawBitmap(this._currentSpriteBitmap, this._drawRect, dest, null);
    }

    public Point getPosition() {
        return _position;
    }

    public void setPosition(Point position) {
        this._position = position;
    }

    public int getYPos() {
        return this._position.y;
    }

    public int getXPos() {
        return this._position.x;
    }

    public void setYPos(int y) {
        this._position.y = y;
    }

    public void setXPos(int x) {
        this._position.x = x;
    }

    public int getWidth() {
        return this._spriteWidth;
    }

    public int getHeight() {
        return this._spriteHeight;
    }

}
