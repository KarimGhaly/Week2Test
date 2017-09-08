package com.example.admin.week2test;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.util.Random;

/**
 * Created by Admin on 9/8/2017.
 */

public class RandomGenerator extends Thread {
    private static final String TAG = "RandTAG";
    Handler handler;

    public RandomGenerator(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {
        super.run();
        Bundle bundle = new Bundle();
        Random rand = new Random();
        bundle.putString("RNDKEY",String.valueOf(rand.nextInt()));
        Log.d(TAG, "run: "+Thread.currentThread());
        Message msg = new Message();
        msg.setData(bundle);
        handler.sendMessage(msg);
    }
}
