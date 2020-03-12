package programmingbasics.model;

import programmingbasics.parser.JsonParser;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CarList {

    private List<Car> cars;

    public CarList(String jsonFileName) {
        JsonParser<CarList> jsonParser = new JsonParser<>(CarList.class);
        this.cars = jsonParser.fromJson(jsonFileName).getCars();
    }

    public CarList(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }


    public void sortingCars(String element, String sortingType) {
        List<String> elements = new ArrayList<>(Arrays.asList("name", "price", "color", "mileage"));
        List<String> sortType = new ArrayList<>(Arrays.asList("ascending", "descending"));
        Scanner sc = new Scanner(System.in);
        while (!elements.contains(element)) {
            System.out.println("You can choose following elements " + elements + " Put correct element");
            element = sc.nextLine();
        }
        while (!sortType.contains(sortingType)) {
            System.out.println("You can choose following sorting types " + sortType + " Put correct sorting type");
            sortingType = sc.nextLine();
        }

        if (element.equals("name") && sortingType.equals("ascending")) {
            System.out.println("CARS SORTED BY NAME IN ASCENDING ORDER");
            cars.stream().sorted(Comparator.comparing((Car::getName))).forEach(p -> System.out.println(p));
        } else if (element.equals("name") && sortingType.equals("descending")) {
            System.out.println("CARS SORTED BY NAME IN DESCENDING ORDER");
            cars.stream().sorted(Comparator.comparing((Car::getName)).reversed()).forEach(p -> System.out.println(p));
        }

        if (element.equals("color") && sortingType.equals("ascending")) {
            System.out.println("CARS SORTED BY COLOR IN ASCENDING ORDER");
            cars.stream().sorted(Comparator.comparing(p->p.getColor().toString())).forEach(p -> System.out.println(p));

        } else if (element.equals("color") && sortingType.equals("descending")) {
            System.out.println("CARS SORTED BY COLOR IN DESCENDING ORDER");
            cars.stream().sorted((a, b) -> b.getColor().toString().compareTo(a.getColor().toString())).forEach(p -> System.out.println(p));
        }

        /*System.out.println("CARS SORTED BY EQUIPMENT LIST SIZE");
        cars.stream().sorted(Comparator.comparing(s -> s.getEquipmentList().size())).forEach(p -> System.out.println(p));
        System.out.println("___________________________________");
        System.out.println("___________________________________");*/

        if (element.equals("price") && sortingType.equals("ascending")) {
            System.out.println("CARS SORTED BY PRICE IN ASCENDING ORDER");
            cars.stream().sorted(Comparator.comparing((Car::getPrice))).forEach(p -> System.out.println(p));
        } else if (element.equals("price") && sortingType.equals("descending")) {
            System.out.println("CARS SORTED BY PRICE IN DESCENDING ORDER");
            cars.stream().sorted(Comparator.comparing((Car::getPrice)).reversed()).forEach(p -> System.out.println(p));
        }

       /* System.out.println("CARS SORTED BY ENGINE CAPACITY");
        cars.stream().sorted(Comparator.comparing((Car::getEngineCapacity))).forEach(p -> System.out.println(p));
        System.out.println("___________________________________");
        System.out.println("___________________________________");*/
        if (element.equals("mileage") && sortingType.equals("ascending")) {
            System.out.println("CARS SORTED BY MILEAGE IN ASCENDING ORDER");
            cars.stream().sorted(Comparator.comparing((Car::getMileage))).forEach(p -> System.out.println(p));
        } else if (element.equals("mileage") && sortingType.equals("ascending")) {
            System.out.println("CARS SORTED BY MILEAGE IN DESCENDING ORDER");
            cars.stream().sorted(Comparator.comparing((Car::getMileage)).reversed()).forEach(p -> System.out.println(p));
        }

    }

    public void removeCarsFromList(double mileage) {

        cars.removeIf(p -> p.getMileage() > mileage);

    }

    public List<Car> showCarsWithGivenMileage(double mileage) {
        return cars.stream().filter(p -> p.getMileage() > mileage).collect(Collectors.toList());
    }

    public Map<Color, Long> carsColorMap() {
        //dlaczego nie idzie od razu sortowac
        Map<Color, Long> map = cars.stream().collect(Collectors.groupingBy(p -> p.getColor(), Collectors.counting()));
        map.entrySet().stream().sorted((a, b) -> Long.compare(b.getValue(), a.getValue()));
        return map;
    }

    public Map<String, Car> mostExpensiveModels() {

        return cars.stream().collect(Collectors.groupingBy(p -> p.getName())).entrySet().stream().collect(Collectors.toMap(
                e -> e.getKey(),
                e -> e.getValue()
                        .stream()
                        .sorted(Comparator.comparing(Car::getPrice).reversed()).findFirst().orElse(null)
        ));
    }

    public List<String> getStringCarList() {
        List<String> stringCarList = cars.stream().map(p -> {

            if (p == null) {
                return null;
            }

            return p.getName() + "-" + p.getMileage();

        })
                .sorted(String::compareTo)
                .collect(Collectors.toCollection(() -> new ArrayList<>()));


        return stringCarList;
    }

    public void carsStats() {
        System.out.println("Car Statistics");
        System.out.println();
        BigDecimal maxPrice = cars.stream()
                .map(p -> p.getPrice())
                .sorted(BigDecimal::compareTo)
                .findFirst().orElse(BigDecimal.ZERO);

        System.out.println("Maximum price from the list is: " + maxPrice);

        BigDecimal minPrice = cars.stream()
                .map(p -> p.getPrice())
                .sorted(BigDecimal::compareTo)
                .findFirst().orElse(BigDecimal.ZERO);

        System.out.println();
        System.out.println("Minimum price from the list is: " + minPrice);

        BigDecimal averagePrice = cars.stream()
                .map(p -> p.getPrice()).reduce((p1, p2) -> p1.add(p2)).orElse(BigDecimal.ZERO);
        System.out.println();
        System.out.println("Average price from the car price list is: " + averagePrice.divide(BigDecimal.valueOf(cars.size())));

        System.out.println();

        BigDecimal maxCapacity = cars.stream()
                .map(p -> p.getEngineCapacity())
                .sorted(BigDecimal::compareTo)
                .findFirst().orElse(BigDecimal.ZERO);

        System.out.println("Maximum car capacity from the list is: " + maxCapacity);

        BigDecimal minCapacity = cars.stream()
                .map(p -> p.getEngineCapacity())
                .sorted(BigDecimal::compareTo)
                .findFirst().orElse(BigDecimal.ZERO);
        System.out.println();
        System.out.println("Minimum car capacity from the list is: " + minCapacity);

        BigDecimal averageCapacity = cars.stream()
                .map(p -> p.getEngineCapacity()).reduce((p1, p2) -> p1.add(p2)).orElse(BigDecimal.ZERO);
        System.out.println();
        System.out.println("Average car capacity from the car list is: " + averageCapacity.divide(BigDecimal.valueOf(cars.size())));

        int maxMileage = cars.stream()
                .map(p -> p.getMileage())
                .sorted(Integer::compareTo)
                .findFirst().orElse(0);
        System.out.println();
        System.out.println("Maximum car mileage from the list is: " + maxMileage);
        int minMileage = cars.stream()
                .map(p -> p.getMileage())
                .sorted(Integer::compareTo)
                .findFirst().orElse(0);
        System.out.println();
        System.out.println("Minimum car mileage from the list is: " + minMileage);
        int averageMileage = cars.stream()
                .map(p -> p.getMileage())
                .reduce((p, q) -> p + q).orElse(0);
        System.out.println();
        System.out.println("Average car mileage from the list is: " + averageMileage / cars.size());


    }

    public List<Car> maxPrices() {
        BigDecimal max = cars.stream().sorted(Comparator.comparing(Car::getPrice).reversed()).limit(1).findFirst().get().getPrice();
        return cars.stream().filter(p -> p.getPrice().compareTo(max) == 0).collect(Collectors.toList());

    }

    public Optional<Car> maxPrice() {

        Optional<Car> op2 = Optional
                .of(cars.stream()
                        .sorted(Comparator.comparing(Car::getPrice).reversed()).findFirst().orElse(null));

        return op2;
    }

    public void checkIfCarHasComponent(String component) {


        System.out.println(cars.stream().allMatch(p -> p.getEquipmentList().contains(component)));

    }

    public List<Car> carsInGivenPriceRange(BigDecimal pr1, BigDecimal pr2) {

        if (pr1.compareTo(pr2) > 0 || pr1.compareTo(BigDecimal.ZERO) < 0 || pr2.compareTo(BigDecimal.ZERO) < 0) {
            return null;
        }


        return cars.stream()
                .filter(p -> p.getPrice().compareTo(pr1) > 0 && p.getPrice().compareTo(pr2) < 0)
                .sorted(Comparator.comparing(Car::getName)).collect(Collectors.toList());
    }

    //dlaczego nie sortuje
    public Map<String, List<Car>> componentsMap() {
        Map<String, List<Car>> map = cars.stream().flatMap(p -> p.getEquipmentList().stream())
                .collect(Collectors.groupingBy(Function.identity())).entrySet().stream().collect(Collectors.toMap(
                        e -> e.getKey(),
                        e -> cars.stream().filter(p -> p.getEquipmentList().contains(e.getKey())).collect(Collectors.toList())
                ));

        map.entrySet().stream().sorted(Comparator.comparingInt(e -> e.getValue().size()));

        return map;


    }

    public void sortComponentsInCarList() {
        List<Car> list = new ArrayList<>();

        for (Car c : cars) {
            c.getEquipmentList().sort(String::compareTo);
            list.add(c);
        }
         cars.stream().forEach(o->o.getEquipmentList().stream().sorted((a,b)->a.compareTo(b)));
        System.out.println(cars);
        /*list = cars.stream().flatMap(p->p.getEquipmentList().stream().sorted((a,b)->a.compareTo(b)))...;*/

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarList carList = (CarList) o;
        return Objects.equals(cars, carList.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

    @Override
    public String toString() {
        return "CarList{" +
                "cars=" + cars +
                '}';
    }


}

