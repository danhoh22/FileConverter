package ru.vyatsu.service.converters;

import ru.vyatsu.service.structure.JSON.CarShopJSON;
import ru.vyatsu.service.structure.XML.CarXML;
import ru.vyatsu.service.structure.XML.CarShopXML;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Трансформер для преобразования данных из формата JSON (в виде {@link CarShopJSON}) в XML (в виде {@link CarShopXML}).
 */
public class JSONtoXMLTransformer {

    public CarShopXML transform(CarShopJSON carShopJSON) {
        var carShopXML = new CarShopXML();
        List<CarXML> carXMLList = carShopJSON.getCarMake().stream()
                .flatMap(carMake -> carMake.getModels().stream()
                        .map(car -> CarXML.builder()
                                .id(UUID.randomUUID())
                                .carMaker(carMake.getName())
                                .model(car.getModel())
                                .yearOfProduction(car.getYearOfProduction())
                                .horsePower(car.getHorsePower())
                                .equipment(car.getEquipment())
                                .build()
                        )
                ).toList();
        carShopXML.setCars(carXMLList);
        return carShopXML;
    }
}
