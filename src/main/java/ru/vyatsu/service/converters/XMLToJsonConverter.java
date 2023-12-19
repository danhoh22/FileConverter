package ru.vyatsu.service.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.val;
import ru.vyatsu.service.Converter;
import ru.vyatsu.service.structure.JSON.CarShopJSON;
import ru.vyatsu.service.structure.XML.CarShopXML;

import java.io.IOException;

public class XMLToJsonConverter extends Converter {
    @Override
    public void convert(String inputFile, String outputFile) throws IOException {
        writeFile(outputFile, convertXMLtoJSON(readFile(inputFile)));
    }


    public String convertXMLtoJSON(String xmlContent) throws JsonProcessingException {
        CarShopXML carShopXML = xmlMapper.readValue(xmlContent, CarShopXML.class);
        CarShopJSON carShopJSON = new XMLtoJSONTransformer().transform(carShopXML);
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(carShopJSON);
    }
}
