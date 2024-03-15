package com.rod.api.article;

import java.sql.SQLException;
import java.util.List;

public class ArticleController {
    private static ArticleController instance = new ArticleController();
    private ArticleServiceImpl service;

    public ArticleController() {
        service = ArticleServiceImpl.getInstance();
    }

    public static ArticleController getInstance(){
        return instance;
    }
    public List<?> findAll() throws SQLException {
        return service.findAll();
    }
}
