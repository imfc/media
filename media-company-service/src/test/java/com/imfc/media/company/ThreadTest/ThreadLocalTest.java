package com.imfc.media.company.ThreadTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadLocalTest {
    static int n = 0;
    static Lock lock = new ReentrantLock();
    public static final ThreadLocal<String> threadLocal = new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return "324";
        }
    };

    static void add(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(lock.tryLock()){
            n++;
            lock.unlock();
        }


    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("ll："+threadLocal.get());
        for (int i = 0; i < 10; i++) {
            begainThread();

        }

    }

    private static void begainThread() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set(Thread.currentThread().getName());
                System.out.println(threadLocal.get());
                ThreadLocalTest.add();
                System.out.println("n::"+n);
            }
        });
        thread.start();
//        thread.join();
    }
}
