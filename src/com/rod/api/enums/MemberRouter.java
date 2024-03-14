package com.rod.api.enums;

import com.rod.api.member.Member;
import com.rod.api.member.MemberController;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum MemberRouter {
    EXIT("x", i -> {
        System.out.println("MemberView 종료");
        return false;
    }),
    JOIN("j", i -> {
        try {
            System.out.println(MemberController.getInstance().join(i));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    LOGIN("l", i ->{
        System.out.println(MemberController.getInstance().login(i));
        return true;
    }),
    ID("id", i ->{
        System.out.println(MemberController.getInstance().findUser(i));
        return true;
    }),
    PASSWORD("cp", i ->{
        System.out.println(MemberController.getInstance().changePassword(i));
        return true;
    }),
    DELETE("d", i ->{
        System.out.println(MemberController.getInstance().delete(i));
        return true;
    }),
    LIST("ls", i ->{
        try {
            MemberController.getInstance().findAll().forEach(System.out::println);;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    NAME("name", i ->{
        System.out.println(MemberController.getInstance().findUsersByName(i));
        return true;
    }),
    JOB("job", i ->{
        System.out.println(MemberController.getInstance().findUsersByJob(i));
        return true;
    }),
    COUNT("count", i ->{
        System.out.println(MemberController.getInstance().countUsers());
        return true;
    }),
    TOUCH("touch", i -> {
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

    public static Boolean router(Scanner scan){
        System.out.println("[메뉴] x-Exit\n" +
                " j-회원가입\n" +
                " l-로그인\n" +
                " id-ID검색\n" +
                " cp-비번변경\n" +
                " d-탈퇴\n" +
                " ls-회원목록\n" +
                " name-이름검색\n" +
                " job-직업검색\n" +
                " count-회원수\n" +
                " touch - 테이블생성\n" +
                " rm - 테이블삭제\n");
        String name = scan.next();
        return Stream.of(values())
                .filter(i -> i.name.equals(name))
                .findAny().orElse(ERROR).predicate.test(scan);
    }
}
