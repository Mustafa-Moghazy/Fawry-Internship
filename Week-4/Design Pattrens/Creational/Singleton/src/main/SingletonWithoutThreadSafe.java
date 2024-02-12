package main;

public class SingletonWithoutThreadSafe {
    public static String input;
    private static SingletonWithoutThreadSafe instance;
    private SingletonWithoutThreadSafe(String in){
        this.input = in;
    };
    public static SingletonWithoutThreadSafe getInstance(String input){
        if(instance == null){
            instance = new SingletonWithoutThreadSafe(input);
            System.out.println("New Instance Created Without Thread Safe");
        }
        return instance;
    };

}
