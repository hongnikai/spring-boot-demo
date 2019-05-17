package com.lc.Thread;

public class ThreadTwo implements Runnable {
    private int ticket;

    public ThreadTwo(int ticket) {
        this.ticket = ticket;
    }

    @Override
    public void run() {
        while (ticket>0){
            ticket--;
            System.out.println("窗口2剩余:"+ticket+"张票");
        }
    }
}