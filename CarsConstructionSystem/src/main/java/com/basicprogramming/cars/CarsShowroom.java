package com.basicprogramming.cars;

import com.basicprogramming.parser.CarJsonParser;
import com.basicprogramming.parser.CarsShowroomJsonParser;
import com.basicprogramming.parser.JsonParser;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor

public class CarsShowroom {
    private Set<Car> cars = new HashSet<>();

    public CarsShowroom(List<String> list) {

        for (int i = 0; i < list.size(); i++) {
            CarJsonParser c = new CarJsonParser(list.get(i));
            cars.add(c.fromJson().get());
        }
    }

    public Set<Car> sortByGivenElement(String element, String sortType) {
        List<String> elements = new ArrayList<>(Arrays.asList("Components", "EngineCapacity", "WheelSize"));
        List<String> sortingTypeList = new ArrayList<>(Arrays.asList("ascending", "descending"));
        Scanner sc = new Scanner(System.in);
        while (!elements.contains(element)) {
            System.out.println("You can choose only following elements");
            System.out.println(elements);
            System.out.println("Please put an element:");
            element = sc.nextLine();
        }
        while (!sortingTypeList.contains(sortType)) {
            System.out.println("You can choose only following sorting types");
            System.out.println(sortingTypeList);
            System.out.println("Please put a sorting type:");
            sortType = sc.nextLine();
        }

        if (element.equals("Components") && sortType.equals("ascending")) {
            return cars.stream()
                    .collect(Collectors.toCollection(() ->
                            new TreeSet<>(Comparator.comparingInt(p -> p.getCarBody().getEquipmentList().size()))));


        } else if (element.equals("Components") && sortType.equals("descending")) {
          /*  return cars.stream()
                    .sorted((a, b) -> Integer.compare(b.getCarBody().getEquipmentList().size(), a.getCarBody().getEquipmentList().size()))
                    .collect(Collectors.toSet());*/

            return cars.stream()
                    .collect(Collectors.toCollection(() ->
                            new TreeSet<>((a, b) -> Integer.compare(b.getCarBody().getEquipmentList().size(), a.getCarBody().getEquipmentList().size()))));
        }

        if (element.equals("EngineCapacity") && sortType.equals("ascending")) {
            return cars.stream()
                    .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(p -> p.getEngine().getEngineCapacity()))));

        } else if (element.equals("EngineCapacity") && sortType.equals("descending")) {
            return cars.stream()
                    .collect(Collectors.toCollection(() -> new TreeSet<>((a, b) -> b.getEngine().getEngineCapacity().compareTo(a.getEngine().getEngineCapacity()))));
        }

        if (element.equals("WheelSize") && sortType.equals("ascending")) {

            return cars.stream().collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparingInt(p -> p.getWheel().getSize()))));

        } else if (element.equals("WheelSize") && sortType.equals("descending")) {

            return cars.stream().collect(Collectors.toCollection(() -> new TreeSet<>((a, b) -> Integer.compare(b.getWheel().getSize(), a.getWheel().getSize()))));
        }

        return null;
    }

    public Set<Car> sortingByPrice() {
        return cars.stream()
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Car::getPrice))));
    }

    public Set<Car> sortingByColor() {
        return cars.stream()
                .collect(Collectors.toCollection(
                        () -> new TreeSet<>((pr1, pr2) -> pr1.getCarBody().getColorCarBody().toString().compareTo(pr2.getCarBody().getColorCarBody().toString()))));
    }

    public Set<Car> sortingByBodyType() {
        return cars.stream()
                .collect(Collectors.toCollection(
                        () -> new TreeSet<>((pr1, pr2) -> pr1.getCarBody().getTypeCarBody().toString().compareTo(pr2.getCarBody().getTypeCarBody().toString()))));
    }

    public List<String> carsWithChosenEngineType(EngineType engineType) {

        return cars.stream()
                .filter(p -> p.getEngine().getEngineType().equals(engineType))
                .map(p -> p.getName()).sorted(String::compareTo).collect(Collectors.toList());

    }

    public Set<Car> typeCarBodies(TypeCarBody typeCarBody, BigDecimal pr1, BigDecimal pr2) {
        if (pr1.compareTo(pr2) > 0 || pr1.compareTo(BigDecimal.ZERO) < 0 || pr2.compareTo(BigDecimal.ZERO) < 0) {
            return null;
        }
        return cars.stream()
                .filter(p -> p.getCarBody().getTypeCarBody().equals(typeCarBody)
                        && p.getPrice().compareTo(pr1) > 0 && p.getPrice().compareTo(pr2) < 0).collect(Collectors.toSet());
    }

    public Set<Car> carConfiguration() {
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        System.out.println("put type of the engine");
        String en = sc.nextLine();
        System.out.println("Put minimal price od the car");
        BigDecimal minPrice = sc.nextBigDecimal();
        System.out.println("Put maximal price od the car");
        BigDecimal maxPrice = sc.nextBigDecimal();
        System.out.println("Put minimal capacity of the car");
        BigDecimal minCapacity = sc.nextBigDecimal();
        System.out.println("Put maximal capacity of the car");
        BigDecimal maxCapacity = sc.nextBigDecimal();




        return cars.stream().filter(p -> p.getPrice().compareTo(minPrice) > 0 && p.getPrice().compareTo(maxPrice) < 0
                && p.getEngine().getEngineType().toString().equalsIgnoreCase(en)&&p.getEngine().getEngineCapacity().compareTo(minCapacity) > 0 && p.getEngine().getEngineCapacity().compareTo(maxCapacity) < 0).collect(Collectors.toSet());

    }

    public void getCarStatisticOfGivenElement(String nameOfType) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>(Arrays.asList("Price", "Capacity","Wheel Size"));
        while (!list.contains(nameOfType)) {
            System.out.println("You can choose only from following elements" + list);
            System.out.println("Put correct element");
            nameOfType = sc.nextLine();
        }
        if (nameOfType.equals("Price")) {
            BigDecimal totalPrice = cars.stream().map(p -> p.getPrice()).reduce(BigDecimal.ZERO, (pr1, pr2) -> pr1.add(pr2));
            System.out.println("Average price of the cars = " + totalPrice.divide(BigDecimal.valueOf(cars.size()), 5));
            BigDecimal maxPrice = cars.stream().map(p -> p.getPrice()).sorted((a, b) -> b.compareTo(a)).findFirst().orElse(BigDecimal.ZERO);
            System.out.println("Max price of the cars is: " + maxPrice);
            BigDecimal minPrice = cars.stream().map(p -> p.getPrice()).sorted(BigDecimal::compareTo).findFirst().orElse(BigDecimal.ZERO);
            System.out.println("Min price of the cars is: " + minPrice);
        } else if (nameOfType.equals("Capacity")) {
            BigDecimal AverageCapacity = cars.stream().map(p -> p.getEngine().getEngineCapacity()).reduce(BigDecimal.ZERO, (pr1, pr2) -> pr1.add(pr2));
            System.out.println("Average Capacity of the cars = " + AverageCapacity.divide(BigDecimal.valueOf(cars.size()), 5));
            BigDecimal maxCapacity = cars.stream().map(p -> p.getEngine().getEngineCapacity()).sorted((a, b) -> b.compareTo(a)).findFirst().orElse(BigDecimal.ZERO);
            System.out.println("Max Capacity of the cars is: " + maxCapacity);
            BigDecimal minCapacity = cars.stream().map(p -> p.getEngine().getEngineCapacity()).sorted(BigDecimal::compareTo).findFirst().orElse(BigDecimal.ZERO);
            System.out.println("Min Capacity of the cars is: " + minCapacity);
        } else if (nameOfType.equals("Wheel Size")) {
            IntSummaryStatistics iss = cars
                    .stream()
                    .collect(Collectors.summarizingInt(p -> p.getWheel().getSize()));
            System.out.println("Average size of the wheels is: " + iss.getAverage());
            System.out.println("Maximal size of the wheels is: " + iss.getMax());
            System.out.println("Minimal size of the wheels is: " + iss.getMin());

        }
    }

    public Map<WheelType, List<Car>> whichWheelInTheCar() {

        Map<WheelType, List<Car>> map = cars.stream().collect(Collectors.groupingBy(p -> p.getWheel().getWheelType()));
        return map;
    }

    public Map<Car, Integer> distanceMap() {
        return cars.stream().collect(Collectors.toMap(
                e -> e,
                e -> e.getMileage()
        ))/*.entrySet().stream().sorted(Comparator.comparingInt(Map.Entry::getValue))*/;
    }


    public List <Car> checkComponents(Equipment e) {
       return cars.stream().filter(p -> p.getCarBody().getEquipmentList().contains(e)).collect(Collectors.toList());

    }
}
