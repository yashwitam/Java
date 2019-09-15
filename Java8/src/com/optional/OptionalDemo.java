package com.optional;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class OptionalDemo {


    public static void main(String[] args){

        Invoice invoice = new Invoice("invoice-id-123");
        Order order = new Order();
        order.setOrderId("order-id-1234-456");
        order.setInvoice(invoice);

        User user = new User();
        user.setUserName("Jack Ma");
        user.setOrder(order);

        Optional<User> optUser = Optional.ofNullable(user);

        Optional<String> invoiceId = optUser.map(User::getOrder)
                                            .map(Order::getInvoice)
                                            .map(Invoice::getInvoiceId);

        System.out.println("Invoice id is: " + invoiceId.get());


        Invoice invoice2 = new Invoice("invoice-id-123");
        Order order2 = new Order();
        order2.setOrderId("order-id-1234-456");
        order2.setInvoice(null);

        User user2 = new User();
        user2.setUserName("Jack Ma");
        user2.setOrder(order2);

        Optional<User> optUser2 = Optional.ofNullable(user2);

        Optional<String> invoiceId2 = optUser2.map(User::getOrder)
                .map(Order::getInvoice)
                .map(Invoice::getInvoiceId);

//        System.out.println("Invoice2 id is: " +invoiceId2.get()); gives NPE as invoiceId2 is Optional.empty
        invoiceId2.ifPresent(System.out::println);

    }

}
