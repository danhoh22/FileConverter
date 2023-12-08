package ru.vyatsu.service.structure.XML;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.*;

import java.util.UUID;

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
    private UUID id; // Идентификатор
    @JacksonXmlProperty(isAttribute = true)
    private String carMaker; // Марка автомобиля
    private String model; // Название автомобиля
    private String yearOfProduction; // Год выпуска
    private String horsePower; // Кол-во лошадиных сил
    private EquipmentXML equipment; // Комплектация
}
