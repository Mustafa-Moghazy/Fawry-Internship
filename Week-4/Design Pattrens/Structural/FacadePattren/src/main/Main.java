package main;

import facade.ComputerSystemFacade;

public class Main {
    public static void main(String[] args) {

        ComputerSystemFacade computerSystem = new ComputerSystemFacade();
        computerSystem.start();
        computerSystem.shutdown();
    }
}