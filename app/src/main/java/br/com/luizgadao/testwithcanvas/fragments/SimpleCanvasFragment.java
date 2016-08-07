package br.com.luizgadao.testwithcanvas.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Timer;
import java.util.TimerTask;

import br.com.luizgadao.testwithcanvas.R;
import br.com.luizgadao.testwithcanvas.myviews.ConnectBalls;

/**
 * A simple {@link Fragment} subclass.
 */
public class SimpleCanvasFragment extends Fragment {


    ConnectBalls mTwoBallsView;

    public SimpleCanvasFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance(){
        return new SimpleCanvasFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_simple_canvas, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mTwoBallsView = (ConnectBalls) view.findViewById(R.id.twoBalls);

        TimerTask mTimerTask = new TimerTask() {
            @Override
            public void run() {

                mTwoBallsView.post(new Runnable() {
                    @Override
                    public void run() {
                        mTwoBallsView.update();
                    }
                });
            }
        };

        Timer mTimer = new Timer();
        int frame = 30;
        long framePerSecond = 1000 / frame;
        mTimer.schedule(mTimerTask, 1 * 1000, framePerSecond);
    }
}
