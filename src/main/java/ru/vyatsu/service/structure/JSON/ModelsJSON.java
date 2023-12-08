package ru.vyatsu.service.structure.JSON;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import ru.vyatsu.service.structure.XML.EquipmentXML;

/**
 * Представляет автомобиль с его характеристиками в формате JSON.
 */
@Getter
@Setter
@JsonPropertyOrder({"model", "yearOfProduction", "horsePower", "equipment"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModelsJSON {
    private String model; // Название автомобиля
    private String yearOfProduction; // Год выпуска
    private String horsePower; // Кол-во лошадиных сил
    private EquipmentXML equipment; // Комплектация
}