package com.meli.employee.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.meli.employee.repository")
@ComponentScan(basePackages = { "com.meli.employee"})
public class Config {

    @Bean
    public RestHighLevelClient client() {

        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo(System.getenv("ELASTICSEARCH_HOST"))
                .withBasicAuth(System.getenv("ELASTICSEARCH_USER"), System.getenv("ELASTICSEARCH_PASSWORD"))
                .build();
        return RestClients.create(clientConfiguration).rest();
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return  new ElasticsearchRestTemplate(client());
    }
}
