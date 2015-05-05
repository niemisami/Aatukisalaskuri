package com.aatu.sakrnie.aatutimer;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainFragment extends Fragment {

    private TextView mTime;
    private Button mTimeButton;
    private Stopwatch timer;
    private boolean mIsRunning;
    private Handler mHandler = new Handler();

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);


        mTime = (TextView) view.findViewById(R.id.timer);
        mTimeButton = (Button) view.findViewById(R.id.time_button);
        timer = new Stopwatch();

        mIsRunning = false;
        mTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mIsRunning) {
                    timer.stop();
                    mIsRunning = false;
                    mTime.setText(timer.getTime());
                    mTime.setVisibility(View.VISIBLE);
                    mTimeButton.setText("Nollaa");
                    mTimeButton.setBackgroundColor(Color.parseColor("#2196f3"));
                }
//                Starts timer
                else if (mTimeButton.getText().equals("Nollaa")) {
                    mTime.setVisibility(View.INVISIBLE);
                    mTimeButton.setText("Aloita!");
                    Log.i("Nollaus", timer.getTime());
                    mTimeButton.setBackgroundColor(Color.parseColor("#00c853"));

                } else {
                    timer.start();
                    mIsRunning = true;
                    Log.i("start", timer.getTime());
                    mTimeButton.setText("Käynnissä!");
                    mTimeButton.setBackgroundColor(Color.parseColor("#FF1744"));
                }

            }
        });
        return view;
    }
}

