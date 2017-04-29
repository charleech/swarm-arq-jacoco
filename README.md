# swarm-arq-jacoco
Generate the jacoco coverage report for wildfly-swarm with arquillian

## The issue is
>The swarm and arquillian are worked together successfully, but during the site
>generation, the jacoco reports as 0% code coverage.

## To build

Just simply execute the following command.

> mvn clean install site

## The investigation

1. The jacoco exec files are generated for both unit test and integration test
2. During maven execution, both of unit test and integration test are executed..
3. The jacoco is able to produce the unit test coverage report properly. 
4. Only the integration test coverage which is reported as 0%.

This means the project configuration may not be an issue.