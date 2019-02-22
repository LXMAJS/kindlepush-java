package com.temp.demo1.thread;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

    /**
     *
     * @return
     * @throws Exception
     */
    @Override
    public String call () throws Exception {
        String value = "test";
        System.out.println ("Ready to call");

        Thread.currentThread ().sleep ( 5000 );

        System.out.println ("Task down");

        return value;
    }
}
