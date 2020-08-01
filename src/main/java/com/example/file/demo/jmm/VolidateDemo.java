package com.example.file.demo.jmm;

/**
 * 证明volidate不具备原子性
 *
 * @author Administrator
 */
public class VolidateDemo {

    public static void main(String[] args) {
        CountDmeo demo = new CountDmeo();
        //1.线程执行
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    try {
                        Thread.sleep(100);
                        demo.add();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        //当线程
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println("count==" + demo.getCount());
    }
}
