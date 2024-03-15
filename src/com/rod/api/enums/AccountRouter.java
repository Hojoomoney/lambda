package com.rod.api.enums;

import com.rod.api.account.AccountController;
import com.rod.api.menu.MenuController;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum AccountRouter {
    EXIT("x", i -> {
        System.out.println("Account 종료");
        return false;
    }),
    TOUCH("touch", i ->{
        return true;
    }),
    WITHDRAW("with", i -> {
        AccountController.getInstance().withdraw(i);
        return true;
    }),
    DEPOSIT("depo", i -> {
        AccountController.getInstance().deposit(i);
        return true;
    }),
    BALANCE("balance", i -> {
        AccountController.getInstance().getBalance(i);
        return true;
    }),
    DELETE("rm", i -> {
        AccountController.getInstance().cancelAccount(i);
        return true;
    }),
    ID("cat", i -> {
        System.out.println("id 조회");
        return true;
    }),
    LIST("ls-a", i -> {
        AccountController.getInstance().getAccount().forEach(System.out::println);
        return true;
    }),
    ERROR("error", i -> {
        System.out.println("유효하지 않는 문자입니다");
        return true;
    });


    private final String name;
    private final Predicate<Scanner> predicate;

    AccountRouter(String name, Predicate<Scanner> predicate) {
        this.name = name;
        this.predicate = predicate;
    }

    public static Boolean accountRouter(Scanner scan) throws SQLException {
        MenuController.getInstance().getItemsByCategory("account")
                .forEach(i -> System.out.print(i + " "));
        return (Stream.of(values())
                .filter(i -> i.name.equals(scan.next()))
                .findAny().orElse(ERROR)).predicate.test(scan);
    }
}
