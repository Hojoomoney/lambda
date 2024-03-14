package com.rod.api.enums;

import com.rod.api.account.AccountView;
import com.rod.api.article.Article;
import com.rod.api.article.ArticleView;
import com.rod.api.board.BoardView;
import com.rod.api.crawler.CrawlerView;
import com.rod.api.member.MemberView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum NavigationOfPredicate {

    EXIT("x", i -> {
        System.out.println("EXIT");
        return false;
    }),
    MEMBER("m", i -> {
        try {
            MemberView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    ARTICLE("a", i->{
        try {
            ArticleView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    BOARD("b",i ->{
        BoardView.main();
        return true;
    }),
    ACCOUNT("o",i -> {
        AccountView.main(i);
        return true;
    }),
    CRAWLER("c",i -> {
        try {
            CrawlerView.main(i);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    ERROR("error", i-> {
        System.out.println("ERROR 유효하지 않는 문자입니다.");
        return true;
    });


    private final String name;
    private final Predicate<Scanner> predicate;

    NavigationOfPredicate(String name, Predicate<Scanner> predicate) {
        this.name = name;
        this.predicate = predicate;
    }


    public static Boolean select(Scanner sc){
        System.out.println("=== x-Exit " +
                "m-Member " +
                "a-Article " +
                "b-Board " +
                "o-Account " +
                "c-Crawler " +
                "===");
        String msg = sc.next();
        return Stream.of(values())
                .filter(i -> i.name.equals(msg))
                .findAny().orElse(ERROR).predicate.test(sc);
    }
}
