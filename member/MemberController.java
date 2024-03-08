package member;

import enums.Messenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MemberController {
    MemberServiceImpl memberService;
    public MemberController(){
        this.memberService = MemberServiceImpl.getInstance();
    }

    public String test(){
        return memberService.test();
    }
    public Messenger join(Scanner sc) throws SQLException {
        System.out.println("ID, 비번, 이름, 전화번호, 직업, 키, 몸무게를 순서대로 입력하세요.");
        memberService.save(Member.builder()
                                        .username(sc.next())
                                        .password(sc.next())
                                        .name(sc.next())
                                        .phone(sc.next())
                                        .job(sc.next())
                                        .height(sc.next())
                                        .weight(sc.next())
                                        .build());
        return Messenger.SUCCESS;
    }
    public String login(Scanner scan){
        System.out.println("아이디와 비밀번호를 입력하세요.");
        String msg = memberService.login(Member.builder()
                                        .username(scan.next())
                                        .password(scan.next())
                                        .build());
        return msg;
    }
    public String addUsers(){
        String msg = MemberServiceImpl.getInstance().addUsers();
        return msg;
    }
    public Member findUser(Scanner scan){
        System.out.println("검색할 아이디를 입력하세요");
        return memberService.findUser(scan.next());
    }
//    public List<?> getUserList() throws SQLException {
//        return memberService.getUserList();
//    }
    public String countUsers(){
        return memberService.count();
    }

    public List<?> findUsersByName(Scanner sc) {
        return memberService.findUsersByName(sc.next());
    }

    public String changePassword(Scanner sc) {
        System.out.println("현재 아이디와 변경할 비밀번호를 입력해주세요.");
        String msg = memberService.changePassword(Member.builder()
                                                    .username(sc.next())
                                                    .password(sc.next())
                                                    .build());
        return msg;
    }

    public String delete(Scanner sc) {
        System.out.println("탈퇴하실 회원정보의 아이디와 비밀번호를 입력해주세요.");
        return memberService.delete(Member.builder()
                                                .username(sc.next())
                                                .password(sc.next())
                                                .build());
    }

    public List<?> findUsersByJob(Scanner sc) {
        return memberService.findUsersByJob(sc.next());
    }

    public String createMemberTable() throws SQLException {
        return memberService.createMemberTable();
    }

    public String deleteMemberTable() throws SQLException {
        return memberService.deleteMemberTable();
    }

    public List<Member> findAll() throws SQLException {
        return memberService.findAll();
    }

    public String closeConnection() throws SQLException {
        return memberService.closeConnection();
    }
}
