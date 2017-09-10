package com.demo;

public class AppleWhitePredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return "white".equalsIgnoreCase(apple.getColor());
    }
}
