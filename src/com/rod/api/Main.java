package com.rod.api;

import com.rod.api.enums.NavigationOfFunction;
import com.rod.api.enums.NavigationOfPredicate;
import com.rod.api.menu.MenuController;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MenuController.getInstance().createMenuTable();
//          Scanner scan = new Scanner(System.in);
//        while(NavigationOfFunction.select(scan) != 0);
//        NavigationOfConsumer.select(scan);
//        NavigationOfSupplier.select(scan);
//        while(NavigationOfPredicate.select(scan));
    }
}

