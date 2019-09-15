package com.exceptions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ExceptionHandlingDemo {

    public static void main(String[] args){
        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6,7,8,9,10,0);

/*      Below throws an NPE
        integerList.forEach(item -> {
            System.out.println(50/item);
        });
*/

        integerList.forEach(listWrapper(i->System.out.println(50/i)));
    }

    static Consumer<Integer> listWrapper(Consumer<Integer> consumer){
        return i ->{
            try {
                consumer.accept(i);
            }catch (ArithmeticException ae){
                System.out.println("Arithmatic Exception Occurred:" + ae);
            }
        };
    }

}
