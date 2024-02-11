package main;

public class Main {
    public static void main(String[] args) {

        // Test MultiThreads Without Thread Safe //
        Thread[] threads = new Thread[10];
        for (int i = 0; i<10; ++i){
            threads[i] = new Thread(()->{
                SingletonWithoutThreadSafe.getInstance("Test");
            });
        }
        for( Thread thread : threads){
            thread.start();
        }

        // Test MultiThreads With Thread Safe //
        Thread[] testThreads = new Thread[10];
        for (int i = 0; i<10; ++i){
            testThreads[i] = new Thread(()->{
                SingletonWithThreadSafe.getInstance("Test");
            });
        }
        for( Thread thread : testThreads){
            thread.start();
        }
    }
}