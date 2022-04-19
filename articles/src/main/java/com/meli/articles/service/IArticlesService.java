package com.meli.articles.service;

import com.meli.articles.domain.Article;

import java.util.List;

public interface IArticlesService {
    public Article create(Article article);
    public List<Article> find();
    public void delete(String id);
    public Article findOne(String id);
    public Article findByTitle(String title);
}
