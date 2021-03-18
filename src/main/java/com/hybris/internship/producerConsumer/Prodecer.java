package com.hybris.internship.producerConsumer;

import java.util.List;

public class Prodecer implements Runnable{

    private List<Integer> questionList;
    private final int LIMIT = 5;
    private int questionNo;

    public Prodecer(List<Integer> questionList) {
        this.questionList = questionList;
    }

    public void readQuestion(int questionNo) throws InterruptedException {
        synchronized (questionList) {
            while (questionList.size() == LIMIT) {
                System.out.println("Questions has pilled up.. wait for answers");
                questionList.wait();
            }
        }

        synchronized (questionList) {
            System.out.println("New question: " + questionNo);
            questionList.add(questionNo);
            Thread.sleep(100);
            questionList.notify();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                readQuestion(questionNo++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
