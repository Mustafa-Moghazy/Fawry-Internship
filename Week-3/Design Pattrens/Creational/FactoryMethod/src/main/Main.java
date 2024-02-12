package main;

import factory.AnimalFactoryImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Which Animal Object Would You Create" +
                "\n1 : Lion" +
                "\n2 : Tiger" +
                "\n3 : Wolf");
        int type = in.nextInt();
        AnimalFactoryImpl animalFactory = new AnimalFactoryImpl();
        animalFactory.createAnimal(type);
    }
}