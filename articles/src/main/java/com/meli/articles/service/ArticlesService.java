package com.meli.articles.service;

import com.meli.articles.domain.Article;
import com.meli.articles.repository.ArticleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@AllArgsConstructor
public class ArticlesService implements IArticlesService{
    private final ArticleRepository articleRepository;

    @Override
    public Article create(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public List<Article> find() {

        List<Article> articles = new ArrayList<>();

        this.articleRepository.findAll().iterator().forEachRemaining(articles::add);

        return articles;
    }

    @Override
    public void delete(String id) {
        this.articleRepository.deleteById(id);
    }

    @Override
    public Article findOne(String id) {
        return this.articleRepository.findById(id).orElse(null);
    }

    @Override
    public Article findByTitle(String title) {
        return this.articleRepository.findArticleByTitle(title);
    }
}
