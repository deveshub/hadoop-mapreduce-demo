# Hadoop MapReduce Demo Program
Sample program to demo word count in Hadoop

## How to generate the jar file? 
### Prerequisites: 
1. JDK 8 with JAVA_HOME pointing to bin location of JDK 
2. Maven 3.3.9 with M2_HOME pointing to maven installation bin director
3. PATH should have both above locations added 
### Steps
1. Open shell or cmd in the root directory where pom.xml is present
2. run `mvn clean install` 
3. The output of this command generates a jar file under target directory. 

## How to make use of this Jar file? 
* Use the following hadoop command to execute 

`hadoop jar word-count-mapreduce-1.1-SNAPSHOT.jar <input-file-hdfs-path> <output-file-path>`
