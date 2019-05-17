package com.lc.Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.BlockingQueue;
@SuppressWarnings("all")
public class Run {


    volatile static int tickt=100;
    public  static void main(String[] args) {

//        System.out.println("开始卖票");
//        Seller seller = new Seller();
////        Seller seller2 = new Seller();D
//        Thread thread1 = new Thread(seller,"一号窗口");
//        Thread thread2 = new Thread(seller,"二号窗口");
//         thread1.start();
//         thread2.start();
        String str = sellTicket();
//        countNum(str);
    }




    public static String sellTicket(){

        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 100,100,TimeUnit.MINUTES, queue);
        StringBuffer sb = new StringBuffer();
            try{
                for (int i=0;i<tickt;i++) {
                    if (!executor.isShutdown()) {
                        executor.execute(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    tickt--;
                                    System.out.println("票数还剩下：" + tickt);
                                    String str = "票数还剩下:"+tickt;
                                    sb.append(str);
                                } catch (Exception e) {

                                }
//                                String name = Thread.currentThread().getName();
//                                System.out.println(name);
                            }
                        });
                    }
                }
            }catch (Exception e){
                System.out.println(e);
            }

            return sb.toString();
    }

    public static void countNum(String string){


        System.out.println(string.split("票数还剩下").length+"++++++++++++++++++++++++++++++++++++++");


    }

}
