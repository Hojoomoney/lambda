package com.rod.api;

import com.rod.api.account.AccountView;
import com.rod.api.article.ArticleView;
import com.rod.api.board.BoardView;
import com.rod.api.crawler.CrawlerView;
import com.rod.api.member.MemberView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("=== x-Exit " +
                    "m-Member " +
                    "a-Article " +
                    "b-Board " +
                    "o-Account " +
                    "c-Crawler " +
                    "===");
            switch (sc.next()){
                case "x":  return;
                case "m": MemberView.main(sc);break;
                case "a": ArticleView.main(sc); break;
                case "b": BoardView.main(); break;
                case "o": AccountView.main(sc); break;
                case "c": CrawlerView.main(sc); break;
            }
        }
    }
}

