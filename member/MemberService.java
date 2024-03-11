package member;

import enums.Messenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public interface MemberService {
    String addUsers();
    Member findUser(String username);
    String login(Member member);

    List<?> findUsersByName(String name);

    Map<String, ?> findUsersByNameFromMap(String name);

    String changePassword(Member member);

    List<?> findUsersByJob(String job);
    Map<String, ?> findUsersByJobFromMap(String job);
    Map<String, ?> getUserMap();
    String test();

    Messenger createMemberTable() throws SQLException;

    String deleteMemberTable() throws SQLException;

    String closeConnection() throws SQLException;
}
