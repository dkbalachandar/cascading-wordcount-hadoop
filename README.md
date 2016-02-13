This is a wordcount program using Cascading Api.

To run this program, follow the below steps,
1. Clone this repository

2. Build the jar by running mvn package and copy it into hadoop installed directory[/usr/local/hadoop/userLib]. Provide appropriate file permissions

3. Then login as Hadoop user and go to Hadoop directory[/usr/local/hadoop]

4. Create a input text file with some sentences[inputFile.txt]

5. Copy that file to hadoop by running the below command
   bin/hadoop fs -copyFromLocal  inputFile.txt /wordcount/input/inputFile.txt
   
6. Run the jar 
    bin/hadoop jar userLib/cascading-wordcount-1.0-jar-with-dependencices.jar /wordcount/input/inputFile.txt /wordcount/output


