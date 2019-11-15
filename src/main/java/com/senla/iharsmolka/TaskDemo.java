package com.senla.iharsmolka;

import java.util.Scanner;

public abstract class TaskDemo {

    /*
    * Abstract demonstration logic method
    * */
    public abstract void startDemo();

    protected void showMessage(String msg) {
        System.out.flush();
        System.out.println(msg);
    }

    protected void showMessage(String msg, boolean error) {
        System.out.flush();
        if (!error) {
            System.out.println(msg);
        }
        else {
            System.err.println(msg);
            showPause();
        }
    }

    protected void showPause() {
        System.out.println("Нажмите на Enter чтобы продолжить...");
        getUserInput();
    }

    protected String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    protected String[] parsingBySpaces(String str) {
        String buf = str.replaceAll("\\s+", " ");
        buf = buf.replaceAll("^[ ]", "");
        String[] items = buf.split("\\s");
        return items;
    }

}
