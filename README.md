# Anagram Solver Project

This project provides a very simple solution to check if 2 Strings are anagrams of each other.

In order to run this project, the following is required:

1. [Maven](https://maven.apache.org/download.cgi).
2. Java 17
   [SDK](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
3. Configure the file `/java/resources/anagram.txt` with the following format:
```text
Anagram 1 = Anagram 2
```

### Run the project
- Import the project to your preferred IDE. No specific IDE is required since it is using Maven.
- Run a `mvn install` to download the dependencies. Since it is a very simple solution, it is currently only 
using `JUnit5`. 
```
mvn install
```
This will also generate a jar file with all the dependencies which we will run once
it has been created.
- Run the `Main` method in `AnagramValidatorApplication.java` by running
```
mvn exec:java
```
- Alternatively, you can run the `main` method in `Application.java` in your chosen IDE, e.g. `IntelliJ`

## Algorithm

This application validates that two strings are anagrams or not based on the [anagram definition](https://en.wikipedia.org/wiki/Anagram)

- Opens the `anagrams.txt` file
- Extracts the 2 Strings.
- It throws an error if the file is not properly setup.
- Converts the strings to lower case characters. This takes some time but improves memory.
- Iterates over the characters of the first String to count how many occurrences of a letter exist in the String.
- Iterates over the characters of the second String to substract the existing count of each letter in the String.
- If all the elements in the array are 0 then is a valid anagram. Otherwise is not.
- Special characters like comma, colons, semicolons, etc. are ignored. 


## Valid anagrams

Here is a website where one can find a lot of valid (and winning) anagrams:

[Anagrammy Award Winners - 2020](https://www.anagrammy.com/winners/2020)

### Tests

Tests are under the `/src/test` folder and can be run using the IDE or by executing:
```
mvn test
```