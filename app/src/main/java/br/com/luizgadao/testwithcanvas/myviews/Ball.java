package br.com.luizgadao.testwithcanvas.myviews;

import android.graphics.Paint;

import br.com.luizgadao.testwithcanvas.particles.GenericParticle;

/**
 * Created by Luiz on 05/08/16.
 */

public class Ball extends GenericParticle {

    float mAngleMove;
    float mRadius;
    float mRadiusMove;
    float mInitX;
    float mInitY;
    private double mRadians;

    public Ball(float speed, float angle, float radius, float radiusMove, float posX, float posY, Paint paint) {
        this.mSpeed = speed;
        this.mAngle = angle;
        this.mRadius = radius;
        this.mRadiusMove = radiusMove;
        this.mPosX = posX;
        this.mPosY = posY;
        this.mInitX = posX;
        this.mInitY = posY;
        this.mPaint = paint;
    }

    public Ball(float mAngleMove, float mRadius, float mRadiusMove, double mRadians) {
        this.mAngleMove = mAngleMove;
        this.mRadius = mRadius;
        this.mRadiusMove = mRadiusMove;
        this.mRadians = mRadians;
    }

    public void update(){
        mRadians = Math.toRadians(mAngleMove);
        this.mPosX = (float) (mInitX + mRadiusMove * Math.cos(mRadians));
        this.mPosY = (float) (mInitY + mRadiusMove * Math.sin(mRadians));

        mAngleMove += mSpeed;
        mAngleMove %= 360;
    }
}
