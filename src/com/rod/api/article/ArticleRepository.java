package com.rod.api.article;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {

    Connection connection;
    private final static ArticleRepository instance;

    static {
        try {
            instance = new ArticleRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArticleRepository getInstance(){
        return instance;
    }

    private ArticleRepository() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/adadb", "ada", "ada");
    }


    public List findAll() throws SQLException{
        List<Article> ls = new ArrayList<>();
        String sql = "select * from articles";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        if(rs.next()){
            do{
                ls.add(Article.builder()
                        .id(rs.getLong("id"))
                        .title(rs.getString("title"))
                        .content(rs.getString("content"))
                        .writer(rs.getString("writer"))
                        .registerDate(rs.getString("register_date"))
                        .build());

            } while(rs.next());
        } else{
            System.out.println("No Data");
        }

        rs.close();
        ps.close();
        connection.close();
        return ls;
    }
}
