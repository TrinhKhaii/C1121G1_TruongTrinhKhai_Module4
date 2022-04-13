package com.example.spring_hit_counter.model;
/*
    Created by Trinh Khai
    Date: 12/04/2022
    Time: 21:54
*/

public class Counter {
    private int count;

    public Counter() {
    }

    public Counter(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int increment() {
        return count++;
    }
}
