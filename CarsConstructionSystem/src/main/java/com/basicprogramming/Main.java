package com.basicprogramming;

import com.basicprogramming.cars.*;
import com.basicprogramming.parser.CarJsonParser;
import com.basicprogramming.parser.JsonParser;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String[] args) {


        List<String> fileList = new ArrayList<>(Arrays.asList("car1.json", "car2.json", "car3.json"));
        CarsShowroom cars = new CarsShowroom(fileList);
        System.out.println(cars);


        System.out.println("Get a List of the cars which have components given as argument");
        System.out.println(cars.checkComponents(Equipment.ELECTRIC_MIRRORS));
        System.out.println("Get a Map of Car and Mileage in ascending order of values" );
        System.out.println(cars.distanceMap());
        System.out.println("Sort cars by given elements");
        //given arguments are not match to required so system asks us to choose elements
        System.out.println(cars.sortByGivenElement("s","s"));

        System.out.println(cars);
        //SORTING CARS BY PRICE
        System.out.println(cars.sortingByPrice());
        //SORTING CARS BY COLORS
        System.out.println(cars.sortingByColor());
        //SORTING CARS BY BODYTYPE
        System.out.println(cars.sortingByBodyType());
        //SHOW CARS WITH GIVEN ENGINE TYPE
        System.out.println(cars.carsWithChosenEngineType(EngineType.DIESEL));
        //SHOW CARS WITH GIVEN BODY TYPE
        System.out.println(cars.typeCarBodies(TypeCarBody.KOMBI, BigDecimal.ZERO, BigDecimal.valueOf(70000)));
        //SHOW CARS WITH GIVEN YOUR OWN CONFIGURATION
        System.out.println(cars.carConfiguration());
        //GET STATISTIC OF GIVEN ELEMENT
        cars.getCarStatisticOfGivenElement("Whee Size");


    }


}
