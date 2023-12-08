package ru.vyatsu.service;

import ch.qos.logback.classic.Logger;
import ru.vyatsu.service.converters.JsonToXMLConverter;
import ru.vyatsu.service.converters.XMLToJsonConverter;

import java.io.IOException;
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

    public static void convert(String inputFile, String outputFile) throws IOException {
            Converter converter = null;
            if (Converter.isXMLtoJSON(inputFile, outputFile)) {
                converter = new XMLToJsonConverter();
            } else if (Converter.isJSONtoXML(inputFile, outputFile)) {
                converter = new JsonToXMLConverter();
            }
            converter.convert(inputFile, outputFile);
    }
}
