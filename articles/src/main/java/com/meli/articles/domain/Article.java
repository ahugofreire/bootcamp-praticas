package com.meli.articles.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Document(indexName = "blog")
@Getter
@Setter
@Data
@AllArgsConstructor
public class Article {
    @Id
    private String id;
    @Field(type = FieldType.Text)
    private String title;

    @Field(type = FieldType.Nested, includeInParent = true)
    private List<Author> authorList;
}
