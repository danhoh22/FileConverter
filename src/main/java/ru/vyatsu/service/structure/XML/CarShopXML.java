package ru.vyatsu.service.structure.XML;

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
public class CarShopXML {
    @JacksonXmlElementWrapper(useWrapping = false) // Без обертки
    @JacksonXmlProperty(localName = "car")
    private List<CarXML> cars; // Список автомобилей в салоне
}
