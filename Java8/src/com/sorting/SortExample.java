package com.sorting;

import java.util.*;
import java.util.stream.Stream;
import java.util.Comparator;

public class SortExample {

    public static void main(String[] args) {

        Apple appleOne = new Apple(10, "Red");
        Apple appleTwo = new Apple(5, "Green");
        Apple appleThree = new Apple(20, "Red");
        Apple appleFour = new Apple(35, "Red");
        Apple appleFive = new Apple(15, "Red");
        Apple appleSix = new Apple(2, "Green");


        List<Apple> appleInventory = Arrays.asList(appleOne,appleTwo, appleThree, appleFour, appleFive, appleSix);
        
        appleInventory.forEach(apple -> {
            System.out.println("apple: " + apple.getWeight());

        });

       Collections.sort(appleInventory, new Comparator<Apple>() {
            //@Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight() - o2.getWeight();
            }
        });


        appleInventory.forEach(apple -> {
            System.out.println("sorting apple by weight: " + apple.getWeight());

        });

        Collections.sort(appleInventory, new Comparator<Apple>(){
            public int compare(Apple o1, Apple o2){
                return o1.getColor().compareTo(o2.getColor());
            }

        });

        appleInventory.forEach(apple -> {
            System.out.println("sorting apple by color: " + apple.getColor());

        });

        //Using Java8 concise code
        appleInventory.sort(Comparator.comparing(Apple::getWeight));

        appleInventory.forEach(apple -> {
            System.out.println("sorting apple by weight: " + apple.getWeight());

        });

        //Using Java8 concise code
        appleInventory.sort(Comparator.comparing(Apple::getColor));

        appleInventory.forEach(apple -> {
            System.out.println("sorting apple by color: " + apple.getColor());

        });

    }


}
