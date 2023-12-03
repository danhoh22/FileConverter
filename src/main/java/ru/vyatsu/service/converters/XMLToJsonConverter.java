package ru.vyatsu.service.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.val;
import ru.vyatsu.service.Converter;
import ru.vyatsu.service.structureJSON.CarShopJSON;
import ru.vyatsu.service.structureXML.CarShopXML;

import java.io.IOException;

public class XMLToJsonConverter extends Converter {
    @Override
    public void convert(String inputFile, String outputFile) throws IOException {
        // Логика конвертации XML в JSON
        val xmlContent = readFile(inputFile);
        val jsonContent = convertXMLtoJSON(xmlContent);
        writeFile(outputFile, jsonContent);
    }

    public String convertXMLtoJSON(String xmlContent) throws JsonProcessingException {
        CarShopXML carShopXML = xmlMapper.readValue(xmlContent, CarShopXML.class);
        CarShopJSON carShopJSON = XMLtoJSONTransformer.transform(carShopXML);
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(carShopJSON);
    }
}
