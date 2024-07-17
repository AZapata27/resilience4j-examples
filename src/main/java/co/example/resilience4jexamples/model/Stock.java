package co.example.resilience4jexamples.model;

public record Stock(String name,
                    String company,
                    double price,
                    int quantity) {
}

