package com.temp.demo1;

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
}
