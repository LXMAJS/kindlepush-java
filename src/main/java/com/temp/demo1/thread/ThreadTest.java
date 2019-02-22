package com.temp.demo1.thread;

public class ThreadTest {

    private static void attack(){
        System.out.println ("Fight!");
        System.out.println ("Current Thread is : " + Thread.currentThread ().getName ());
    }

    public static void main ( String[] args ) throws InterruptedException {
        Thread t = new Thread (  ){
            public void run(){
                attack ();
            }
        };
        System.out.println ("Current Main Thread is : " + Thread.currentThread ().getName ());
        t.start ();

        // 测试线程进入Terminate状态后，在调用start方法，是否会抛出异常。
        t.join ();
        t.start ();
        /**
         * 事实证明，会抛出下面的异常
         * Exception in thread "main" java.lang.IllegalThreadStateException
         * 	at java.lang.Thread.start(Thread.java:708)
         * 	at com.temp.demo1.thread.ThreadTest.main(ThreadTest.java:21)
         */
    }
}
