package com.thread.atguigu;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 一、创建线程方式之三：  实现Callable接口    方法可以有返回值，并且可以抛出异常
 *
 *
 *
 */
public class TestCallable {

    public static void main(String[] args) {

        ThreadDemo td = new ThreadDemo();

        FutureTask<Integer> result =  new FutureTask<Integer>(td);
        long start = System.currentTimeMillis();

        for(int i=0;i<5;i++){
          Thread thread = new Thread(result);
            thread.start();
//            System.out.println(thread.getName());
        }
        try {
            Integer sum = result.get();   //线程在运行的过程中，获取不到结果，只有等线程运行结束后，才会获取到get()方法返回的值
//            System.out.println(sum);

         long end = System.currentTimeMillis();
            System.out.println("所用时间为："+(end-start));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}


class ThreadDemo implements Callable<Integer>{
   private int sum = 0;
    @Override
    public Integer call() throws Exception {

        for (int i=0;i<=10000000;i++){
            System.out.println(i);
            sum+=i;
        }

        return sum;
    }
}