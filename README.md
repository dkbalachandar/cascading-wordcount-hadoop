This is a wordcount program using Cascading Api.

To run this program, follow the below steps,
1. Clone this repo

2. Build the jar by running mvn package

3. Then login as Hadoop user and go to Hadoop directory[/usr/local/hadoop]

4. Create a input text file with some sentences[inputFile.txt]

5. Move that input file to hadoop by running the below command
   bin/hadoop fs -copyFromLocal  cascadingInputFile.txt /wordcount/input/InputFile.txt
   
6. Run the jar 
    bin/hadoop jar cascadingWc-1.0-jar-with-dependencices.jar /wordcount/input/InputFile.txt /wordcount/cascading/output
