package com.basicprogramming.cars;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Wheel {
    private String brandName;
    private int size;
    private WheelType wheelType;
}
