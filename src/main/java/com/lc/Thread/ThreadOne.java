package com.lc.Thread;

public class ThreadOne implements Runnable {

    private int ticket;

    public ThreadOne(int ticket) {
        this.ticket = ticket;
    }

    @Override
    public void run() {
    while (ticket>0){
     ticket--;
        System.out.println("窗口1剩余:"+ticket+"张票");
    }
    }
}
