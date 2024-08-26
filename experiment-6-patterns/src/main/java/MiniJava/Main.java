package MiniJava;

import MiniJava.facade.MiniJavaFacade;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java Main <source-file>");
            return;
        }
        MiniJavaFacade facade = new MiniJavaFacade();
        facade.initiate(args[0]);
    }
}