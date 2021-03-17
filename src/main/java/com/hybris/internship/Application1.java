package com.hybris.internship;

public class Application1 {

    public static void main(String[] args) {

        System.out.println("Starting thread 1");
        Task1 taskRunner = new Task1("Thread - A");
        Thread thread1 = new Thread(taskRunner);
        thread1.start();

        System.out.println("Starting thread 2");
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 1000; i++) {
                    System.out.println("number: " + i + " - " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread2.start();
    }
}

class Task1 implements Runnable {

    private final String name;

    public Task1(String name) {
        this.name = name;
    }

    public void run() {

        Thread.currentThread().setName(name);

        for (int i = 0; i < 1000; i++) {
            System.out.println("number: " + i + " - " + Thread.currentThread().getName());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
