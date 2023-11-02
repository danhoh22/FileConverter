package ru.vyatsu.service.converters;

import ru.vyatsu.service.structure.CarshopJSON;
import ru.vyatsu.service.structure.CarXML;
import ru.vyatsu.service.structure.CarshopXML;
import java.util.List;

/**
 * Трансформер для преобразования данных из формата JSON (в виде {@link CarshopJSON}) в XML (в виде {@link CarshopXML}).
 */
public class JSONtoXMLTransformer {
    private JSONtoXMLTransformer() {
        throw new IllegalStateException("Трансформер для преобразования данных из формата JSON");
    }
    public static CarshopXML transform(CarshopJSON carshopJSON) {
        var carshopXML = new CarshopXML();
        List<CarXML> carXMLList = carshopJSON.getCarMake().stream()
                .flatMap(carmake -> carmake.getModels().stream()
                        .map(car -> CarXML.builder()
                                .carmake(carmake.getName())
                                .model(car.getModel())
                                .yearofproduction(car.getYearofproduction())
                                .horsepower(car.getHorsepower())
                                .equipment(car.getEquipment())
                                .build()

                        )
                ).toList();

        carshopXML.setCars(carXMLList);
        return carshopXML;
    }
}
