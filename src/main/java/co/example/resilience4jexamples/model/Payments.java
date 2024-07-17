package co.example.resilience4jexamples.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "payments")
public class Payments {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String state;

}