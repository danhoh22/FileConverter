package ru.vyatsu.service.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.val;
import ru.vyatsu.service.Converter;
import ru.vyatsu.service.structure.JSON.CarShopJSON;
import ru.vyatsu.service.structure.XML.CarShopXML;

import java.io.IOException;

public class JsonToXMLConverter extends Converter {
    @Override
    public void convert(String inputFile, String outputFile) throws IOException {
        // Логика конвертации JSON в XML
        val jsonContent = readFile(inputFile);
        val xmlContent = convertJSONtoXML(jsonContent);
        writeFile(outputFile, xmlContent);
    }

    public String convertJSONtoXML(String jsonContent) throws JsonProcessingException {
        CarShopJSON carShopJSON = objectMapper.readValue(jsonContent, CarShopJSON.class);
        CarShopXML carShopXML = (CarShopXML) new JSONtoXMLTransformer().transform(carShopJSON);
        return xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(carShopXML);
    }
}
