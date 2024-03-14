package com.rod.api.article;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ArticleView {

    public static void main(Scanner sc) throws SQLException {
        ArticleController controller = new ArticleController();
        while(true){
            System.out.println("[메뉴] 0-종료\n" +
                    " 1-ID로 글찾기\n" +
                    " 2-제목으로 글찾기\n" +
                    " 3-작성자로 글찾기\n" +
                    " 4-전체 글 불러오기");
            switch (sc.next()){
                case "0" :
                    System.out.println("종료");
                    return;
                case "1" :
                    System.out.println("ID");
                    break;
                case "2":
                    System.out.println("제목");
                    break;
                case "3":
                    System.out.println("작성자");
                    break;
                case "4":
                    System.out.println("전체 글");
                    controller.findAll().forEach(System.out::println);
                    break;
            }
        }
    }
}
