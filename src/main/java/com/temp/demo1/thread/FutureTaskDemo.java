package com.temp.demo1.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


/**
 * 使用Callable的FutureTask的方式，来处理子线程的返回值
 */
public class FutureTaskDemo {

    public static void main ( String[] args ) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<String > ( new MyCallable ()  );
        new Thread(task).start ();
        if(!task.isDone ()){
            System.out.println ("task is not finished, please wait");
        }
        System.out.println ("task result : "+ task.get ());
    }
}
