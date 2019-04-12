package com.thread.atguigu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 写入并复制
 * 添加操作多时，写入并复制效率低，迭代操作时，效率高
 */
public class TestCopyOnWriteArrayList {

    public static void main(String[] args) {

        HelloThread ht = new HelloThread();
        for (int i=0;i<10;i++){

            new Thread(ht).start();


        }


    }


    static class HelloThread implements Runnable{

//        private static List<String> list = Collections.synchronizedList(new ArrayList<String>());

        private static CopyOnWriteArrayList<String> list= new CopyOnWriteArrayList<>();

       static  {
            list.add("AA");
            list.add("BB");
            list.add("CC");
        }

        @Override
        public void run() {
            Iterator<String> it =  list.iterator();
            while (it.hasNext()){

                System.out.println(it.next());
                list.add("AA");
            }

        }
    }


}
