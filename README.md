# Rabobank
Assignment for Rabobank task

Note for reviewer:
- My initial understanding of the exercise was to re-create power of attorney service. 
That explains h2 database implementation, entities and repositories.
I realized this a little midway but the "focus on code" part of the hint made me to proceed
- I implemented the call aggregation calls to my own version of power of attorney service on [AggregationController.java](https://github.com/chrisnu/rabobank/blob/master/src/main/java/com/rabobank/chris/api/AggregationController.java)

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

Aggregate endpoint:
- http://localhost:9090/aggregate

What's implemented:
- Making use of JPA
- Entity to DTO transformation
- 404 error handling
- Unit test
- Spring reactor

I am aware that there are things that missing such as other errors handling. It was not implemented because of time limitation 
