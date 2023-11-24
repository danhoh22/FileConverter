package ru.vyatsu;

import ru.vyatsu.service.MenuService;
import ru.vyatsu.service.Converter;
import ru.vyatsu.service.converters.*;
import java.io.IOException;
import static ru.vyatsu.service.Converter.isJSONtoXML;
import static ru.vyatsu.service.Converter.isXMLtoJSON;

/**
 * Главный класс приложения для преобразования данных между форматами XML и JSON.
 * Поддерживает конвертацию XML в JSON и наоборот.
 */
public class Main {
    public static void main(String[] args) {
        try {
            switch (args.length)
            {
                case 2:
                {
                    // Запуск с аргументами командной строки
                    String inputFile = args[0];
                    String outputFile = args[1];
                    Convert(inputFile, outputFile);
                    break;
                }
                case 0:
                {
                    // Интерактивный режим
                    String inputFile = MenuService.getInputFilePath();
                    String outputFile = MenuService.getOutputFilePath();
                    Convert(inputFile, outputFile);
                    break;
                }
                default:
                {
                    // Ошибка в количестве аргументов
                    System.err.println("Ошибка: Неверное количество аргументов. Для ручного режима не указывайте аргументы, для автоматического используйте 2 аргумента.");
                }
            }
        } catch (Exception exception) {
            System.err.println("Ошибка: Произошла ошибка: "+ exception.getMessage());
        }
    }
    public static void Convert(String inputFile, String outputFile)
    {
        try {
        Converter converter = null;
        if(isXMLtoJSON(inputFile, outputFile))
        {
            converter = new XMLToJsonConverter();
        }
        else if(isJSONtoXML(inputFile, outputFile))
        {
            converter = new JsonToXMLConverter();
        }
        converter.convert(inputFile, outputFile);
        } catch (Exception exception) {
            System.err.println("Ошибка: Произошла ошибка во время конвертации: " + exception.getMessage());
        }
    }
}
