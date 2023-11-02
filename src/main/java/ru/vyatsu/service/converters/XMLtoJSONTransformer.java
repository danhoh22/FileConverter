package ru.vyatsu.service.converters;

import ru.vyatsu.service.structure.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Трансформер для преобразования данных из формата XML (в виде {@link CarshopXML}) в JSON (в виде списка {@link CarmakeJSON}).
 */
public class XMLtoJSONTransformer {
    private XMLtoJSONTransformer() {
        throw new IllegalStateException("Utility class");
    }

    public static CarshopJSON transform(CarshopXML garageXML) {
        Map<String, List<ModelsJSON>> carmakeMap = new LinkedHashMap<>();

        garageXML.getCars().forEach(carXML -> {
            ModelsJSON car = ModelsJSON.builder()
                    .model(carXML.getModel())
                    .yearofproduction(carXML.getYearofproduction())
                    .horsepower(carXML.getHorsepower())
                    .equipment(carXML.getEquipment())
                    .build();

            carmakeMap.computeIfAbsent(carXML.getCarmake(), k -> new ArrayList<>()).add(car);
        });

        List<CarmakeJSON> brandsList = carmakeMap.entrySet().stream()
                .map(entry -> CarmakeJSON.builder()
                        .name(entry.getKey())
                        .models(entry.getValue())
                        .build())
                .toList();

        CarshopJSON carshopJSON = new CarshopJSON();
        carshopJSON.setCarMake(brandsList);
        return carshopJSON;
    }
}
