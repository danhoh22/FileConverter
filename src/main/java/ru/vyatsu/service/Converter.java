package ru.vyatsu.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public abstract class Converter {
    protected static final XmlMapper xmlMapper = new XmlMapper();
    protected static final ObjectMapper objectMapper = new ObjectMapper();

    public abstract void convert(String inputFile, String outputFile) throws IOException;

    protected String readFile(String path) throws IOException {
        return Files.readString(Paths.get(path));
    }

    protected void writeFile(String path, String content) throws IOException {
        Files.writeString(Paths.get(path), content, StandardCharsets.UTF_8);
    }

    public static boolean isJSONtoXML(String inputFile, String outputFile) {
        return inputFile.endsWith(".json") && outputFile.endsWith(".xml");
    }

    public static boolean isXMLtoJSON(String inputFile, String outputFile) {
        return inputFile.endsWith(".xml") && outputFile.endsWith(".json");
    }
}

