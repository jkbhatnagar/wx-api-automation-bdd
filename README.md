# REST API Automation - Java - RestAssured - Cucumber

[![Build Status](https://travis-ci.com/jkbhatnagar/wx-api-automation-bdd.svg?branch=develop)](https://travis-ci.com/jkbhatnagar/wx-api-automation-bdd)

## USAGE

### Travis CI Builds

    https://travis-ci.com/jkbhatnagar/wx-api-automation-bdd/builds

### Run Locally:
 - Pre-requisites: java version 1.9, jdk version 1.9, maven (optional), internet access, 
 - Download or clone the 'develop' branch locally.
 - Run Smoke TC : Running without local maven : 
 
     ```./mvnw clean test -Dcucumber.filter.tags="@SmokeTest"```
 - Run Smoke TC : Running from local maven : 
 
    ```mvn clean test -Dcucumber.filter.tags="@SmokeTest"```

### Reports:
 - Cucumber report is generated and report url is printed at end of the run
 - Report provides detailed scenarios and step execution summary, with passed - failed - skipped results

### Maintenance:
- Don't change RunCucumberTest, cucumber.properties
- Add global constants to src/test/java/utils/UtilConstants.
- Add new Cucumber feature files to src/test/features.
- Add new Step Definition files to src/test/stepdefs.

## TASK LIST

### Completed
- [x] Add Cucumber support
- [x] Add Cucumber Outline support
- [x] Add RestAssured support
- [x] Add Cucumber Report support
- [x] Use Cucumber @Tags to categorize Test Scenarios into @SmokeTest and @RegressionTest
- [x] Read constants and globals from Constants.java or a .properties file

### Pending
- [ ] Add more descriptive comments.
- [ ] Export json and cucumber reports to S3 buckets.
- [ ] Use cucumber-picocontainer to add Dependency Injection to share in-flight test objects between test cases
- [ ] Split Step definition and feature for different services to separate files
- [ ] Create model POJO classes for Success and Failure responses and extract response in the for advanced assertions, path assertions, and sharing objects between in-flight test cases
- [ ] Add assertion failure comments (if required)
- [ ] Add Environment changer so that same code and assertions can be used with different data for different Test Environments (SIT/UAT/PROD)

        https://www.coveros.com/using-dependency-injectors-simplify-code-cucumber/
        http://www.thinkcode.se/blog/2017/04/01/sharing-state-between-steps-in-cucumberjvm-using-picocontainer

- Move common tasks and assertions to utility class

        https://github.com/jaganduraisamy/RestAssured-BDD-Java/blob/master/src/test/java/utilities/Utils.java

## RESOURCE REFERENCES
- Cucumber base

        https://github.com/cucumber/cucumber-java-skeleton

- Samples

        https://github.com/angiejones/restassured-with-cucumber-demo
