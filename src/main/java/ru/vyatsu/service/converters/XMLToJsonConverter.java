package ru.vyatsu.service.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.vyatsu.service.Converter;
import ru.vyatsu.service.structureJSON.CarShopJSON;
import ru.vyatsu.service.structureXML.CarshopXML;
import java.io.IOException;

public class XMLToJsonConverter extends Converter {
    @Override
    public void convert(String inputFile, String outputFile) throws IOException {
        // Логика конвертации XML в JSON
        String xmlContent = readFile(inputFile);
        String jsonContent = convertXMLtoJSON(xmlContent);
        writeFile(outputFile, jsonContent);
    }
    public static String convertXMLtoJSON(String xmlContent) throws JsonProcessingException {
        CarshopXML carshopXML = xmlMapper.readValue(xmlContent, CarshopXML.class);
        Object result = XMLtoJSONTransformer.transform(carshopXML);
        // Проверка и обработка результата
        if (!(result instanceof CarShopJSON carshopJSON)) {
            System.err.println("Ошибка: Ожидалось получить Сarshop.");
            return null;
        }
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(carshopJSON);
    }
}
