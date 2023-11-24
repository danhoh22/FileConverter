package ru.vyatsu.service.converters;

import ru.vyatsu.service.structureJSON.CarMakerJSON;
import ru.vyatsu.service.structureJSON.CarShopJSON;
import ru.vyatsu.service.structureJSON.ModelsJSON;
import ru.vyatsu.service.structureXML.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Трансформер для преобразования данных из формата XML (в виде {@link CarshopXML}) в JSON (в виде списка {@link CarMakerJSON}).
 */
public class XMLtoJSONTransformer {
    private XMLtoJSONTransformer() {
        throw new IllegalStateException("Utility class");
    }

    public static CarShopJSON transform(CarshopXML garageXML) {
        Map<String, List<ModelsJSON>> carmakeMap = new LinkedHashMap<>();

        garageXML.getCars().forEach(carXML -> {
            ModelsJSON car = ModelsJSON.builder()
                    .model(carXML.getModel())
                    .yearofproduction(carXML.getYearofproduction())
                    .horsepower(carXML.getHorsepower())
                    .equipment(carXML.getEquipment())
                    .build();

            carmakeMap.computeIfAbsent(carXML.getCarmaker(), k -> new ArrayList<>()).add(car);
        });

        List<CarMakerJSON> brandsList = carmakeMap.entrySet().stream()
                .map(entry -> CarMakerJSON.builder()
                        .name(entry.getKey())
                        .models(entry.getValue())
                        .build())
                .toList();

        CarShopJSON carshopJSON = new CarShopJSON();
        carshopJSON.setCarMake(brandsList);
        return carshopJSON;
    }
}
