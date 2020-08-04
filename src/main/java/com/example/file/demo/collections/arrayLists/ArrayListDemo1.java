package com.example.file.demo.collections.arrayLists;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * arrayList的多线程添加方式
 */
public class ArrayListDemo1 {


    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 0; i <= 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
            }).start();
        }
        System.out.println("ArrayListDemo1.main" + list);
    }
}
