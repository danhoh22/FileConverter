package ru.vyatsu.service.structureJSON;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.*;

import java.util.List;

/**
 * Представляет марку автомобиля со списком его моделей.
 */
@Getter
@Setter
@JsonTypeName("carmaker")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarMakerJSON {
    private String name; // Название марки
    private List<ModelsJSON> models; // Список моделей автомобилей этой марки
}

