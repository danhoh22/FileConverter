package ru.vyatsu.service.structure;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


/**
 * Класс контейнер для хранения производителей марок автомобилей.
 */
@Getter
@Setter
public class CarshopJSON {
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
    @JsonProperty("carshop")
    private List<CarmakeJSON> carMake; // Список произовдителей
}