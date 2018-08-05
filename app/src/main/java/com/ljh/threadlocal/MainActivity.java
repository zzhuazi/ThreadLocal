package com.ljh.threadlocal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private ThreadLocal<Boolean> mBooleanThreadLocal = new ThreadLocal<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBooleanThreadLocal.set(true);
        Log.d(TAG, "[Main]mBooleanThreadLocal=" + mBooleanThreadLocal.get());

        new Thread("Thread#1"){
            public void run(){
                mBooleanThreadLocal.set(false);
                Log.d(TAG, "[1]mBooleanThreadLocal=" + mBooleanThreadLocal.get());
            }
        }.start();

        new Thread(){
            public void run(){
                Log.d(TAG, "[2]mBooleanThreadLocal=" + mBooleanThreadLocal.get());
            }
        }.start();
    }
}
