package ru.vyatsu.service.structureXML;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.Getter;
import lombok.Setter;

/**
 * Класс для представления салона с автомобилями в формате XML.
 */
@Getter
@Setter
public class CarshopXML {
    @JacksonXmlElementWrapper(useWrapping = false) // Без обертки
    @JacksonXmlProperty(localName = "car")
    private List<CarXML> cars; // Список автомобилей в салоне
}
