package main;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Test MultiThreads Without Thread Safe //
        Thread[] threads = new Thread[10];
        for (int i = 0; i<10; ++i){
            threads[i] = new Thread(()->{
                SingletonWithoutThreadSafe singlton = SingletonWithoutThreadSafe.getInstance("Test");
                System.out.println(Thread.currentThread().threadId() + " " + SingletonWithoutThreadSafe.input);
            });
        }
        for( Thread thread : threads){
            thread.start();
        }
    }
}