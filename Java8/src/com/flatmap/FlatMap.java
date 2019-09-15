package com.flatmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMap {


    public static void main(String[] args){


        //Given list of words, print disticnt characters in those words
        List<String> wordList = Arrays.asList("Hello", "World", "Java");
        System.out.println(wordList);

        List<String> disctinctCharacters = wordList.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(disctinctCharacters);


        //Extract names of books

        Student student1 = new Student();
        student1.setName("Jack");
        Book b1 = new Book("Java", "Ryan Gosling");
        Book b2 = new Book("Python", "Tom Cruise");
        List<Book> b1List = new ArrayList<>();
        b1List.add(b1);
        b1List.add(b2);
        student1.setBookList(b1List);


        Student student2 = new Student();
        student2.setName("Jack");
        Book b11 = new Book("Kafka", "Chris Hemsworth");
        Book b22 = new Book("AWS", "Henry Cavil");
        List<Book> b2List = new ArrayList<>();
        b2List.add(b11);
        b2List.add(b22);
        student2.setBookList(b2List);

        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);

        List<String> bookNames = studentList.stream()
                                .map(item -> item.getBookList())
                                .flatMap(item -> item.stream())
                                .map(Book::getTitle)
                                .collect(Collectors.toList());
        System.out.println(bookNames);


    }

}
