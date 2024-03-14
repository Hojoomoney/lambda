package com.rod.api.article;

import java.sql.SQLException;
import java.util.List;

public class ArticleController {
    private ArticleServiceImpl service;

    public ArticleController() {
        service = ArticleServiceImpl.getInstance();
    }

    public List<?> findAll() throws SQLException {
        return service.findAll();
    }
}
