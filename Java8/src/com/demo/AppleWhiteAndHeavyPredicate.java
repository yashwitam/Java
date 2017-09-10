package com.demo;

public class AppleWhiteAndHeavyPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight()>150 && "white".equalsIgnoreCase(apple.getColor());
    }
}
