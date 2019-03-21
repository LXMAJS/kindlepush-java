package com.temp.demo1.threadpool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolDemo {

    public static class MyTask implements Runnable{

        @Override
        public void run () {
            System.out.println (System.currentTimeMillis () + " : Thread Id : "
                    + Thread.currentThread ().getId ());

            try {
                Thread.sleep ( 1000 );
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
        }
    }

    public static void main ( String[] args ) {
        MyTask t = new MyTask ();
        //ExecutorService es = Executors.newFixedThreadPool (5);
        ExecutorService es = Executors.newCachedThreadPool ();
        for (int i = 0; i < 10; i++){
            es.submit ( t );
        }
    }

}
