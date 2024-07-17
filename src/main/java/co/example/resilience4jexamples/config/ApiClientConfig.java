package co.example.resilience4jexamples.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class ApiClientConfig {

    @Bean("ecommerce1")
    public RestClient restTemplateEcommerce1() {

        return RestClient.builder()
                .baseUrl("http://localhost:8080")
                .build();
    }

    @Bean("ecommerce2")
    public RestClient restTemplateEcommerce2() {

        return RestClient.builder()
                .baseUrl("http://localhost:8081")
                .build();
    }

    @Bean("payments")
    public RestClient restTemplatePayments() {

        return RestClient.builder()
                .baseUrl("http://localhost:8082")
                .build();
    }
}
