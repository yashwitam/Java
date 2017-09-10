package com.demo;


import java.util.*;
import java.util.function.Function;
import java.util.function.IntPredicate;

import static com.demo.DishType.*;
import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) {

        Apple apple1 = new Apple(1,"green", 120);
        Apple apple2 = new Apple(2,"green", 150);
        Apple apple3 = new Apple(3,"green", 160);
        Apple apple4 = new Apple(4,"green", 180);

        //red apples
        Apple apple5 = new Apple(5,"red", 160);
        Apple apple6 = new Apple(6,"red", 180);

        //white apples
        Apple apple7 = new Apple(7,"white", 160);
        Apple apple8 = new Apple(8,"white", 155);
        Apple apple9 = new Apple(9,"white", 100);


        List<Apple> fruitsList = new ArrayList<>();
        fruitsList.addAll(Arrays.asList(apple1,apple2,apple3,apple4,apple5,apple6,apple7,apple8,apple9));

        //Example using method reference -- Example per page 26
        List<Apple> applesList = AppleImpl.filterApples(fruitsList,AppleImpl::isHeavyApple);
        applesList.stream().forEach(apple -> System.out.println(apple.getFruitId()));


        List<Apple> appleListOne = AppleImpl.filterApples(fruitsList,AppleImpl.isAppleGreen());
        appleListOne.stream().forEach(apple -> System.out.println("firstList: "+apple.getFruitId()));

        //Example using inline one time lambdas instead of extracting to method
        List<Apple> appleListTwo = AppleImpl.filterApples(fruitsList,apple -> "red".equalsIgnoreCase(apple.getColor()));
        appleListTwo.stream().forEach(apple -> System.out.println("secondList: "+apple.getFruitId()));

        //Example using Behaviour parameterization - Strategy pattern - Example page 42
        List<Apple> appleListThree = AppleImpl.filterApplesBasedOnPredicate(fruitsList,new AppleWhitePredicate());
        appleListThree.stream().forEach(apple -> System.out.println("thirdList: "+apple.getFruitId()));

        //Example using Behaviour parameterization - Strategy pattern - Example page 42
        List<Apple> appleListFour = AppleImpl.filterApplesBasedOnPredicate(fruitsList,new AppleWhiteAndHeavyPredicate());
        appleListFour.stream().forEach(apple -> System.out.println("appleListFour: "+apple.getFruitId()));



        //Predicate : T -> boolean
        //COnsumer : T -> ()
        //Supplier : () -> T
        //Function : T -> R


        Function<String,Integer> stringLength = s->s.length();
        System.out.println(stringLength.apply("helloworlds"));

        //Use comparator comparing static method to sort apples inventory by weight
        appleListFour.sort(Comparator.comparing(Apple::getWeight));
        appleListFour.stream().forEach(apple -> System.out.println("appleListFour: "+apple.getFruitId()));


        List<Dish> menuList = Arrays.asList(
                new Dish("pork", false, 800, DishType.REDMEAT),
                new Dish("beef", false, 700, DishType.REDMEAT),
                new Dish("chicken", false, 400, DishType.CHICKEN),
                new Dish("french fries", true, 530, DishType.OTHER),
                new Dish("rice", true, 350, DishType.OTHER),
                new Dish("season fruit", true, 120, DishType.OTHER),
                new Dish("pizza", true, 550, DishType.OTHER),
                new Dish("prawns", false, 300, DishType.SEAFOOD),
                new Dish("salmon", false, 450, DishType.SEAFOOD)
        );

        //get all low calorie dishes: low calories = dishes <500 cal
        menuList.stream().filter(d->d.getCalories()<500).forEach(System.out::println);
        System.out.println("-------------------------");

        //get all low calorie dishes sorted by calories
        menuList
                .stream()
                .filter(d->d.getCalories()<500)
                .sorted(Comparator.comparing(Dish::getCalories))
                .forEach(System.out::println);
        System.out.println("-------------------------");

        //get all low calorie dishes sorted by calories AND display thier dishnames ONLY

        menuList
                .stream()
                .filter(d->d.getCalories()<500)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getDishName)
                .forEach(System.out::println);
        System.out.println("-------------------------");

        //get the dishname of first three low calorie dishes sorted by calories
        menuList
                .stream()
                .filter(d->d.getCalories()<500)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getDishName)
                .limit(3)
                .forEach(System.out::println);
        System.out.println("-------------------------");

        //count all dishes having calories < 500
        System.out.println(menuList
                .stream()
                .filter(d->d.getCalories()<500)
                .count());
        System.out.println("-------------------------");
        //get distinct characters of the first three low calorie dish names
        menuList
                .stream()
                .filter(d->d.getCalories()<500)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getDishName).map(s->s.split(""))
                .flatMap(Arrays::stream).distinct()
                .forEach(System.out::println);
        System.out.println("-------------------------");

        //get length of each word in the list
        List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(toList());
        System.out.println("-------------------------");

        //given list of  numbers return its square
        List<Integer> intList = Arrays.asList(1,2,3,4,5);
        intList.stream().map(n->n*n).forEach(System.out::println);

    }

}
