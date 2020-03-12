package com.basicprogramming.cars;

import com.basicprogramming.parser.JsonParser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Data
@AllArgsConstructor


public class CarReview {
    private Map<String, Integer> carReview;


    public CarReview() {
        this.carReview = getMap();
    }

    public Map<String, Integer> getMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("MAZDA", 100000);
        map.put("BMW", 150000);
        map.put("AUDI", 160000);

        return map;
    }

}
