package co.example.resilience4jexamples.repository;

import co.example.resilience4jexamples.model.Payments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentsRepository extends JpaRepository<Payments, Long> {
}