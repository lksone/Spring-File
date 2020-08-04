package com.example.file.demo.current;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 计数器
 * <p>
 * 1.countDownLatch是一个计数器，线程完成一个记录一个，计数器递减，只能只用一次
 * 2.CyclicBarrier的计数器更像一个阀门，需要所有线程都到达，然后继续执行，计数器递增，提供reset功能，可以多次使用
 *
 * @author lks
 */
@Slf4j
public class CountDownLathDemo {


    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        log.info("开始执行-----");
        //第一个线程执行
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("子线程执行{},{}", Thread.currentThread().getName());
            countDownLatch.countDown();
        });
        executorService.shutdown();

        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        executorService1.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("子线程执行{},{}", Thread.currentThread().getName());
            countDownLatch.countDown();
        });
        executorService1.shutdown();

        countDownLatch.await();

        log.info("主线程执行--{}", Thread.currentThread().getName());
    }
}
