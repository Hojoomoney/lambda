package com.rod.api.article;

import com.rod.api.common.AbstractService;
import com.rod.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ArticleServiceImpl extends AbstractService implements ArticleService{
    private final static ArticleServiceImpl instance = new ArticleServiceImpl();
    private ArticleRepository repository;

    private ArticleServiceImpl() {
        repository = ArticleRepository.getInstance();
    }

    public static ArticleServiceImpl getInstance(){
        return instance;
    }


    @Override
    public Messenger save(Object o) {
        return null;
    }

    @Override
    public List findAll() throws SQLException {
        return repository.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return Optional.empty();
    }

    @Override
    public String count() {
        return null;
    }

    @Override
    public Optional getOne(String id) {
        return Optional.empty();
    }

    @Override
    public String delete(Object o) {
        return null;
    }

    @Override
    public Boolean existById(Long id) {
        return null;
    }
}
