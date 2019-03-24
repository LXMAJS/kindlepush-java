package com.temp.demo1.gc;

public class NomalObject {

    /**
     *
     */
    public String name;

    /**
     *
     * @param name
     */
    public NomalObject(String name){
        this.name = name;
    }


    @Override
    protected void finalize(){
        System.out.println ("Finalizing obj : "+ name);
    }
}
