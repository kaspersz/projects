package programmingbasics.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Car {
    private String name;
    private BigDecimal price;
    private BigDecimal engineCapacity;
    private int mileage;
    private Color color;
    private List<String> equipmentList;

    public Car(CarBuilder carBuilder) {
        this.name = carBuilder.name;
        this.price = carBuilder.price;
        this.engineCapacity = carBuilder.engineCapacity;
        this.mileage = carBuilder.mileage;
        this.color = carBuilder.color;
        this.equipmentList = carBuilder.equipmentList;
    }


    public static class CarBuilder{
        private String name;
        private BigDecimal price;
        private BigDecimal engineCapacity;
        private int mileage;
        private Color color;
        private List<String> equipmentList;


        public CarBuilder name(String name){
            this.name = name != null && name.matches("[A-Z\\s]+") ? name : null;
            return this;
        }

        public CarBuilder price(BigDecimal price){
            this.price = price != null && price.compareTo(BigDecimal.ZERO)>0 ? price : null;
            return this;
        }

        public CarBuilder engineCapacity(BigDecimal engineCapacity){
            this.engineCapacity = engineCapacity;
            return this;
        }
        public CarBuilder mileage(int mileage){
            this.mileage = mileage >= 0 ? mileage : -1;
            return this;
        }
        public CarBuilder color(Color color){
            this.color = color;
            return this;
        }
        public CarBuilder equipmentList(List<String> equipmentList){


           this.equipmentList = equipmentList;

                return this;
            }




        public Car build(){
            return new Car(this);
        }
    }
}
