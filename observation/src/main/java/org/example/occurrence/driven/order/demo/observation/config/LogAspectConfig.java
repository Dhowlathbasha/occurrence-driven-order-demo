package org.example.occurrence.driven.order.demo.observation.config;

import org.example.occurrence.driven.order.demo.observation.aop.AbstractLogAspect;
import org.example.occurrence.driven.order.demo.observation.aop.DefaultLogAspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class LogAspectConfig {

    @Bean
    @ConditionalOnMissingBean
    AbstractLogAspect defaultLogAspect() {
        return new DefaultLogAspect();
    }

}
