package org.example;

import org.junit.Test;

public class ThreadTest {

    @Test
    public void threadTest(){

        Thread thread = new Thread(() -> {

            try {
                Thread.sleep(2000L);
                System.out.println("Thread!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        System.out.println("Hello");
    }
}
