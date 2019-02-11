Instructions to execute the Code:
1. Code is made using Java language
2. Install JDK  - https://www.oracle.com/technetwork/java/javase/downloads/jdk10-downloads-4416644.html (keep the default directory as it is)
3. Just check in C:/ProgramFiles/Java/jdk if its present then jdk is installed.
4. Add path to environmental variables, so that you can execute it from any of the path location, if not done then you have to store the java file in the bin folder of C:/ProgramFiles/Java/jdk path.
5. For adding path to environmental variables: if you are using Windows then in the cortana write environmental variables straight away, you will get the option as
   'edit the environmental variables'. for Mac, you can go through this - http://www.ntu.edu.sg/home/ehchua/programming/howto/environment_variables.html
6. As I am using windows - mostly all the guidelines will work perfectly on windows, but it will be quite similar in Mac also. Click and open it. Then after opening environmental variables, 
   you will get an option as path. click and new path to it. add the path where jdk is installed. for ex: In default windows it is - C:\Program Files\Java\jdk-10.0.2
7. Now open the command prompt
8. change the current path location to where .java file located with the help of "cd <path where file is located>" example: > cd D:/java
9. run "javac <filename>.java" - this is used to complie the java file and to generate the intermediate byte code. (which can be taken anywhere and executed directly to get the output)
10.run "java <filename>" - this will run the program. example: Dijsktra.java ... then to compile - javac Dijsktra.java ... and then to run - java Dijsktra
11. while running, this is the input we have to follow
	11.a. Enter number of vertex required first question. eg: 5
	11.b. Enter no. of vertices 1 by 1 as asked in the input, when you see something like this : Enter Character 1 of 5.. that means first character then 2 of 5... second char and so on. (Enter in serial order like, abcde, if you expect out the same way)
	11.c. Enter then no. of connections required as such. ex. 6 
	11.d. Enter start node, end node, distance weight as asked in the output. Screenshot of how to enter is shown in report file while showing the working of it. Characters are case sensitive
	11.5. Then you will see adjacency matrix and source defined path, later on any other path you want from the input vertexes to test from another point
	11.6. After it will ask whether you will like to try out any other vertex, if you click n and <enter> then it will stop or else it will ask other char unless you press n for this question.



