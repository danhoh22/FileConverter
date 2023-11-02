package ru.vyatsu.service.structure;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

/**
 * Представляет автомобиль с его характеристиками в формате JSON.
 */
@Getter
@Setter
@JsonPropertyOrder({"model", "yearofproduction", "horsepower", "equipment"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModelsJSON {
    private String model; // Название автомобиля
    private String yearofproduction; // Год выпуска
    private String horsepower; // Кол-во лошадиных сил
    private EquipmentXML equipment; // Комплектация
}