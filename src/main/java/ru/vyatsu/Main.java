package ru.vyatsu;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import ru.vyatsu.service.InputHandler;

/**
 * Главный класс приложения для преобразования данных между форматами XML и JSON.
 * Поддерживает конвертацию XML в JSON и наоборот.
 */
@Slf4j
public class Main {
    public static void main(String[] args) {
        try {
            val inputFile = InputHandler.getInputFilePath(args);
            val outputFile = InputHandler.getOutputFilePath(args);
            InputHandler.convert(inputFile, outputFile);
        } catch (Exception exception) {
            log.error("Ошибка: Произошла ошибка: {}", exception.getMessage());
        }
    }
}
