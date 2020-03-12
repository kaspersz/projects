package com.basicprogramming.cars;

import com.basicprogramming.parser.CarJsonParser;
import com.basicprogramming.parser.JsonParser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Car {
    private String name;
    private BigDecimal price;
    private int mileage;
    private Engine engine;
    private Wheel wheel;
    private CarBody carBody;

    public Car(String jsonFileName) {
        CarJsonParser jsonParser = new CarJsonParser(jsonFileName);
        this.name = jsonParser.fromJson().get().name;
        this.price = jsonParser.fromJson().get().price;
        this.mileage = jsonParser.fromJson().get().mileage;
        this.engine = jsonParser.fromJson().get().engine;
        this.wheel = jsonParser.fromJson().get().wheel;
        this.carBody = jsonParser.fromJson().get().carBody;
    }

    /*public static List<String> createCarFileNames() {
        Car c1 = Car.builder().name("BMW").price(BigDecimal.valueOf(50000)).mileage(100000)
                .engine(Engine.builder().engineType(EngineType.DIESEL).engineCapacity(BigDecimal.valueOf(2.5))
                        .combustion(BigDecimal.valueOf(8)).build())
                .carBody(CarBody.builder().colorCarBody(ColorCarBody.BLACK).typeCarBody(TypeCarBody.KOMBI)
                        .equipmentList(Arrays.asList(Equipment.AIR_CONDITIONING, Equipment.ALARM, Equipment.BACK_DOOR)).build())
                .wheel(Wheel.builder().brandName("Michelin").size(185).wheelType(WheelType.SUMMER).build()).build();

        Car c2 = Car.builder().name("MAZDA").price(BigDecimal.valueOf(30000)).mileage(150000)
                .engine(Engine.builder().engineType(EngineType.BENZIN).engineCapacity(BigDecimal.valueOf(2.0))
                        .combustion(BigDecimal.valueOf(10)).build())
                .carBody(CarBody.builder().colorCarBody(ColorCarBody.WHITE).typeCarBody(TypeCarBody.SEDAN)
                        .equipmentList(Arrays.asList(Equipment.ELECTRIC_WINDOWS, Equipment.ALARM, Equipment.ELECTRIC_MIRRORS)).build())
                .wheel(Wheel.builder().brandName("Continental").size(180).wheelType(WheelType.WINTER).build()).build();

        Car c3 = Car.builder().name("AUDI").price(BigDecimal.valueOf(80000)).mileage(50000)
                .engine(Engine.builder().engineType(EngineType.DIESEL).engineCapacity(BigDecimal.valueOf(3.0))
                        .combustion(BigDecimal.valueOf(12.5)).build())
                .carBody(CarBody.builder().colorCarBody(ColorCarBody.GREEN).typeCarBody(TypeCarBody.HATCHBACK)
                        .equipmentList(Arrays.asList(Equipment.RADIO, Equipment.SKIN_SEATS, Equipment.AIR_CONDITIONING)).build())
                .wheel(Wheel.builder().brandName("Michelin").size(185).wheelType(WheelType.SUMMER).build()).build();
        List<Car> carList = new ArrayList<>(Arrays.asList(c1, c2, c3));

        JsonParser<Car> jsonParser = new JsonParser<>(Car.class);
        String car1 = "car1.json";
        String car2 = "car2.json";
        String car3 = "car3.json";
        List<String> carFileNames = new ArrayList<>(Arrays.asList(car1, car2, car3));
        for (int i = 0; i < carFileNames.size(); i++) {
            jsonParser.toJson(carList.get(i), carFileNames.get(i));

        }

        return carFileNames;
    }*/
}
