package org.example.occurrence.driven.order.demo.observation.config;

import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.aop.ObservedAspect;
import org.example.occurrence.driven.order.demo.observation.aop.AbstractObserveAroundMethodHandler;
import org.example.occurrence.driven.order.demo.observation.aop.DefaultObserveAroundMethodHandler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class ObserveConfiguration {

    @Bean
    @ConditionalOnMissingBean(AbstractObserveAroundMethodHandler.class)
    AbstractObserveAroundMethodHandler observeAroundMethodHandler() {
        return new DefaultObserveAroundMethodHandler();
    }

    @Bean
    @ConditionalOnMissingBean(ObservedAspect.class)
    ObservedAspect observedAspect(ObservationRegistry observationRegistry) {
        return new ObservedAspect(observationRegistry);
    }

}
