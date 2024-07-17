package co.example.resilience4jexamples.controller;

import co.example.resilience4jexamples.model.Stock;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resilience")
@RequiredArgsConstructor
public class ExampleResilienceController {


    @GetMapping("/stocks")
    public Stock stocks() {
        return new Stock("Mac Book Air2", "Apple Inc.", 145.09, 50);
    }

     @PostMapping("/stock")
    public String stock(@RequestBody Stock stock) {
        return "Stock Retrieved";
     }
}
