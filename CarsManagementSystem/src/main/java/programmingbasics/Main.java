package programmingbasics;

import programmingbasics.model.Car;
import programmingbasics.model.CarList;
import programmingbasics.model.Color;
import programmingbasics.parser.JsonParser;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Car audi = new Car.CarBuilder().name("AUDI").price(BigDecimal.valueOf(30000)).engineCapacity(BigDecimal.valueOf(2.5))
                .mileage(100000).color(Color.BLACK)
                .equipmentList(Arrays.asList("Ait Conditioning", "Electric Mirrors")).build();
        Car bmw = new Car.CarBuilder().name("BMW").price(BigDecimal.valueOf(50000)).engineCapacity(BigDecimal.valueOf(2.0))
                .mileage(50000).color(Color.BLUE)
                .equipmentList(Arrays.asList("Air Conditioning","Heated Seats", "Distance Sensor", "Small Seat Head TV ")).build();
        Car mazda = new Car.CarBuilder().name("MAZDA").price(BigDecimal.valueOf(50000)).engineCapacity(BigDecimal.valueOf(1.2))
                .mileage(130000).color(Color.BLUE)
                .equipmentList(Arrays.asList("Air Conditioning", "ABS", "GPS Navigation")).build();
        Car suzuki = new Car.CarBuilder().name("SUZUKI").price(BigDecimal.valueOf(25000)).engineCapacity(BigDecimal.valueOf(3.0))
                .mileage(170000).color(Color.WHITE)
                .equipmentList(Arrays.asList("Air Conditioning", "Electric mirrors", "Automatic Parking System")).build();
        System.out.println(audi);
        System.out.println(bmw);
        System.out.println(mazda);
        System.out.println(suzuki);

         List<Car> cars = new ArrayList<>();
        cars.add(audi);
        cars.add(bmw);
        cars.add(mazda);
        cars.add(suzuki);
        JsonParser<CarList> toJsonParser = new JsonParser<>(CarList.class);

        CarList cars1 = new CarList(cars);
        toJsonParser.toJson(cars1, "newCars.json");


        CarList carList = new CarList("newCars.json");

        System.out.println(carList);


        System.out.println("Max price of the cars, if price is equal for a few print every of them");
        System.out.println(carList.maxPrices());
        System.out.println("___________________________________");
        System.out.println("___________________________________");
        System.out.println("Show map with color as the key");
        System.out.println(carList.carsColorMap());
        System.out.println("___________________________________");
        System.out.println("___________________________________");
        System.out.println("Show every component as a key and cars as values");
        System.out.println(carList.componentsMap());
        System.out.println("___________________________________");
        System.out.println("___________________________________");
        System.out.println("Show every car in given range of prices");
        System.out.println(carList.carsInGivenPriceRange(BigDecimal.ONE, BigDecimal.valueOf(50000)));
        System.out.println("___________________________________");
        System.out.println("___________________________________");
        System.out.println("Show cars with sorted components");
        carList.sortComponentsInCarList();
        System.out.println("SORTING CARS BY ELEMENTS");
        System.out.println("___________________________________");
        System.out.println("___________________________________");
        carList.sortingCars("pr","s");



        System.out.println("___________________________________");
        System.out.println("___________________________________");
        System.out.println("String list Name - mileage in alphabetical order");
        System.out.println();
        System.out.println(carList.getStringCarList());
        System.out.println("___________________________________");
        System.out.println("___________________________________");
        System.out.println();
        System.out.println("Statistics of the price, mileage and engine capacity");
        System.out.println();
        carList.carsStats();
        System.out.println("___________________________________");
        System.out.println("___________________________________");
        System.out.println();
        System.out.println("Check maximum price in car list given in Optional");
        System.out.println();
        System.out.println(carList.maxPrice());
        System.out.println("___________________________________");
        System.out.println("___________________________________");
        System.out.println();
        System.out.println("Check if every car has a given component");
        System.out.println();
        carList.checkIfCarHasComponent("Air Conditioning");
        System.out.println("___________________________________");
        System.out.println("___________________________________");
        System.out.println();
        System.out.println("Remove cars from the list while mileage is more than given argument");
        System.out.println();
        carList.removeCarsFromList(100000);
        System.out.println("___________________________________");
        System.out.println("___________________________________");
        System.out.println(cars);


        System.out.println();
        System.out.println();

    }
}
