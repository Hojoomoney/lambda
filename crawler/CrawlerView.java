package crawler;

import member.MemberController;

import java.util.Map;
import java.util.Scanner;

public class CrawlerView {
    public static void main(Scanner sc) {
        CrawlerController ctrl = new CrawlerController();
        while(true){
            System.out.println("[메뉴] 0-종료\n" +
                    " 1-벅스뮤직\n" +
                    " 2-로그인\n" +
                    " 3-ID검색\n" +
                    " 4-비번변경\n" +
                    " 5-탈퇴\n" +
                    " 6-회원목록\n" +
                    " 7-이름검색\n" +
                    " 8-직업검색\n" +
                    " 9-회원수");
            switch (sc.next()){
                case "0" :
                    System.out.println("종료");
                    return;
                case "1" :
                    System.out.println("1-벅스뮤직");
                    Map<String, ?> map = ctrl.findBugsMusic(sc);
                    System.out.println("벅스뮤직 결과 : ");
                    break;
                case "2" :
                    System.out.println("2");
                    break;
                case "3" :
                    System.out.println("3");
                    break;
                case "4" :
                    System.out.println("4");
                    break;
                case "5" :
                    System.out.println("5");
                    break;
                case "6" :
                    System.out.println("6");
                    break;
                case "7" :
                    System.out.println("7");
                    break;
                case "8" :
                    System.out.println("8");
                    break;
                case "9" :
                    System.out.println("9");
                    break;
            }

        }
    }
}
