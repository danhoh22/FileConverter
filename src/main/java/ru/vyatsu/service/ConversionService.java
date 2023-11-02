package ru.vyatsu.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vyatsu.service.structure.CarshopJSON;
import ru.vyatsu.service.structure.CarshopXML;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class ConversionService {
    private static final Logger logger = LoggerFactory.getLogger(ConversionService.class);
    private static final XmlMapper xmlMapper = new XmlMapper();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private ConversionService() {
        throw new IllegalStateException("Utility class");
    }

    public static void convert(String inputFile, String outputFile, ConversionType conversionType) {
        try {
            switch (conversionType) {
                case XML_TO_JSON -> {
                    if (isXMLtoJSON(inputFile, outputFile)) {
                        String xmlContent = readFile(inputFile);
                        String jsonContent = convertXMLtoJSON(xmlContent);
                        writeFile(outputFile, jsonContent);
                    } else {
                        logger.error("Неверный формат для XML -> JSON конвертации.");
                    }
                }
                case JSON_TO_XML -> {
                    if (isJSONtoXML(inputFile, outputFile)) {
                        String jsonContent = readFile(inputFile);
                        String xmlContent = convertJSONtoXML(jsonContent);
                        writeFile(outputFile, xmlContent);
                    } else {
                        logger.error("Неверный формат для JSON -> XML конвертации.");
                    }
                }
                default -> logger.error("Несоответствие форматов файла и выбранной операции.");
            }
        } catch (Exception exception) {
            logger.error("Произошла ошибка во время конвертации: {}", exception.getMessage());
        }
    }

    private static String readFile(String path) throws IOException {
        return Files.readString(Paths.get(path));
    }

    private static void writeFile(String path, String content) throws IOException {
        Files.writeString(Paths.get(path), content, StandardCharsets.UTF_8);
    }

    public static String convertXMLtoJSON(String xmlContent) throws JsonProcessingException {
        CarshopXML carshopXML = xmlMapper.readValue(xmlContent, CarshopXML.class);
        Object result = TransformerType.XMLTOJSON.transform(carshopXML);

        // Проверка и обработка результата
        if (!(result instanceof CarshopJSON carshopJSON)) {
            logger.error("Ожидалось получить Сarshop, а получили {}", result != null ? result.getClass().getSimpleName() : "null");
            return null;
        }

        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(carshopJSON);

    }

    public static String convertJSONtoXML(String jsonContent) throws JsonProcessingException {
        CarshopJSON сarshopJSON = objectMapper.readValue(jsonContent, CarshopJSON.class);
        CarshopXML carshopXML = (CarshopXML) TransformerType.JSONTOXML.transform(сarshopJSON);
        return xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(carshopXML);
    }

    public static boolean isXMLtoJSON(String inputFile, String outputFile) {
        return inputFile.endsWith(".xml") && outputFile.endsWith(".json");
    }

    public static boolean isJSONtoXML(String inputFile, String outputFile) {
        return inputFile.endsWith(".json") && outputFile.endsWith(".xml");
    }
}