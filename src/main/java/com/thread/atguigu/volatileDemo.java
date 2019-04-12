package com.thread.atguigu;

/**
 *
 *   volatile 关键字  与内存可见性
 *   create by : lc
 *   time : 2019-3-29
 */
public class volatileDemo {

    /*
     * 主线程main 执行顺序优先，
     * 创建两个线程类分别实现runnable接口 其中ThreadDemo1 不加volatile关键字   ThreadDemo2 加volatile关键字
     * 正常run模式输出结果:
     * ThreadDemo1              ThreadDemo2
     * 输出                      输出
     * flag=true                ------------------
     *                          flag=true
     *
     *
     * debug模式下
     * ThreadDemo1             ThreadDemo2
     * 输出                     输出
     * flag=true               flag=true
     * ------------------      ------------------
     *这是为什么呢？
     *原因就在于 内存可见性问题，这种情况类似于数据库得脏读，数据的复制也涉及到读、改、写三个过程,并且每个线程都有自己的内存(也有人叫缓存)
     * 当td2.start()开启线程得时候，run方法执行将flag得值改成true之前睡了0.2秒,还没来得及写入主存中,这时主存中的flag=false
     * main线程的while方法执行优先,当然,td2.isFlag()返回的数据一定是false,所以先输出了flag=true,细心的会发现程序主程序会一直运行
     *
     * 如果加上volatile关键字后，两个线程操作同一个数据的动作变成可见的，也可以理解成读写同步，自然进入if方法 break掉了while循环，线程停止
     */
    /*
     * 顺便提一下  操作共享数据:即一个变量时，为什么一般不用synchronized关键字，
     * synchronized关键字是通过阻塞线程，来实现数据同步的，但一个线程在操作flag时，另一个线程会处于阻塞状态，如果只是boolean 改值的问题，那无所谓
     * 但是如果应用场景改成： 将大量的数据 插入到hbase数据库中，多线程效率很低
     */
    public  static void main(String[] args) {
        ThreadDemo1 td = new ThreadDemo1();
//        ThreadDemo2 td2 = new ThreadDemo2();
        new Thread(td).start();
        while(true){
//            synchronized (td){
            if(td.isFlag()){
                System.out.println("------------------");
                break;
            }
//            }
        }

    }
}
class  ThreadDemo1  implements Runnable {

    private  boolean flag = false;

    @Override
    public  void run() {

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }

         flag = true;

        System.out.println("flag=" + isFlag());

    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

}
class ThreadDemo2 implements Runnable {

    private volatile boolean flag = false;

    @Override
    public void run() {

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }

        flag = true;

        System.out.println("flag=" + isFlag());

    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

}