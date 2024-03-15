package com.rod.api.enums;

import com.rod.api.member.Member;
import com.rod.api.member.MemberController;
import com.rod.api.menu.MenuController;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum MemberRouter {
    EXIT("x", i -> {
        System.out.println("MemberView 종료");
        return false;
    }),
    JOIN("joi", i -> {
        try {
            System.out.println(MemberController.getInstance().join(i));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    LOGIN("log", i ->{
        System.out.println(MemberController.getInstance().login(i));
        return true;
    }),
    ID("cat", i ->{
        System.out.println(MemberController.getInstance().findUser(i));
        return true;
    }),
    PASSWORD("ch-pw", i ->{
        System.out.println(MemberController.getInstance().changePassword(i));
        return true;
    }),
    DELETE("rm", i ->{
        System.out.println(MemberController.getInstance().delete(i));
        return true;
    }),
    LIST("ls-a", i ->{
        try {
            MemberController.getInstance().findAll().forEach(System.out::println);;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    NAME("ls-n", i ->{
        System.out.println(MemberController.getInstance().findUsersByName(i));
        return true;
    }),
    JOB("ls-job", i ->{
        System.out.println(MemberController.getInstance().findUsersByJob(i));
        return true;
    }),
    COUNT("cnt", i ->{
        System.out.println(MemberController.getInstance().countUsers());
        return true;
    }),
    TOUCH("mk", i -> {
        try {
            System.out.println(MemberController.getInstance().createMemberTable());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    REMOVE("rm", i -> {
        try {
            System.out.println(MemberController.getInstance().deleteMemberTable());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    ERROR("error", i -> {
        System.out.println("ERROR 유효하지 않는 문자입니다.");
        return true;
    });
    private final String name;
    private final Predicate<Scanner> predicate;

    MemberRouter(String name, Predicate<Scanner> Predicate) {
        this.name = name;
        this.predicate = Predicate;
    }

    public static Boolean router(Scanner scan) throws SQLException {
        MenuController.getInstance().getItemsByCategory("user")
            .forEach(i -> System.out.print(i + " "));
        String name = scan.next();
        return Stream.of(values())
                .filter(i -> i.name.equals(name))
                .findAny().orElse(ERROR).predicate.test(scan);
    }
}
