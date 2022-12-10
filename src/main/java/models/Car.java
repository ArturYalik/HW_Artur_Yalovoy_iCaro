package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder

public class Car {

    String location;
    String make;
    String model;
    String year;
    String fuel;
    String seats;
    String carClass;
    String regNumber;
    String price;
}
