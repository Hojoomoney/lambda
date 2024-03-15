package com.rod.api.enums;

import com.rod.api.article.ArticleView;
import com.rod.api.board.BoardView;
import com.rod.api.crawler.CrawlerView;
import com.rod.api.member.MemberView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public enum NavigationOfFunction {
    EXIT("x", i -> {
        System.out.println("EXIT");
        return 0;
    }),
    MEMBER("m", i -> {
        try {
            MemberView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 1;
    }),
    ARTICLE("a", i -> {
        try {
            ArticleView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 1;
    }),
    BOARD("b", i -> {
        BoardView.main();
        return 1;
    }),
    ACCOUNT("o", i -> {
        try {
            ArticleView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 1;
    }),
    CRAWLER("c", i -> {
        try {
            CrawlerView.main(i);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return 1;
    }),
    ERROR("error", i-> {
        System.out.println("ERROR 유효하지 않는 문자입니다.");
        return 1;
    });
    private final String name;
    private final Function<Scanner, Integer> function;

    NavigationOfFunction(String name, Function<Scanner, Integer> function) {
        this.name = name;
        this.function = function;
    }

    public static Integer select(Scanner scan) {

        System.out.println("=== x-Exit " +
                "m-Member " +
                "a-Article " +
                "b-Board " +
                "o-Account " +
                "c-Crawler " +
                "===");
        String msg = scan.next();
        return Stream.of(values())
                .filter(i -> i.name.equals(msg))
                .findAny().orElse(ERROR).function.apply(scan);
    }
}
