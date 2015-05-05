package com.aatu.sakrnie.aatutimer;

/**
 * Created by smjoke on 9.3.2015.
 */


public class Stopwatch {

    private long mStartTime;
    private long mCurrentTime;

    public Stopwatch() {
        mStartTime = 0;
        mCurrentTime = 0;
        
    }
    
    
    public void start() {
        mStartTime = System.nanoTime();
    }

    public void stop() {
        mCurrentTime = System.nanoTime() -mStartTime;
//        System.curren
    }

    public String getTime() {
//        Log.d("asdfhaos", Long.toString(mCurrentTime%1000000000));
        String milliseconds = Long.toString(mCurrentTime%1000000000);
        String seconds = Long.toString((mCurrentTime/1000000000)%60);
//        Log.i("STOPWATCH", seconds + ":" + milliseconds);
        return seconds +"." + milliseconds;
    }
}