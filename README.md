# occ-name-score-spring-boot
Spring boot app for occ name score coding exercise

### Getting Started
build the JAR file
```shell
$ ./mvnw clean package
```

### Getting Started
build the JAR file
```shell
$ ./mvnw clean package
```

then run the JAR file, as follows:
```shell
java -jar target/name-score-0.0.1-SNAPSHOT.jar <Input file path/name> (e.g.   ./src/main/resources/all-names.txt)
```

### Running tests

```shell
$ ./mvnw test
```

### Design/Implementation notes:

1. The executable jar file created as above can be used as the command line utility tool as required. It also starts up a spring boot application that 
   exposes a REST endpoint (POST /uploadFile) that the client can upload the file to invoke backend service and return the computed score. Please refer 
   to ./file-upload-score-response.png for screenshot of postman request-response.
2. Strategy design pattern is implemented for easy change of file processing and name-scoring algorithms, to accommodate the foreseen changed requirements.
3. The use of Spring properties/configurations/injections allow us to easily implement Strategy pattern and adhere to SOLID principles 
   for better application maintenance.
4. maven is used as the dependencies management tool. ./pom.xml is the manifest of dependent libraries.
5. Newer Java8 features utilized: try-resource, Optional, Stream, lambda expressions, to take advantages of newer java language features.
6. Comprehensive junit/mockito tests have been included to ensure code quality and facilitate future enhancement/maintenance.
7. references used for implementing file uploading endpoint:
	1) https://spring.io/guides/gs/uploading-files/
	2) https://www.callicoder.com/spring-boot-file-upload-download-rest-api-example/

### Assumptions:
1. if there's any problem during file processing and name scoring, exception will be logged, score of 0 will be the returned;
2. if the file doesn't contain any names, score will be 0;
3. In computing score for a name, any non-letter characters are ignored.

  