package br.com.luizgadao.testwithcanvas.myviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import br.com.luizgadao.testwithcanvas.utils.MetricsUtils;

/**
 * Created by Luiz on 05/08/16.
 */

public class TwoBalls extends View {

    private Ball mRedBall;
    private Ball mBlueBall;
    private Paint mPaintYellow;

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
        mPaintYellow = new Paint();
        mPaintYellow.setColor(Color.YELLOW);

        Paint mBgRed = new Paint();
        mBgRed.setARGB(200, 255, 0, 0);

        Paint mBgBlue = new Paint();
        mBgRed.setARGB(130, 20, 40, 230);

        Context mContext = getContext();
        mRedBall = new Ball(10, 0,
                MetricsUtils.toPixel(mContext, 30),
                MetricsUtils.toPixel(mContext, 20),
                MetricsUtils.toPixel(mContext, 200),
                MetricsUtils.toPixel(mContext, 200),
                mBgRed
        );

        mBlueBall = new Ball(12, 180,
                MetricsUtils.toPixel(mContext, 20),
                MetricsUtils.toPixel(mContext, 24),
                MetricsUtils.toPixel(mContext, 180),
                MetricsUtils.toPixel(mContext, 150),
                mBgBlue
        );

        setFocusable(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(
                mRedBall.mPosX,
                mRedBall.mPosY,
                mRedBall.mRadius,
                mRedBall.mPaint
        );

        canvas.drawCircle(
                mBlueBall.mPosX,
                mBlueBall.mPosY,
                mBlueBall.mRadius,
                mBlueBall.mPaint
        );

        canvas.drawLine(mRedBall.mPosX, mRedBall.mPosY, mBlueBall.mPosX, mBlueBall.mPosY, mPaintYellow);
    }

    public void update(){
        mRedBall.update();
        mBlueBall.update();
        invalidate();
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
