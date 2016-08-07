package br.com.luizgadao.testwithcanvas.utils;

import android.content.Context;
import android.content.res.Resources;

/**
 * Created by Luiz on 17/07/16.
 */

public class MetricsUtils {
    public static float dpToPixel(Context context, float dip){
        Resources resources = context.getResources();
        float density = resources.getDisplayMetrics().density;
        int px = (int) (dip * density + 0.5f);
        return px;
    }

    public static float pixelToDp(Context context, int px){
        float pxToOneDp = context.getResources().getDisplayMetrics().densityDpi / 160f;
        return px / pxToOneDp;
    }
}
