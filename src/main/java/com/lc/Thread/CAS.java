package com.lc.Thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("all")
public class CAS {


    public static void main(String[] args) {

//        AtomicDemo ad = new AtomicDemo();
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 100,5,TimeUnit.MINUTES, queue);
        for (int i=0;i<=10;i++){
            if (!executor.isShutdown()) {
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {

//                            System.out.println("票数还剩下："+ad.getSerialNumber() + " "+Thread.currentThread().getName());
                        } catch (Exception e) {

                        }
//                                String name = Thread.currentThread().getName();
//                                System.out.println(name);
                    }

                    });
            }
        }
        executor.shutdown();  //关闭线程池
    }




}
