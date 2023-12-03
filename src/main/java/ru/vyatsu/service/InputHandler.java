package ru.vyatsu.service;

import java.util.Scanner;

public class InputHandler {

    public static String getInputFilePath(String[] args) {
        if (args.length == 2) {
            return args[0];
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите путь к входному файлу: ");
            return scanner.nextLine();
        }
    }

    public static String getOutputFilePath(String[] args) {
        if (args.length == 2) {
            return args[1];
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите путь к выходному файлу: ");
            return scanner.nextLine();
        }
    }
}
