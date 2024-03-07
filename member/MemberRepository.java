package member;

import java.sql.*;

public class MemberRepository {
    public void findMembers() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/adadb";
        String userName = "ada";
        String password = "ada";

        Connection connection = DriverManager.getConnection(url, userName, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from board");

        resultSet.next();
        String name = resultSet.getString("name");
        System.out.println(name);

        resultSet.close();
        statement.close();
        connection.close();
    }
}
