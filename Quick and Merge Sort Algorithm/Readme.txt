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
10.run "java <filename>" - this will run the program. example: Sort.java ... then to compile - javac Sort.java... and then to run - java Sort
11. while running, you will find the option to select which algo would you like to run:
    i. 1st option after running will be algorithm select with the help of number key ex. 1 for merge and 2 for quick Sort

    ii. whether you want to enter the input or use the pre defined input ex. 1. for user input 2. pre defined input

        a. If user input selected, then enter the total length you would like to sort and then after hit <enter>, you will get option to enter the numbers, here either
        you can enter different numbers by putting space or hit <enter> after every input. Once you reached the input length, hit <enter> then after output will be generated
        as Array sorted with sorted values and the execution time to sort the input.

        b. If predefined selected, then you will get 3 options as 1. for 1000 input, 2. for 1500 input values, 3. for 2000 input values. Select any number by entering corresponding number 
        and you will get the values printed with the statement displaying number of time the code took to sort the input values [as mentioned numbers are already in the sorted order, main purpose is to analyze the execution time for the best case].

