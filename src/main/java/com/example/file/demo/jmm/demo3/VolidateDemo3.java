package com.example.file.demo.jmm.demo3;


/**
 * 禁止指令重排序
 */
public class VolidateDemo3 {

    private int count = 0;
    private boolean flag = false;

    public void method() {
        count = 1;
        flag = true;
    }

    public void method2() {
        if (flag) {
            count = count + 1;
            System.out.println("count的值输出---" + count);
        }
    }

    public static void main(String[] args) {
        VolidateDemo3 demo3 = new VolidateDemo3();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                demo3.method();
                demo3.method2();
            }).start();
        }
    }
}
