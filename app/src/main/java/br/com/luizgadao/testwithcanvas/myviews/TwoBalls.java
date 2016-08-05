package br.com.luizgadao.testwithcanvas.myviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

import br.com.luizgadao.testwithcanvas.utils.MetricsUtils;

/**
 * Created by Luiz on 05/08/16.
 */

public class TwoBalls extends View {

    int maxBall = 70;
    private Ball[] mBalls = new Ball[maxBall];

    public TwoBalls(Context context) {
        super(context);
        init();
    }

    public TwoBalls(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setBackgroundColor(Color.LTGRAY);
        Context mContext = getContext();

        for (int i = 0; i < mBalls.length; i++) {
            Ball mBall = new Ball(getRandom(3, 18), 0,
                    MetricsUtils.toPixel(mContext, getRandom(10, 35)),
                    MetricsUtils.toPixel(mContext, getRandom(4, 22)),
                    MetricsUtils.toPixel(mContext, getRandom(40, 430)),
                    MetricsUtils.toPixel(mContext, getRandom(40, 230)),
                    getRandomColor()
            );

            mBalls[i] = mBall;
        }

        setFocusable(true);
    }

    private float getRandom(float minValue, float maxValue){
        Random random = new Random();
        return (float) (random.nextDouble() * (maxValue -  minValue)) + minValue;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int len = mBalls.length;
        int lastButOne = mBalls.length -1;
        for (int i = 0; i < len; i++){
            float mCurrentBallX = mBalls[i].mPosX;
            float mCurrentBallY = mBalls[i].mPosY;
            canvas.drawCircle(
                    mCurrentBallX,
                    mCurrentBallY,
                    mBalls[i].mRadius,
                    mBalls[i].mPaint
            );

            if (i < lastButOne) {
                int next = i + 1;
                canvas.drawLine(
                        mCurrentBallX,
                        mCurrentBallY,
                        mBalls[next].mPosX,
                        mBalls[next].mPosY,
                        mBalls[i].mPaint
                );
            }
        }
    }

    public void update(){
        int len = mBalls.length;
        for (int i = 0; i < len; i++)
            mBalls[i].update();

        invalidate();
    }

    public Paint getRandomColor() {
        Paint mPaint = new Paint();
        mPaint.setARGB(255,
                (int) getRandom(0, 255),
                (int) getRandom(0, 255),
                (int) getRandom(0, 255)
        );
        return mPaint;
    }

    class Ball implements Moveable{
        float mSpeed;
        float mAngle;
        float mAngleMove;
        float mRadius;
        float mRadiusMove;
        float mPosX;
        float mPosY;
        Paint mPaint;
        private double mRadians;

        public Ball(float speed, float angle, float radius, float radiusMove, float posX, float posY, Paint paint) {
            this.mSpeed = speed;
            this.mAngle = angle;
            this.mRadius = radius;
            this.mRadiusMove = radiusMove;
            this.mPosX = posX;
            this.mPosY = posY;
            this.mPaint = paint;
        }

        public void update(){
            mRadians = Math.toRadians(mAngleMove);
            this.mPosX = (float) (mPosX + mRadiusMove * Math.cos(mRadians));
            this.mPosY = (float) (mPosY + mRadiusMove * Math.sin(mRadians));

            mAngleMove += mSpeed;
            mAngleMove %= 360;
        }
    }

    interface Moveable{
        void update();
    }
}
