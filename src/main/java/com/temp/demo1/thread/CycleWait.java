package com.temp.demo1.thread;

/**
 * 线程返回值的处理方法
 */
public class CycleWait implements Runnable {

    private String value;

    @Override
    public void run () {
        try {
            Thread.currentThread ().sleep ( 5000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
        value = "We have data now";
    }

    public static void main ( String[] args ) throws InterruptedException {
        CycleWait cw = new CycleWait ();
        Thread t = new Thread ( cw );
        t.start ();

//        // 主线程等待法
//        while (cw.value == null){
//            Thread.currentThread ().sleep ( 100 );
//        }

        // 使用Thread自带的join方法，阻塞当前线程，等待子线程处理完毕
        t.join ();

        System.out.println ("value = " + cw.value);
    }
}
