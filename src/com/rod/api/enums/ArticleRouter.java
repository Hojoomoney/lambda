package com.rod.api.enums;

import com.rod.api.article.ArticleController;
import com.rod.api.article.ArticleView;

import java.util.Scanner;
import java.util.function.Predicate;

public enum ArticleRouter {
    EXIT("x", i -> {
        System.out.println("Article 종료");
        return false;
    });

    private final String name;
    private final Predicate<Scanner> predicate;

    ArticleRouter(String name, Predicate<Scanner> predicate) {
        this.name = name;
        this.predicate = predicate;
    }
}
