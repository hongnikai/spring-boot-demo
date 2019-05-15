package com.lc.Thread;

/**
 * 多线程例子 : 取豆子
 */
public class SyncDemo {
    static int beans = 20;

    public static void main(String[] args) {

        Table table = new Table();
        Table.Person p1 = table.new Person();
        Table.Person p2 = table.new Person();
        Table.Person p3 = table.new Person();
        p1.start();
        p2.start();
        p3.start();
    }

    static class Table {
        public int getBean() {
            if (beans == 0)
                throw new RuntimeException("没了！");
            Thread.yield();
            return beans--;
        }

        class Person extends Thread{
            public void run(){
                while(true){
                    int bean = getBean();
                    System.out.println(getName()+","+bean);
                    Thread.yield();
                }
            }

            public  int getBean(){
                synchronized (this){
                if (beans==0)
                    throw new RuntimeException("没了");
                Thread.yield();
                return beans--;
                }
            }
        }
    }





}