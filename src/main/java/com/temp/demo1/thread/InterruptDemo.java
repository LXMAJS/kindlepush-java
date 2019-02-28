package com.temp.demo1.thread;

public class InterruptDemo {

    public static void main ( String[] args ) throws InterruptedException {
        Runnable interruptTask = new Runnable () {
            @Override
            public void run () {
                int i = 0;
                try {
                    // 在正常运行的线程中，经常检查线程中断的标志位，如果被设置了中断线程的标志位，就自动中断线程
                    while (!Thread.currentThread ().isInterrupted ()) {
                        Thread.sleep ( 100 );
                        i++;
                        System.out.println ( Thread.currentThread ().getName ()
                                + "(" + Thread.currentThread ().getState () + ") loop " + i );
                    }
                } catch (InterruptedException e) {
                    System.out.println (Thread.currentThread ().getName ()
                            + "(" + Thread.currentThread ().getState () + ") catch interrupt exception" );
                }
            }
        };

        Thread t1 = new Thread ( interruptTask, "t1" );
        System.out.println (t1.getName () + "(" + t1.getState () + ")"  + " is new.");

        t1.start ();
        System.out.println (t1.getName () + "(" + t1.getState () + ")" + " is started.");

        Thread.sleep ( 1000 );
        t1.interrupt ();
        System.out.println (t1.getName () + "(" + t1.getState () + ")" + " is interrupted.");

        Thread.sleep ( 3000 );
        System.out.println (t1.getName () + "(" + t1.getState () + ")" + " is interrupted now.");
    }
}
