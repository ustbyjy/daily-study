package com.ustbyjy.thread;

import com.ustbyjy.entity.User;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ustbyjy
 * Date: 2017-03-20
 * Time: 22:11
 */
public class QueueTest {
    private static Queue<User> userQueue = new ConcurrentLinkedQueue<User>();

    public static void main(String[] args) {
        System.out.println("==================== Test begins ====================");
        for (int i = 0; i < 20; i++) {
            User user = new User();
            user.setId(i + 1);
            user.setName("name" + i);
            user.setAge(new Random().nextInt(30));

            userQueue.offer(user);
        }

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10; i++) {
            executorService.submit(new Runnable() {
                public void run() {
                    while (!userQueue.isEmpty()) {
                        User user = userQueue.poll();
                        print(user);
                    }
                }
            });
        }
        executorService.shutdown();
        System.out.println("==================== Test   ends ====================");
    }

    private static void print(User user) {
        try {
            Thread.sleep(1000);
            System.out.println(user);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
