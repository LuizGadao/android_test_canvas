package br.com.luizgadao.testwithcanvas.myviews;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import br.com.luizgadao.testwithcanvas.utils.MetricsUtils;

/**
 * Created by Luiz on 17/07/16.
 */

public class FirstView extends View{

    private static final String TAG = FirstView.class.getSimpleName();

    Paint redPaint;
    Paint blackPaint;
    Paint bluePaint;
    private float mX = 10;
    private float mY = 10;

    public FirstView(Context context) {
        super(context);
        init();
    }

    public FirstView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void init(){
        setBackgroundColor(Color.LTGRAY);
        redPaint = new Paint();
        redPaint.setARGB(255, 255, 0, 0);

        blackPaint = new Paint();
        blackPaint.setARGB(255, 0, 0, 0);

        bluePaint = new Paint();
        bluePaint.setARGB(255, 0, 0, 255);

        setFocusable(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Context context = getContext();
        canvas.drawRect(
                MetricsUtils.dpToPixel(context, mX),
                MetricsUtils.dpToPixel(context, mY),
                MetricsUtils.dpToPixel(context, 100),
                MetricsUtils.dpToPixel(context, 100),
                bluePaint);
        canvas.drawLine(MetricsUtils.dpToPixel(context, 100), MetricsUtils.dpToPixel(context, 100), MetricsUtils.dpToPixel(context, 200), MetricsUtils.dpToPixel(context, 200), blackPaint);
        canvas.drawCircle(MetricsUtils.dpToPixel(context, 200), MetricsUtils.dpToPixel(context, 200), MetricsUtils.dpToPixel(context, 50), redPaint);
    }
}