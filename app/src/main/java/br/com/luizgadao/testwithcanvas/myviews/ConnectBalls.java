package br.com.luizgadao.testwithcanvas.myviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

import br.com.luizgadao.testwithcanvas.particles.Moveable;
import br.com.luizgadao.testwithcanvas.utils.MetricsUtils;

/**
 * Created by Luiz on 05/08/16.
 */

public class ConnectBalls extends View implements Moveable{

    int maxBall = 100;
    private Ball[] mBalls = new Ball[maxBall];
    private float height;
    private float width;

    public ConnectBalls(Context context) {
        super(context);
    }

    public ConnectBalls(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private void init() {
        setBackgroundColor(Color.LTGRAY);
        Context mContext = getContext();

        for (int i = 0; i < mBalls.length; i++) {
            Ball mBall = new Ball(getRandom(3, 18), 0,
                    MetricsUtils.dpToPixel(mContext, getRandom(10, 35)),
                    MetricsUtils.dpToPixel(mContext, getRandom(4, 155)),
                    MetricsUtils.dpToPixel(mContext, getRandom(40, width)),
                    MetricsUtils.dpToPixel(mContext, getRandom(40, height)),
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
            float mCurrentBallX = mBalls[i].getPosX();
            float mCurrentBallY = mBalls[i].getmPosY();
            canvas.drawCircle(
                    mCurrentBallX,
                    mCurrentBallY,
                    mBalls[i].mRadius,
                    mBalls[i].getPaint()
            );

            if (i < lastButOne) {
                int next = i + 1;
                canvas.drawLine(
                        mCurrentBallX,
                        mCurrentBallY,
                        mBalls[next].getPosX(),
                        mBalls[next].getmPosY(),
                        mBalls[i].getPaint()
                );
            }
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int h = getMeasuredHeight();
        int w = getMeasuredWidth();
        setMeasuredDimension(w, h);
        width = MetricsUtils.pixelToDp(getContext(), w);
        height = MetricsUtils.pixelToDp(getContext(), h);
        init();
    }

    @Override
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
}
