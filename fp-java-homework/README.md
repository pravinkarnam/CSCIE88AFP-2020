## fp-java-homework
This project provides a starter template for the java homework assignments for CSCI-EE88A


The project requires Java 11+, gradle-5.2 . Project is shipped with gradle wrapper . so you should just be able to use ./gradlew
inside this direcory

## Install JDK11
--> You can cd into tools directory `cd tools` 
--> run `.install-jdk.sh`
This should download jdk 11 on to your local machine .
Note: above install command will  also print JAVA_HOME path that can be used in IDE tools
, also try to export to your shell so that gradle uses this java from command line

### Getting started
 Use the following commands to get started with your project

 - Compile: `./gradlew build`
 - create eclipse project files -> ./gradlew cleanEclipe eclipse
 - create ide project files -> `./gradlew cleanidea idea`
 - Run tests: `./gradlew test`
 - Ship this project with just source code and gradle script -> `./gradlew clean assembe srcZip`

### License
Copyright 2020, Dhyan M

Licensed under the Apache License, Version 2.0.
