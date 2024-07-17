package co.example.resilience4jexamples.service;

import co.example.resilience4jexamples.model.Payments;
import co.example.resilience4jexamples.model.Stock;
import co.example.resilience4jexamples.repository.PaymentsRepository;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@Slf4j
public class RetryPaymentsService {

    private final RestClient restClientPayments;
    private final PaymentsRepository paymentsRepository;

    public RetryPaymentsService(
            @Qualifier("payments") RestClient restClientPayments,
            PaymentsRepository paymentsRepository) {

        this.restClientPayments = restClientPayments;
        this.paymentsRepository = paymentsRepository;
    }

    @Retry(name = "payments",fallbackMethod = "fallbackPaymentsRetry")
    public void postPayment(Payments payments) {

        restClientPayments.post()
                .uri("/inventory/stock")
                .body(payments)
                .retrieve();

    }

    public void fallbackPaymentsRetry(Payments payments,Throwable exception){
        log.error("Primary service failed, attempting to use fallback service", exception);

        try {
            payments.setState("PENDING");
            paymentsRepository.save(payments);
        }catch (Exception e){
            log.error("Service failed, returning default stock", exception);
            throw new RuntimeException("Both primary and fallback services failed", e);
        }
    }
}
