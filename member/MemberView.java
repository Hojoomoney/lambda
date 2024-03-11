package com.rod.api.member;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MemberView {
    public static void main(Scanner sc) throws SQLException {
        MemberController ctrl = new MemberController();
        System.out.println(ctrl.addUsers());
        while(true){
            System.out.println("[메뉴] x-Exit\n" +
                    " j-회원가입\n" +
                    " 2-로그인\n" +
                    " 3-ID검색\n" +
                    " 4-비번변경\n" +
                    " 5-탈퇴\n" +
                    " ls-회원목록\n" +
                    " 7-이름검색\n" +
                    " 8-직업검색\n" +
                    " 9-회원수\n" +
                    " touch - 테이블생성\n" +
                    " rm - 테이블삭제\n");
            switch (sc.next()){
                case "0" :
                    System.out.println(ctrl.closeConnection());
                    return;
                case "j" :
                    System.out.println(ctrl.join(sc));
                    break;
                case "2" :
                    System.out.println(ctrl.login(sc));
                    break;
                case "3" :
                    System.out.println(ctrl.findUser(sc));
                    System.out.println(ctrl.test());
                    break;
                case "4" :
                    System.out.println(ctrl.changePassword(sc));
                    break;
                case "5" :
                    System.out.println(ctrl.delete(sc));
                    break;
                case "ls" :
                    ctrl.findAll().forEach(System.out::println);
                    break;
                case "7" :
                    System.out.println(ctrl.findUsersByName(sc));
                    break;
                case "8" :
                    System.out.println(ctrl.findUsersByJob(sc));
                case "9" :
                    System.out.println(ctrl.countUsers());
                    break;
                case "touch" :
                    System.out.println(ctrl.createMemberTable());
                    break;
                case "rm" :
                    System.out.println(ctrl.deleteMemberTable());
                    break;
            }

        }
    }
}
