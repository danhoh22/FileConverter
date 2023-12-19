package ru.vyatsu.service.converters;

import ru.vyatsu.service.structure.JSON.CarMakerJSON;
import ru.vyatsu.service.structure.JSON.CarShopJSON;
import ru.vyatsu.service.structure.JSON.ModelsJSON;
import ru.vyatsu.service.structure.XML.CarShopXML;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Трансформер для преобразования данных из формата XML (в виде {@link CarShopXML}) в JSON (в виде списка {@link CarMakerJSON}).
 */
public class XMLtoJSONTransformer {
    public CarShopJSON transform(CarShopXML garageXML) {
        Map<String, List<ModelsJSON>> carmakeMap = new LinkedHashMap<>();

        garageXML.getCars().forEach(carXML -> {
            ModelsJSON car = ModelsJSON.builder()
                    .model(carXML.getModel())
                    .yearOfProduction(carXML.getYearOfProduction())
                    .horsePower(carXML.getHorsePower())
                    .equipment(carXML.getEquipment())
                    .build();

            carmakeMap.computeIfAbsent(carXML.getCarMaker(), k -> new ArrayList<>()).add(car);
        });

        List<CarMakerJSON> brandsList = carmakeMap.entrySet().stream()
                .map(entry -> CarMakerJSON.builder()
                        .name(entry.getKey())
                        .models(entry.getValue())
                        .build())
                .toList();

        CarShopJSON carShopJSON = new CarShopJSON();
        carShopJSON.setCarMaker(brandsList);
        return carShopJSON;
    }
}
