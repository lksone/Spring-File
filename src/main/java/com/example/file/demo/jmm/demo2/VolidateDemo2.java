package com.example.file.demo.jmm.demo2;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.TimeUnit;

@Setter
@Getter
class MyDate {
    public MyDate() {
    }

    private int count = 0;

    public void add() {
        count = 20;
    }
}

/**
 * @author lks
 */
public class VolidateDemo2 {

    public static void main(String[] args) {
        MyDate myDate = new MyDate();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myDate.add();
            System.out.println(Thread.currentThread().getName() + "-----------" + myDate.getCount());
        }).start();

        while (myDate.getCount() == 0) {

        }

        System.out.println(Thread.currentThread().getName() + "-----------" + myDate.getCount());
    }
}
