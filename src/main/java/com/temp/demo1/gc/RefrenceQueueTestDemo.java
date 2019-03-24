package com.temp.demo1.gc;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class RefrenceQueueTestDemo {

    public static ReferenceQueue<NomalObject> rq = new ReferenceQueue<NomalObject> ();

    public static void checkQueue(){
        Reference<NomalObject> ref = null;
        while((ref = (Reference<NomalObject>)rq.poll ()) != null){
            if(ref != null){
                System.out.println ("In queue : "+ ((NomalObjectWeakReference)(ref)).name);
                System.out.println ("reference object : "+ ref.get ());
            }
        }
    }

    public static void main ( String[] args ) {
        ArrayList<WeakReference<NomalObject>> weakList = new ArrayList<WeakReference<NomalObject>> (  );
        for (int i = 0; i < 3; i ++){
            weakList.add ( new NomalObjectWeakReference ( new NomalObject ( "Weak"+i), rq ) );
            System.out.println ("Created weak : " + weakList.get ( i ));
        }

        System.out.println ("First time");
        checkQueue ();

        System.gc ();
        try {
            Thread.currentThread ().sleep ( 1000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }

        System.out.println ("Second time");
        checkQueue ();


    }
}
