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
   exposes a REST endpoint (POST /uploadFile) that the users can upload the file to invoke backend service and return the computed score. Please refer 
   to ./file-upload-score-response.png for screenshot of postman request-response of a sample run.
2. Strategy design pattern is implemented for easy change of file processing and name-scoring algorithms, to accommodate the foreseen changed requirements.
3. The use of Spring properties/configurations/injections allow us to easily implement Strategy pattern and adhere to SOLID principles 
   for better application maintenance.
4. Maven is used as the dependencies management tool. ./pom.xml is the manifest of dependent libraries.
5. Newer Java8 features utilized: try-resource, Optional, Stream, lambda expressions, to take advantages of newer java language features.
6. Java Parallel Stream is utilized to improve data sorting and processing, for multi-core CPUs.
7. For huge data files (e.g. millions of names), Java Parallel Stream will help on computing performance. However, we might get memory issues if data being 
   processed is too large. To relieve memory issues, we can implement some sort of in-memory caching solutions, e.g. redis cache, as a future enhancement.
8. Comprehensive junit/mockito tests have been included to ensure code quality and facilitate future enhancement/maintenance.
9. references used for implementing file uploading endpoint:
	1) https://spring.io/guides/gs/uploading-files/
	2) https://www.callicoder.com/spring-boot-file-upload-download-rest-api-example/

### Assumptions:
1. if there's any problem during file processing and name scoring, exception will be logged, score of -1 will be the returned;
2. if the file doesn't contain any names, score will be 0;
3. In computing score for a name, any non-letter characters (e.g. '.) are ignored.

### Requirements Description:

Create a command line utility that will compute a score for a list of first names.
The list of names will be provided as a text file. The full path to the names file will be specified as a command line argument. The names file will contain a single line of quoted, comma-separated names. A small sample of data can be found at the end of this document and a full sample file (names.txt) is attached.
To score a list of names, you must sort it alphabetically and sum the individual scores for all the names. To score a name, sum the alphabetical value of each letter (A=1, B=2, C=3, etc...) and multiply the sum by the name’s position in the list (1-based).
For example, when the sample data below is sorted into alphabetical order, LINDA, which is worth 12 + 9 + 14 + 4 + 1 = 40, is the 4th name in the list. So, LINDA would obtain a score of 40 x 4 = 160. The correct score for the entire list is 3194. The correct score for the attached names.txt file is 871198282.
Your solution should be submitted as source files only – no complied binaries or jar files are to be submitted.  The code should be syntactically correct and compile without errors. You are encouraged to use any common open source Java libraries that you feel will help; however, you must provide a manifest of dependent libraries as one of the source files.
Your code should be written as if it were part of a real company codebase. As such, it should be optimized for readability and maintainability. Also, you are aware of the following up-coming requirements changes that should factor into your design decisions:
•	Another department will want to use this utility as well, but they have a much more complex name scoring algorithm.
•	This scoring feature will be added to the company's intranet web-app, allowing employees to upload and score files from their desktop.
•	The company will be switching from first names only to both first and last names in the file.

Sample names file data:
"MARY","PATRICIA","LINDA","BARBARA","VINCENZO","SHON","LYNWOOD","JERE","HAI"

  