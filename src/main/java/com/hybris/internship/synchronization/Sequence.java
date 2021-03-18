package com.hybris.internship.synchronization;

public class Sequence {

    private int value = 0;

    public int getNext() {
        synchronized (this) {
            value++;
            return value;
        }
    }

    public synchronized int getNext1() {
            value++;
            return value;
    }
}
