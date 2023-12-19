package ru.vyatsu.service.structure.JSON;

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
public class CarShopJSON {
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
    @JsonProperty("carShop")
    private List<CarMakerJSON> carMaker; // Список произовдителей
}
