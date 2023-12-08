package ru.vyatsu.service.structure.JSON;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.*;

import java.util.List;

/**
 * Представляет марку автомобиля со списком его моделей.
 */
@Getter
@Setter
@JsonTypeName("carMaker")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarMakerJSON {
    private String name; // Название марки
    private List<ModelsJSON> models; // Список моделей автомобилей этой марки
}

