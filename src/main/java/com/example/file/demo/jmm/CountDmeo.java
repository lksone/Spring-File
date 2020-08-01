package com.example.file.demo.jmm;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CountDmeo {

    volatile int count = 0;

    public void add() {
        count++;
    }
}
