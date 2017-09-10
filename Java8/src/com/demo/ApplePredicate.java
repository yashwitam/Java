package com.demo;

import java.util.function.Predicate;

@FunctionalInterface
public interface ApplePredicate extends Predicate<Apple> {
    public boolean test(Apple apple);

}
