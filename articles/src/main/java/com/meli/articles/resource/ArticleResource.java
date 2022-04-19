package com.meli.articles.resource;

import com.meli.articles.domain.Article;
import com.meli.articles.service.IArticlesService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
public class ArticleResource {
    private final IArticlesService articlesService;

    @PostMapping("/articles")
    public ResponseEntity<?> create(@RequestBody Article article) {
        Article articleCreated = this.articlesService.create(article);
        return ResponseEntity.created(URI.create("/articles/" + articleCreated.getTitle())).body(articleCreated);
    }

    @GetMapping("/articles")
    public ResponseEntity<List<Article>> list() {
        return ResponseEntity.ok().body(this.articlesService.find());
    }

    @DeleteMapping("/articles/{id}")
    public void remove(@PathVariable String id) {
        this.articlesService.delete(id);
    }

    @GetMapping("/articles/{id}")
    public ResponseEntity<Article> findById(@PathVariable String id) {
        return ResponseEntity.ok().body(this.articlesService.findOne(id));
    }

    @GetMapping("/articles/title/{title}")
    public ResponseEntity<Article> findByTitle(@PathVariable String title){
        return ResponseEntity.ok().body(this.articlesService.findByTitle(title));
    }
}
