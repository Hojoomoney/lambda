package com.rod.api.strategy;

import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public enum WeekendStrategy {
    MONDAY("1", i -> "Monday"),
    TUESDAY("2", i -> "Tuesday"),
    WEDNESDAY("3", i -> "Wednesday"),
    THURSDAY("4", i -> "Thursday"),
    FRIDAY("5", i -> "Friday"),
    SATURDAY("6", i -> "Saturday"),
    SUNDAY("7", i -> "Sunday"),
    WRONG("x", i -> "Wrong");
    private final String name;
    private final Function<String, String> function;

    WeekendStrategy(String name, Function<String, String> function) {
        this.name = name;
        this.function = function;
    }

    public static String execute(Scanner sc) {
        System.out.println("1-7번 입력");
        String day = sc.next();
        return Stream.of(values())
                .filter(i -> i.name.equals(day))
                .findAny().orElse(WRONG).function.apply(day);
    }
}
