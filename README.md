# Algorithms-and-Data-Structures

A java program that will determine if a java class
definition has a perfectly matching curly brackets "{}". 

The input to the program will be
your own program for solving this problem. It reads the program and breakdown
its parts into tokens such as identifiers, keywords, special characters, etc. 

For this task I used the java StringTokenizer to read from the java file and in the process it will
extract the curly brackets (while ignoring everything else). 

The program will use the stack to establish the matching of the enclosing brackets. In addition, use a hashmap to
calculate the frequency of all names and identifiers found in the program. At the end
please print all the found identifiers and their frequencies.
