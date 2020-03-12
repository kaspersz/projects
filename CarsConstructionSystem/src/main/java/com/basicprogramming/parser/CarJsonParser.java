package com.basicprogramming.parser;

import com.basicprogramming.cars.Car;

public class CarJsonParser extends JsonParser<Car>{
    public CarJsonParser(String jsonFileName) {
        super(jsonFileName);
    }
}
