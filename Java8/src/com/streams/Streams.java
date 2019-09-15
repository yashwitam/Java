package com.streams;

import java.util.*;
import java.util.stream.Collectors;

public class Streams {

    public static void main(String[] args) {

        //stream and collect list items
        List<String> list1 = Arrays.asList("java", "python", "golang", "nodejs");
        List<String> resultList = list1.stream().filter(line -> !line.isEmpty()).collect(Collectors.toList());
        resultList.forEach(System.out::println);


        List<Car> carList = Arrays.asList(
                new Car("BMW", "Class S", 2019),
                new Car("Tesla", "Model X", 2018),
                new Car("Merc", "Class C", 2019),
                new Car("Camry", "Camry", 2018)

        );

        List<String> carsOf2019 = carList.stream().filter(item -> item.getYear() == 2019).map(Car::getMake).collect(Collectors.toList());
        //Another variation of the above using lambda in map

        //  List<String> carsOf2019 = carList.stream().filter(item -> item.getYear() == 2019).map(car -> car.getMake()).collect(Collectors.toList());
        carsOf2019.forEach(System.out::println);

        List<Car> carsList2018 = carList.stream().filter(item -> item.getYear() == 2018).map(item -> new Car(item.getMake(), item.getModel(), item.getYear())).collect(Collectors.toList());


        carsList2018.forEach(item -> System.out.println(item.getMake()));


        List<Car> carsListSorted = carList.stream()
                .filter(item -> item.getYear() == 2018)
                .sorted(Comparator.comparing(Car::getMake))
                .map(item -> new Car(item.getMake(), item.getModel(), item.getYear()))
                .collect(Collectors.toList());

        carsListSorted.forEach(item -> System.out.println(item.getMake()));


        List<Car> anotherList = carList.stream().map(item -> {

            Car car = new Car();
            car.setMake(item.getMake());
            car.setModel(item.getModel());

            return car;

        }).collect(Collectors.toList());

        anotherList.forEach(item -> System.out.println("Printing Make: " + item.getMake()));

        //streams applied to map
        Map<Integer, List<Car>> yearCarMap = carList.stream().collect(Collectors.groupingBy(Car::getYear));
        yearCarMap.forEach((k, v) -> {
            System.out.println(k + ":");
            v.forEach(item -> System.out.println(item.getMake()));
        });


        //collect list to map
        Map<String, Integer> carMap = carList.stream().filter(item -> item.getYear() == 2018).collect(Collectors.toMap(item -> item.getMake(), item -> item.getYear()));
        System.out.println(carMap.size());

        carMap.forEach((k, v) -> System.out.println("Make: " + k + " Year:" + v));







    }


}
