package com.for_each;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ForEach {


    public static void main(String[] args) {

        //ForEach with list example
        //Cmd + Alt + L -- Auto Format

        List<String> strList = new ArrayList<>();
        strList.add("Item1");
        strList.add("Item2");
        strList.add("Item3");
        strList.add("Item4");
        strList.add("Item5");
        strList.add("InvalidItem");

        //print each item in the list
        strList.forEach(item -> System.out.println(item));
        //print each item using method reference
        strList.forEach(System.out::println);


        //conditional check on each item
        strList.forEach(item -> {
            if("Item2".equalsIgnoreCase(item)){
                System.out.println("Item found is: " + item);
            }
        });


        //list stream and filter
        strList.stream().filter(item -> item.contains("Item2")).forEach(System.out::println);

        //stream and filter a list and collect items into new list
        List<String> newList = strList.stream().filter(item -> item.startsWith("Item")).collect(Collectors.toList());
        System.out.println("Size of new List: " + newList.size());

        //Map for each iteration
        Map<Integer, String> carMap = new HashMap<>();
        carMap.put(1, "BMW");
        carMap.put(2, "Honda");
        carMap.put(3, "Merc");
        carMap.put(4, "Tesla");
        carMap.put(5, "Toyota");
        carMap.put(6, "Jaguar");

        carMap.forEach((k, v) -> {
            if(v.contains("Tesla")){
                System.out.println("Position: " + k + " Make: " + v);
            }
        });

        //get even numbered items from list
        List<String> carMakeList = IntStream
                .range(0, strList.size())
                .filter(item -> item%2 ==0)
                .mapToObj(item -> strList.get(item))
                .collect(Collectors.toList());

        System.out.println("List is: " + carMakeList);


        //find indexof element matching "Item3"

        int index = strList.indexOf("Item3");
        System.out.println(index);

        //check if an element is present in a list, if yes return index
        OptionalInt indexElem = IntStream.range(0, strList.size())
               .filter(i -> "Item4".equalsIgnoreCase(strList.get(i)))
               .findFirst();

        System.out.println("Item4 found at index position: " + indexElem.getAsInt());

        List<String> l = strList.stream().filter(item -> item.startsWith("Item")).collect(Collectors.toList());
        System.out.println(l);

        //fetch list of indexes begingning with Item
        List<Integer> indexList =   IntStream.range(0, strList.size())
                .filter(i -> strList.get(i).startsWith("Item"))
                .mapToObj(i -> i)
                .collect(Collectors.toList());

        System.out.println(indexList);

    }
}
