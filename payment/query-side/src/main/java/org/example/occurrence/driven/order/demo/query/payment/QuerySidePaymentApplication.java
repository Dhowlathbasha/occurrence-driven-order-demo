package org.example.occurrence.driven.order.demo.query.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class QuerySidePaymentApplication {
    public static void main(String[] args) {
        SpringApplication.run(QuerySidePaymentApplication.class, args);
    }
}
