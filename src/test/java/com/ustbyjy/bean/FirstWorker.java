package com.ustbyjy.bean;

import com.ustbyjy.callback.Callback;

import java.util.concurrent.TimeUnit;

public class FirstWorker implements Worker {

    @Override
    public void doWork(Callback callback) {
        System.out.println("FirstWorker doWork...");

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        callback.reportWork("first");
    }
}
