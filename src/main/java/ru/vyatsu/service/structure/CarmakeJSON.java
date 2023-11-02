package ru.vyatsu.service.structure;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.*;

import java.util.List;

/**
 * Представляет марку автомобиля со списком его моделей.
 */
@Getter
@Setter
@JsonTypeName("carmake")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarmakeJSON {
    private String name; // Название марки
    private List<ModelsJSON> models; // Список моделей автомобилей этой марки
}

