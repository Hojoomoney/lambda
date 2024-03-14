//package com.rod.api.enums;
//
//import java.util.Scanner;
//import java.util.function.Consumer;
//import java.util.function.Function;
//
//public enum NavigationOfConsumer {
//    EXIT("x", i -> 0),
//    MEMBER("m", i -> 1),
//    ARTICLE("a", i -> 1),
//    BOARD("b", i -> 1),
//    ACCOUNT("o", i -> 1),
//    CRAWLER("c", i -> 1);
//    private final String name;
//    private final Consumer<Scanner> consumer;
//
//    NavigationOfConsumer(String name, Consumer<Scanner> consumer) {
//        this.name = name;
//        this.consumer = consumer;
//    }
//
//    public static void select(Scanner scan) {
//        System.out.println("=== x-Exit " +
//                "m-Member " +
//                "a-Article " +
//                "b-Board " +
//                "o-Account " +
//                "c-Crawler " +
//                "===");
//        String msg = scan.next();
//    }
//}
