package ru.vyatsu.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.InputMismatchException;
import java.util.Scanner;

public final class MenuService {
    private static final Logger logger = LoggerFactory.getLogger(MenuService.class);
    private static final Scanner scanner = new Scanner(System.in);
    private MenuService() {
    }
    public static String getInputFilePath() {
        logger.info("Введите путь к входному файлу:");
        return scanner.nextLine();
    }
    public static String getOutputFilePath() {
        logger.info("Введите путь к выходному файлу:");
        return scanner.nextLine();
    }
}