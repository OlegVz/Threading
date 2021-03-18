package com.hybris.internship.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class Application {

    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> questionQueue = new ArrayBlockingQueue<Integer>(5);
        Thread t1 = new Thread(new Producer(questionQueue));
        Thread t2 = new Thread(new Consumer(questionQueue));

        t1.start();
        t2.start();
    }
}
