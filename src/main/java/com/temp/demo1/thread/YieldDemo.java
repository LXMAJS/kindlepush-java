package com.temp.demo1.thread;

public class YieldDemo {

    public static void main ( String[] args ) {
        Runnable yieldTask = new Runnable () {
            @Override
            public void run () {
                for (int i = 1; i <= 10; i ++){
                    System.out.println (Thread.currentThread ().getName () + " - " + i);
                    if(i == 5){
                        Thread.yield ();
                    }
                }
            }
        };

        Thread a = new Thread ( yieldTask, "A" );
        Thread b = new Thread ( yieldTask, "B" );

        a.start ();
        b.start ();
    }
}
