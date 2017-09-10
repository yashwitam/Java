package com.demo;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AppleImpl {

    public static Predicate<Apple> isAppleGreen(){
        return  apple -> "green".equalsIgnoreCase(apple.getColor());
    }

    public static Predicate<Apple> isAppleHeavy(){
        return apple -> apple.getWeight()>150;
    }

    //-- per page 26 Java8 in action
    public static boolean isHeavyApple(Apple apple){
        return apple.getWeight()>150;
    }

    public static Predicate<Apple> isAppleGreenAndHeavy(){
        return apple -> "green".equalsIgnoreCase(apple.getColor()) && apple.getWeight()>150;
    }

    public static List<Apple> filterApples(List<Apple> fruitsInventory, Predicate<Apple> p){

        return fruitsInventory.stream().filter(p).collect(Collectors.toList());

    }

    public static List<Apple> filterApplesBasedOnPredicate(List<Apple> fruitsInventory, ApplePredicate p) {

        return fruitsInventory.stream().filter(p).collect(Collectors.toList());

    }

}
