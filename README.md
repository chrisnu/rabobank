To run:
`./gradlew bootRun`

To test:
`./gradlew test`

Server runs on port `9090`

Endpoints:
- http://localhost:9090/power-of-attorneys
- http://localhost:9090/power-of-attorneys/0001 (and until 0005)
- http://localhost:9090/credit-cards/1
- http://localhost:9090/debit-cards/2 (and until 5)

Aggregate endpoint using webflux. This endpoint consumes the aforementioned endpoints:
- http://localhost:9090/aggregate

Known missing problems:
- Incomplete unit test. It should cover more classes but unable to proceed due to limited of time
