# Resilience4j Examples

This repository contains practical examples of how to implement fault tolerance in Java applications using the [Resilience4j](https://resilience4j.readme.io/) library. Resilience4j provides several resilience patterns such as Circuit Breaker, Retry, Rate Limiter, Bulkhead, Time Limiter, and more.

## Description

Resilience4j is a fault tolerance library designed to handle failures in distributed systems and microservices. This project includes a series of examples that demonstrate how to apply these patterns to improve the resilience and robustness of applications.

## Project Structure

- **circuit-breaker**: Examples of how to implement Circuit Breaker to handle persistent failures in external services.
- **retry**: Examples of how to implement retry policies to handle transient failures.
- **rate-limiter**: Examples of how to limit the rate of requests to critical services.
- **bulkhead**: Examples of how to isolate resources and limit concurrency in services.
- **time-limiter**: Examples of how to set time limits for calls to external services.
- **cache**: Examples of how to implement caching to improve performance and availability.
- **fallback**: Examples of how to implement fallback methods to handle failures.
- **metrics-monitoring**: Examples of how to configure metrics and monitoring for resilience.

## Installation

1. Clone this repository:
    ```sh
    git clone https://github.com/AZapata27/resilience4j-examples.git
    ```

2. Navigate to the project directory:
    ```sh
    cd resilience4j-examples
    ```

3. Import the project into your favorite IDE (IntelliJ IDEA, Eclipse, etc.).

4. Build the project with Maven:
    ```sh
    mvn clean install
    ```

## Running Examples

Each directory contains specific examples for a resilience pattern. You can run each example individually by navigating to the corresponding directory and running the main class.

For example, to run a Circuit Breaker example:

## Contributions

Contributions are welcome. If you want to add more examples or improve the existing ones, please open an issue or a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Additional Resources

- [Resilience4j Documentation](https://resilience4j.readme.io/)
- [Resilience4j Guide on Baeldung](https://www.baeldung.com/resilience4j)

---

Thank you for visiting this repository! We hope these examples help you implement resilience patterns in your Java applications.
