package com.temp.demo1.thread;

public class RunnableDemo {
    public static void main ( String[] args ) {
        MyRunnable mr1 = new MyRunnable ( "MyRunnable1" );
        MyRunnable mr2 = new MyRunnable ( "MyRunnable2" );
        MyRunnable mr3 = new MyRunnable ( "MyRunnable3" );

        Thread t1 = new Thread ( mr1 );
        Thread t2 = new Thread ( mr2 );
        Thread t3 = new Thread ( mr3 );

        t1.start ();
        t2.start ();
        t3.start ();
    }
}
