package main;

public class SingletonWithThreadSafe {
    public static String input;
    private static volatile SingletonWithThreadSafe instance;
    private SingletonWithThreadSafe(String in){
        this.input = in;
    };
    public static SingletonWithThreadSafe getInstance(String input){
        if(instance == null){
            synchronized (SingletonWithThreadSafe.class) {
                if (instance == null) {
                    instance = new SingletonWithThreadSafe(input);
                    System.out.println("New Instance Created With Thread Safe");
                }
            }
        }
        return instance;
    };
}
