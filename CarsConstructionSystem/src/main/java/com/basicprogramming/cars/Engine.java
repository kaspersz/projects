package com.basicprogramming.cars;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Engine {
private EngineType engineType;
private BigDecimal engineCapacity;
private BigDecimal combustion;
}
