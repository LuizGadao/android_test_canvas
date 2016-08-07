package br.com.luizgadao.testwithcanvas.particles;

import android.graphics.Paint;

/**
 * Created by Luiz on 05/08/16.
 */

public abstract class GenericParticle implements Moveable {
    protected float mSpeed;
    protected float mAngle;
    protected float mPosX;
    protected float mPosY;
    protected Paint mPaint;

    public float getSpeed() {
        return mSpeed;
    }

    public void setSpeed(float mSpeed) {
        this.mSpeed = mSpeed;
    }

    public float getAngle() {
        return mAngle;
    }

    public void setAngle(float mAngle) {
        this.mAngle = mAngle;
    }

    public float getPosX() {
        return mPosX;
    }

    public void setPosX(float mPosX) {
        this.mPosX = mPosX;
    }

    public float getmPosY() {
        return mPosY;
    }

    public void setmPosY(float mPosY) {
        this.mPosY = mPosY;
    }

    public Paint getPaint() {
        return mPaint;
    }

    public void setPaint(Paint mPaint) {
        this.mPaint = mPaint;
    }
}
