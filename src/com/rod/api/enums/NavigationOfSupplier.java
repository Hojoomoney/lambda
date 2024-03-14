//package com.rod.api.enums;
//
//import java.util.Scanner;
//import java.util.function.Consumer;
//import java.util.function.Supplier;
//
//public enum NavigationOfSupplier {
//    EXIT("x", i -> 0),
//    MEMBER("m", i -> 1),
//    ARTICLE("a", i -> 1),
//    BOARD("b", i -> 1),
//    ACCOUNT("o", i -> 1),
//    CRAWLER("c", i -> 1);
//    private final String name;
//    private final Supplier<Scanner> supplier;
//
//    NavigationOfSupplier(String name, Supplier<Scanner> supplier) {
//        this.name = name;
//        this.supplier = supplier;
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
