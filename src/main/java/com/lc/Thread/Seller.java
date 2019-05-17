package com.lc.Thread;

public class Seller implements Runnable{

    static int tick = 100;
    @Override
    public void run() {

        while (tick>0) {
            synchronized (this){
            if (tick > 0) {
                tick--;
                System.out.println(Thread.currentThread().getName() + "-----" + tick);
                Thread.yield();
                }
            }
        }
    }



}

