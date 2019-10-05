# Selenium test on interface and selenium grid

Sample project of Selenium tests using interfaces at Page Object Model

There is one test of the helion.pl website in the project. To run the test you must use command such as:
* mvn clean test -Dtest=SearchHelionSmokeTest -Driver=firefox

  * to run test on local machine in firefox browser
  
* mvn clean test -Dtest=SearchHelionSmokeTest -Driver=chrome

  * to run test on local machine in chrome browser
  
* mvn clean test -Dtest=SearchHelionSmokeTest -Driver=remoteChrome

  * to run test on selenium grid in chrome browser
  
* mvn clean test -Dtest=SearchHelionSmokeTest -Driver=remoteFirefox

  * to run test on selenium grid in firefox browser
  
* mvn clean test -Dtest=SearchHelionSmokeTest -Driver=remoteOnLocalhost

  * to run test remote on localhost in chrome browser


To run Selenium Grid, run the "docker-compose up" command in terminal
