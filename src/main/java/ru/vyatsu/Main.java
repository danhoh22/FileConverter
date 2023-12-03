package ru.vyatsu;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import ru.vyatsu.service.Converter;
import ru.vyatsu.service.InputHandler;
import ru.vyatsu.service.converters.*;

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
            convert(inputFile, outputFile);
        } catch (Exception exception) {
            log.error("Ошибка: Произошла ошибка: {}", exception.getMessage());
        }
    }

    public static void convert(String inputFile, String outputFile) {
        try {
            Converter converter = null;
            if (Converter.isXMLtoJSON(inputFile, outputFile)) {
                converter = new XMLToJsonConverter();
            } else if (Converter.isJSONtoXML(inputFile, outputFile)) {
                converter = new JsonToXMLConverter();
            }
            converter.convert(inputFile, outputFile);
        } catch (Exception exception) {
            log.error("Ошибка: Произошла ошибка во время конвертации: {}", exception.getMessage());
        }
    }
}
