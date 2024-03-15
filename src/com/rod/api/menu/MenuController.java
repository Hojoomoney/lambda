package com.rod.api.menu;

import com.rod.api.enums.Messenger;
import com.rod.api.member.MemberRepository;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class MenuController {
    private static MenuController instance = new MenuController();
    MenuServiceImpl menuService;

    public MenuController() {
        this.menuService = MenuServiceImpl.getInstance();
    }

    public static MenuController getInstance(){
        return instance;
    }
    public Messenger createMenuTable(){
        return menuService.createMenuTable();
    }
    public Messenger removeMenuTable(){
        return menuService.removeTable();
    }

    public List<?> getMenusByCategory(String category){
        return menuService.getMenusByCategory(category);
    }
}
