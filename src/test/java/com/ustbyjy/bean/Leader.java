package com.ustbyjy.bean;

import com.ustbyjy.callback.Callback;

public class Leader implements Callback {

    private Worker worker;

    public Leader(Worker worker) {
        this.worker = worker;
    }

    public void assignWork() {
        System.out.println("Leader assignWork...");
        worker.doWork(this);
    }

    @Override
    public void reportWork(String work) {
        System.out.println("Worker reportWork, " + work);
    }
}
