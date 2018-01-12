Purpose

This Project sorts the orders taken manually in lexicographical order. This is a maven project built using Spring boot. It can be extended to connect to databases by configuring the DatabaseConfig file.

Inputs to run the project

It accepts 2 arguments one input path where the text file that needs to be sorted is given and output path where the sorted results needs to be stored.
The default input file is stored under resources/input.txt
The sorted results are stored in resource/output.txt

How to Run

This is run as a spring boot application just by passing the vm arguments input and output file paths.

1) Navigate to the project root directory
2) Do mvn clean install
3) Run by passing vm args

It can also be run using command line by executing the jar file using the command
1) Navigate to the target directory of the project
 and execute the following command on the terminal
"java -jar gs-spring-boot-0.1.0.jar"
 
 The tests can be run using the following command
 mvn test
 or "mvn clean install" also runs all the tests
 
 To be consumed on the front end or see the working end point on the browser
 type the url "http://localhost:8080/controller"
This returns the list of the orders sorted lexicographically.
 

 Future scope:
 
 This can be extended to connect to databases like mysql by providing the configurations in the config file and implementing repository layer.
 
 
 Assumptions:
 
 The inputs taken from the user are converted to Pizza class which has 2 member variables name and orderTime. It helps to store the data in database and retrive the sorted results back from the database.



 