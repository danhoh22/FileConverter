package ru.vyatsu.service.converters;

import ru.vyatsu.service.structure.CarshopJSON;
import ru.vyatsu.service.structure.CarXML;
import ru.vyatsu.service.structure.CarshopXML;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Трансформер для преобразования данных из формата JSON (в виде {@link CarshopJSON}) в XML (в виде {@link CarshopXML}).
 */
public class JSONtoXMLTransformer {
    private static final AtomicInteger uniqueIdGenerator = new AtomicInteger(1);
    private JSONtoXMLTransformer() {
        throw new IllegalStateException("Трансформер для преобразования данных из формата JSON");
    }
    public static CarshopXML transform(CarshopJSON carshopJSON) {
        var carshopXML = new CarshopXML();
        List<CarXML> carXMLList = carshopJSON.getCarMake().stream()
                .flatMap(carmake -> carmake.getModels().stream()
                        .map(car -> {
                            // Уникальный идентификатор для каждого автомобиля
                            int carId = generateUniqueId();

                            return CarXML.builder()
                                    .id(carId)
                                    .carmake(carmake.getName())
                                    .model(car.getModel())
                                    .yearofproduction(car.getYearofproduction())
                                    .horsepower(car.getHorsepower())
                                    .equipment(car.getEquipment())
                                    .build();
                        })
                ).toList();
        carshopXML.setCars(carXMLList);
        return carshopXML;
    }
    // Метод для генерации уникального идентификатора
    private static int generateUniqueId() {
        return uniqueIdGenerator.getAndIncrement();
    }
}
