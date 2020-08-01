package com.example.file.demo.current;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 读写锁
 */
public class ReadWriteLockDemo {

    static Lock lock = new ReentrantLock();


    private static int value;

    public static void read(Lock lock) {
        try {
            lock.lock();
            Thread.sleep(1000);
            System.out.println("ReadWriteLockDemo.read");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public static void write(Lock lock, int s) {
        try {
            lock.lock();
            Thread.sleep(1000);
            System.out.println("ReadWriteLockDemo.write,"+ s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        Runnable read = () -> read(lock);

        Runnable write = () -> write(lock,new Random().nextInt());

        for (int i = 0; i < 10; i++) {
            new Thread(read).start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(write).start();
        }
    }
}
