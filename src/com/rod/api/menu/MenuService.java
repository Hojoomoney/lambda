package com.rod.api.menu;

import com.rod.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;

public interface MenuService {
    Messenger createMenuTable();

    Messenger removeTable();

    List<?> getMenusByCategory(String category);

    List<?> getItemsByCategory(String category) throws SQLException;
}
