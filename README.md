# Artstore

## What is it
Inspired by talk Real World Java EE 6 Tutorial by
Bert Ertman bert.ertman@luminis.eu @BertErtman and Paul Bakker paul.bakker@luminis.eu @pbakker

<a href="http://www.youtube.com/watch?feature=player_embedded&v=8E3Ry-6xqj4" target="_blank"><img src="http://img.youtube.com/vi/8E3Ry-6xqj4/0.jpg" 
alt="Paul Bakker" width="240" height="180" border="10" /></a>

[Origin Repo](https://github.com/paulbakker/jfokus)

## Prerequisites
1. java
2. maven
3. wildfly

## Features
* unit tests
* integration tests
* jmeter performance tests
* deployment to AWS

## Test Environment

###### Java

```bash
$ java -version
java version "1.8.0_40"
Java(TM) SE Runtime Environment (build 1.8.0_40-b26)
Java HotSpot(TM) 64-Bit Server VM (build 25.40-b25, mixed mode)
```
###### Maven

```
$ mvn -v
Apache Maven 3.2.1 (ea8b2b07643dbb1b84b6d16e1f08391b666bc1e9; 2014-02-14T09:37:52-08:00)
Maven home: C:\apache-maven-3.2.1
Java version: 1.8.0_40, vendor: Oracle Corporation
Java home: C:\Java\x64\jdk1.8.0_40\jre
Default locale: en_US, platform encoding: Cp1252
OS name: "windows 7", version: "6.1", arch: "amd64", family: "dos"

```

###### Wildfly
* wildfly-10.1.0.Final


## Running
clone the repo

```bash
mvn clean package
```

Run the Arquillian tests:

```bash
mvn clean package -Parquillian-wildfly-remote
```

deploy to wildfly

## TODO
* AWS deployment pipeline
* event sourcing publisher
* 
