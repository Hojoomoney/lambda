package com.rod.api;

import com.rod.api.enums.Messenger;
import com.rod.api.enums.NavigationOfFunction;
import com.rod.api.enums.NavigationOfPredicate;
import com.rod.api.menu.Menu;
import com.rod.api.menu.MenuController;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
 //       Messenger msg = MenuController.getInstance().returnMessenger();
//        Menu oneMenu = MenuController.getInstance().returnOneMenu();
//        List<?> allMenu = MenuController.getInstance().returnAllMenu();
//        MenuController.getInstance().createMenuTable();
          Scanner scan = new Scanner(System.in);
//        while(NavigationOfFunction.select(scan) != 0);
//        NavigationOfConsumer.select(scan);
//        NavigationOfSupplier.select(scan);
           while(NavigationOfPredicate.select(scan));
    }
}

