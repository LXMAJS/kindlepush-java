package com.temp.demo1.reflect;

public class Robot {

    /**
     *
     */
    private String name;

    /**
     *
     * @param helloSentense
     */
    public void sayHi ( String helloSentense ) {
        System.out.println ( helloSentense + " - " + name );
    }

    /**
     *
     * @param tag
     * @return
     */
    private String throwHello(String tag){
        return "Hello " + tag;
    }

    /**
     * 静态代码段
     */
    static {
        System.out.println ("Hello Robot");
    }
}
