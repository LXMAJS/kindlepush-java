package com.temp.demo1.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolDemo {

    public static void main ( String[] args ) {
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool ();
        Future<String> future = newCachedThreadPool.submit ( new MyCallable () );
        if(!future.isDone ()){
            System.out.println ("task is not finished, please wait");
        }
        try {
            System.out.println ("task result : "+ future.get ());
        } catch (InterruptedException e) {
            e.printStackTrace ();
        } catch (ExecutionException e) {
            e.printStackTrace ();
        } finally {
            newCachedThreadPool.shutdown ();
        }
    }
}
