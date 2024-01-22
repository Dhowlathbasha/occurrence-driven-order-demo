package org.example.occurrence.driven.order.demo.query.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class QuerySideOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(QuerySideOrderApplication.class, args);
    }
}
