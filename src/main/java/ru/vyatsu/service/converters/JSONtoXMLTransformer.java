package ru.vyatsu.service.converters;

import ru.vyatsu.service.structureJSON.CarShopJSON;
import ru.vyatsu.service.structureXML.CarXML;
import ru.vyatsu.service.structureXML.CarShopXML;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Трансформер для преобразования данных из формата JSON (в виде {@link CarShopJSON}) в XML (в виде {@link CarShopXML}).
 */
public class JSONtoXMLTransformer {
    private static final AtomicInteger uniqueIdGenerator = new AtomicInteger(1);

    public static CarShopXML transform(CarShopJSON carShopJSON) {
        var carShopXML = new CarShopXML();
        List<CarXML> carXMLList = carShopJSON.getCarMake().stream()
                .flatMap(carMake -> carMake.getModels().stream()
                        .map(car -> CarXML.builder()
                                .id(generateUniqueId())
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

    // Метод для генерации уникального идентификатора
    private static int generateUniqueId() {
        return uniqueIdGenerator.getAndIncrement();
    }
}
