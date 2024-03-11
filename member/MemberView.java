package com.rod.api.member;

import com.rod.api.enums.MemberRouter;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MemberView {
    public static void main(Scanner sc) throws SQLException {
        MemberController ctrl = new MemberController();
        while(MemberRouter.router(ctrl,sc));
    }
}
