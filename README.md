## Data Driven Test(DDT) framework.

Data Driven Test(DDT) framework is the framework, where test data or test input is stored separately from the test, and one test case can be executed with different data without any changes in test itself.

The target website is [the internet.herokuapp](http://the-internet.herokuapp.com/).
 
 - The "DataProvider" annotation is used that allows us to pass multiple parameters to a single test in a single execution. Using DataProviders, we can easily pass multiple values to a test in just one execution cycle.
 - Page Object Model pattern is used.
 - Log4j is used for logging events. All logs are saved in the directory named logs (target/logs/appTest.log). 

Automated tests (for chrome and opera browsers):
1. Positive test sample for logging
2. Negative test sample for logging

## Executing the Tests

- Clone the repository:
```shell
git clone https://github.com/ViraHarasymiv/selenium_intro.git
```
- Run all tests:
```shell
mvn clean test
```
- run the logging positive test:
```shell
mvn -Dtest=PositiveLoginTest#logInTest test
```
- run the logging negative test:
```shell
mvn -Dtest=NegativeLoginTest#negativeTest test
```