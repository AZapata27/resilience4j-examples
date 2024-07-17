package co.example.resilience4jexamples.service;

import co.example.resilience4jexamples.model.Stock;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class EcommerceService {

    private final RestClient restClientEcommerce1;
    private final RestClient restClientEcommerce2;
    public EcommerceService(
            @Qualifier("ecommerce1") RestClient restClientEcommerce1,
            @Qualifier("ecommerce2") RestClient restClientEcommerce2) {


        this.restClientEcommerce1 = restClientEcommerce1;
        this.restClientEcommerce2 = restClientEcommerce2;
    }



    public Stock getStock(){

        return restClientEcommerce1.get()
                .uri("/inventory/stock")
                .retrieve()
                .body(Stock.class);

    }
}
