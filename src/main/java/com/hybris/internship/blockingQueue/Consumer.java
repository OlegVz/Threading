package com.hybris.internship.blockingQueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

    private BlockingQueue<Integer> questionQueue;

    public Consumer(BlockingQueue<Integer> questionQueue) {
        this.questionQueue = questionQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println("ANSWERED QUESTION: " + questionQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
