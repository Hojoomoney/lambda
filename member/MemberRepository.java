package member;

import enums.Messenger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberRepository {

    private static MemberRepository instance;
    Connection connection;

    static {
        try {
            instance = new MemberRepository();
        } catch (SQLException e){
            throw new RuntimeException();
        }
    }
    private MemberRepository() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/adadb",
                "ada",
                "ada");
    }

    public static MemberRepository getInstance(){
        return instance;
    }
    public String test(){
        return "MemberRepository 연결";
    }
    public List<Member> findAll() throws SQLException {
        List<Member> members = new ArrayList<>();
        String sql = "select * from members";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()){
            do{
                members.add(Member.builder()
                        .username(rs.getString("username"))
                        .password(rs.getString("password"))
                        .name(rs.getString("name"))
                        .phone(rs.getString("phone"))
                        .job(rs.getString("job"))
                        .height(rs.getString("height"))
                        .weight(rs.getString("weight"))
                        .build());
            }while(rs.next());

        } else {
            System.out.println("데이터가 없습니다.");
        }

        rs.close();
        pstmt.close();
        return members;
    }

    public String createMemberTable() throws SQLException {
        String sql = "CREATE TABLE Members (\n" +
                "    id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "    username VARCHAR(20) NOT NULL,\n" +
                "    password VARCHAR(20) NOT NULL,\n" +
                "    name VARCHAR(20),\n" +
                "    phone VARCHAR(20),\n" +
                "    job VARCHAR(20),\n" +
                "    height VARCHAR(20),\n" +
                "    weight VARCHAR(20)\n" +
                ")";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.executeUpdate();
        pstmt.close();
        return "회원테이블 생성 성공";
    }

    public String deleteMemberTable() throws SQLException {
        String sql = "DROP TABLE Members";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.executeUpdate();
        pstmt.close();
        return "회원테이블 삭제 성공";
    }

    public Messenger save(Member member) throws SQLException {
        String sql = "INSERT INTO Members (username, password, name, phone, job, height, weight)\n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,member.getUsername());
            pstmt.setString(2,member.getPassword());
            pstmt.setString(3,member.getName());
            pstmt.setString(4,member.getPhone());
            pstmt.setString(5,member.getJob());
            pstmt.setString(6,member.getHeight());
            pstmt.setString(7,member.getWeight());
        if(pstmt.executeUpdate() > 0) {
            pstmt.close();
            return Messenger.SUCCESS;
        } else {
            return Messenger.FAIL;
        }
    }


    public String closeConnection() throws SQLException {
        connection.close();
        return "연결 해제";
    }
}
