package com.temp.demo1.gc;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class NomalObjectWeakReference extends WeakReference<NomalObject> {
    /**
     *
     */
    public String name;

    /**
     *
     * @param nomalObject
     * @param rq
     */
    public NomalObjectWeakReference( NomalObject nomalObject, ReferenceQueue<NomalObject> rq){
        super(nomalObject, rq);
        this.name = nomalObject.name;
    }

    @Override
    protected void finalize(){
        System.out.println ("Finalizing NomalObjectWeakReference : "+ name);
    }
}
