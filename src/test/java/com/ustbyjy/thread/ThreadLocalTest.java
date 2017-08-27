package com.ustbyjy.thread;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Administrator
 * Date: 2017/8/21
 * Time: 9:54
 */
public class ThreadLocalTest {

    private static A a = new A();

    private static final ThreadLocal<A> threadLocal = new ThreadLocal<A>() {
        @Override
        protected A initialValue() {
            return a;
        }
    };

    private static final ThreadLocal<A> anotherThreadLocal = new ThreadLocal<A>() {
        @Override
        protected A initialValue() {
            return new A();
        }
    };

    @Test
    public void test1() {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    threadLocal.get().setNumber(threadLocal.get().getNumber() + 5);
                    System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get().getNumber());
                }
            }, "Thread" + i);
        }

        for (Thread thread : threads) {
            thread.start();
        }
    }

    @Test
    public void test2() {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    anotherThreadLocal.get().setNumber(anotherThreadLocal.get().getNumber() + 5);
                    System.out.println(Thread.currentThread().getName() + ": " + anotherThreadLocal.get().getNumber());
                }
            }, "Thread" + i);
        }

        for (Thread thread : threads) {
            thread.start();
        }
    }
}

class A {
    private int number = 0;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
