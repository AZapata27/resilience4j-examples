package co.example.resilience4jexamples.service;

import co.example.resilience4jexamples.model.Stock;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@Slf4j
public class RetryEcommerceService {

    private final RestClient restClientEcommerce1;
    private final RestClient restClientEcommerce2;

    public RetryEcommerceService(
            @Qualifier("ecommerce1") RestClient restClientEcommerce1,
            @Qualifier("ecommerce2") RestClient restClientEcommerce2) {


        this.restClientEcommerce1 = restClientEcommerce1;
        this.restClientEcommerce2 = restClientEcommerce2;
    }

    @Retry(name = "ecommerce",fallbackMethod = "fallbackEcommerceRetry")
    public Stock getStock(){

        return restClientEcommerce1.get()
                .uri("/inventory/stock")
                .retrieve()
                .body(Stock.class);

    }

    public Stock fallbackEcommerceRetry(Throwable exception){
        log.error("Primary service failed, attempting to use fallback service", exception);

        try {
            return restClientEcommerce2.get()
                    .uri("/inventory/stock")
                    .retrieve()
                    .body(Stock.class);
        }catch (Exception e){
            log.error("Service failed, returning default stock", exception);
            //throw new RuntimeException("Both primary and fallback services failed", e);
            // cache.findLastedStock();

            return new Stock("default-name", "default-company", 0,0);
        }
    }
}
