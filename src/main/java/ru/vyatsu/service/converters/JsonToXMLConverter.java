package ru.vyatsu.service.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.vyatsu.service.Converter;
import ru.vyatsu.service.structureJSON.CarShopJSON;
import ru.vyatsu.service.structureXML.CarshopXML;

import java.io.IOException;

public class JsonToXMLConverter extends Converter {
    @Override
    public void convert(String inputFile, String outputFile) throws IOException {
        // Логика конвертации JSON в XML
        String jsonContent = readFile(inputFile);
        String xmlContent = convertJSONtoXML(jsonContent);
        writeFile(outputFile, xmlContent);
    }
    public static String convertJSONtoXML(String jsonContent) throws JsonProcessingException {
        CarShopJSON сarshopJSON = objectMapper.readValue(jsonContent, CarShopJSON.class);
        CarshopXML carshopXML = (CarshopXML) JSONtoXMLTransformer.transform(сarshopJSON);
        return xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(carshopXML);
    }
}
