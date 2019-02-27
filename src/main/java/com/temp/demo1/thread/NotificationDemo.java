package com.temp.demo1.thread;

public class NotificationDemo {

    /**
     * 该变量可以被多个线程改动，其中一个线程改动后，其他的线程可以立即获得改动后的值
     */
    private volatile boolean go = false;


    public static void main ( String[] args ) throws InterruptedException {
        final NotificationDemo test = new NotificationDemo ();

        /**
         *
         */
        Runnable waitTask = new Runnable () {
            @Override
            public void run () {
                try {
                    test.shouldGo ();
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
                System.out.println (Thread.currentThread ().getName () +
                        " Finished execution。");
            }
        };

        /**
         *
         */
        Runnable notifyTask = new Runnable () {
            @Override
            public void run () {
                test.go ();
                System.out.println (Thread.currentThread ().getName () +
                        " Finished execution.");
            }
        };

        /**
         *
         */
        Thread t1 = new Thread ( waitTask, "WT1" );
        Thread t2 = new Thread ( waitTask, "WT2" );
        Thread t3 = new Thread ( waitTask, "WT3" );
        Thread t4 = new Thread ( notifyTask, "NT4" );

        // start all waiting task
        t1.start ();
        t2.start ();
        t3.start ();

        // pause to ensure all waiting thread started successfully
        Thread.sleep ( 200 );

        // start notify thread
        t4.start ();
    }

    /**
     * wait and notify can only be called from synchronized method and ...
     * @throws InterruptedException
     */
    private synchronized void shouldGo() throws InterruptedException {
        while (go != true){
            System.out.println (Thread.currentThread ().getName () +
                    " is going to wait on this object.");
            wait ();
            System.out.println (Thread.currentThread ().getName () +
                    " is woken up.");
        }
        go = false; // resetting condition
    }

    /**
     *
     */
    private synchronized void go(){
        while (go == false){
            System.out.println (Thread.currentThread ().getName () +
                    " is going to notify all or one thread waiting on ");
            go = true;
            notify ();
            // notifyAll ();
        }

    }
}
