package co.example.resilience4jexamples.config;

import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import io.github.resilience4j.core.IntervalFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

@Configuration
public class RetryConfiguration {

    @Bean
    public RetryRegistry retryRegistry() {
        RetryConfig retryConfig = RetryConfig.custom()
                .maxAttempts(3)
                .waitDuration(Duration.ofMillis(500))
                .retryExceptions(IOException.class, TimeoutException.class)
                .ignoreExceptions(IllegalArgumentException.class)
                .intervalFunction(IntervalFunction.ofExponentialBackoff(500, 2.0))
                .build();

        RetryConfig retryConfig2 = RetryConfig.custom()
                .maxAttempts(5)
                .waitDuration(Duration.ofMillis(200))
                .retryExceptions(IOException.class, TimeoutException.class, HttpClientErrorException.class)
                .ignoreExceptions(IllegalArgumentException.class, HttpServerErrorException.class)
                .intervalFunction(IntervalFunction.ofExponentialBackoff(200, 2.0))
                .build();

        Map<String, RetryConfig> retryConfigs = new HashMap<>();

        retryConfigs.put("ecommerce", retryConfig);
        retryConfigs.put("payments", retryConfig2);
        
        return RetryRegistry.of(retryConfigs);
    }
}
