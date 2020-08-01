package com.example.file.demo.current;


import java.util.concurrent.Semaphore;

/**
 * Semaphore 是一个限流锁
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                     System.out.println("t1 running");
                    Thread.sleep(100);
                    System.out.println("t1 ent");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                }
            }).start();
        }
    }
}
