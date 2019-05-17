package com.lc.Thread.atguigu;

import java.util.concurrent.CountDownLatch;

/**
 * 闭锁： 在完成某些运算时，只有当其他 所有线程 的运算全部完成，当前运算才会继续执行
 *
 */
public class TestCountDownLatch {

    public static void main(String[] args) {

        final CountDownLatch latch = new CountDownLatch(5);  //每次一个线程执行完，递减1，当所有线程完成操作，即为0
        LatchDemo ld = new LatchDemo(latch);

        long start = System.currentTimeMillis();

        for (int i=0;i<5;i++){
            new Thread(ld).start();
        }
        try {
            latch.await();//运行等待  目的是执行主线程的 逻辑
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("耗费时间为："+(end-start));

    }



}

class LatchDemo implements Runnable {

    private CountDownLatch latch;

    public LatchDemo(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {

        synchronized (this) {
            try {
                for (int i = 0; i < 50000; i++) {
                    if (i % 2 == 0) {
                        System.out.println(i);
                    }
                }
            } finally {
                latch.countDown();   //递减1
            }
        }
    }

}