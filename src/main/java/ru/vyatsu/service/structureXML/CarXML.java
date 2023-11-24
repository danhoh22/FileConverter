package ru.vyatsu.service.structureXML;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.*;

/**
 * Представляет автомобиль с его характеристиками в формате XML.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarXML {
    @JacksonXmlProperty(isAttribute = true)
    private int id; // Идентификатор
    @JacksonXmlProperty(isAttribute = true)
    private String carmaker; // Марка автомобиля
    private String model; // Название автомобиля
    private String yearofproduction; // Год выпуска
    private String horsepower; // Кол-во лошадиных сил
    private EquipmentXML equipment; // Комплектация
}