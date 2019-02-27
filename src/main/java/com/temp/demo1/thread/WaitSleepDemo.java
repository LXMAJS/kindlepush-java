package com.temp.demo1.thread;

/**
 * Wait 和 Sleep 的区别测试demo
 */
public class WaitSleepDemo {

    public static void main ( String[] args ) {
        final Object lock = new Object ();

        new Thread ( new Runnable () {
            @Override
            public void run () {
                System.out.println ("Thread A is waiting to get lock");
                synchronized (lock){
                    try {
                        System.out.println ("Thread A get lock");
                        Thread.sleep ( 20 );
                        System.out.println ("Thread A do wait method");
                        lock.wait ();
                        System.out.println ("Thread A is done");
                    } catch (InterruptedException e) {
                        e.printStackTrace ();
                    }
                }
            }
        } ).start ();

        /**
         * 为了让上面的先执行，此处让主线程睡眠10毫秒
         */
        try {
            Thread.sleep ( 10 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }

        new Thread ( new Runnable () {
            @Override
            public void run () {
                System.out.println ("Thread B is waiting to get lock");
                synchronized (lock){
                    try {
//                        System.out.println ("Thread B get lock");
//                        System.out.println ("Thread B is sleeping 10ms");
//                        Thread.sleep ( 20 );
//                        System.out.println ("Thread B is done");
//
//                        // 唤醒沉睡的A线程
//                        lock.notify ();
//                        // 使用notifyAll也可以唤醒
//                        //lock.notifyAll ();

                        System.out.println ("Thread B get lock");
                        System.out.println ("Thread B is sleeping 10ms");
                        Thread.sleep ( 20 );

                        // 唤醒沉睡的A线程
                        lock.notify ();

                        Thread.yield ();
                        Thread.sleep ( 2000 );
                        System.out.println ("Thread B is done");
                    } catch (InterruptedException e) {
                        e.printStackTrace ();
                    }
                }
            }
        } ).start ();
    }
}
