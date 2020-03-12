package com.basicprogramming.cars;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarBody {
    private ColorCarBody colorCarBody;
    private TypeCarBody typeCarBody;
    private List<Equipment> equipmentList;

}
