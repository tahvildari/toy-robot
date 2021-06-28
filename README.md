# Toy Robot coding challange 

- The application is a simulation of a toy robot moving on a square tabletop, of dimensions 5 x 5 units.
- There are no other obstructions on the table surface.
- The robot is free to roam around the surface of the table but must be prevented from falling to destruction. Any movement that would result in the robot falling from the table must be prevented, however further valid movement commands must still be allowed.
Create an application that can read in commands of the following form:

- PLACE X,Y,F 
- MOVE
- LEFT
- RIGHT
- REPORT
- EXIT

PLACE will put the toy robot on the table in position X, Y and facing 
NORTH, SOUTH, EAST or WEST. 

The origin (0,0) can be considered to be the SOUTHWEST most corner.

MOVE will move the toy robot one unit forward in the direction it is currently facing.

LEFT and RIGHT will rotate the robot 90 degrees in the specified direction without changing the position of the robot.

REPORT will announce the X, Y and F of the robot.

EXIT terminates the application.
### Constraints:
- The application reads the input commands from the console
- The robot that is not on the table can choose the ignore the MOVE, LEFT, RIGHT
and REPORT commands.
- The robot must not fall off the table during movement. This also includes the initial
placement of the toy robot.
- Any move that would cause the robot to fall must be ignored.
- It is not required to provide any graphical output showing the movement of the toy
robot.

Plain input Examples:

* PLACE 0,0,NORTH
MOVE
REPORT

Output: 0,1,NORTH


* PLACE 0,0,NORTH
LEFT
REPORT

Output: 0,0,WEST

* PLACE 1,2,EAST
MOVE
MOVE
LEFT
MOVE
REPORT

Output: 3,3,NORTH

* MOVE
REPORT

Output: ROBOT MISSING

# Notes:
- All commands will be ignored until a valid PLACE command.
- The robot can be re-PLACEd at any time.
- Any number of REPORT commands are allowed.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.
See deployment for notes on how to deploy the project on a live system.

### Prerequisites

You need to install java JDK V1.8.x and Maven 3.8.x installed on your machine.

```
> java -version
java version "1.8.0_191"

> mvn -v
Apache Maven 3.8.1

```

### Build the project
First, extract the compressed project files in a directory, For example, 'c:\toy-robot'.

Open a command prompt by typing the 'cmd' command and go to the project directory by using the 'cd' command.
```
cd c:\toy-robot
```
 
To build the project, you need to run the following command in the command prompt.

```
mvn clean install
```
The executable jar file will be created inside the target directory of the project. 
For example c:\toy-robot\target\toy-robot-0.0.1-SNAPSHOT.jar 

To run the application, run the following command: 

```
java -jar c:\toy-robot\target\toy-robot-0.0.1-SNAPSHOT.jar
```
or you can enter into the target directory and run the jar file:
```
> cd c:\toy-robot\target\
> java -jar toy-robot-0.0.1-SNAPSHOT.jar
```
this message will appear at the end of the application startup process:
``Please enter the position of the robot by using 'PLACE X, Y, F' command :
``

## Running the tests

To run the test please run this command:

``mvn test``


## Built With
* [Java 8](https://docs.oracle.com/javase/8/) - Java 1.8 JDK
* [Junit](https://junit.org/junit4/) - Unit test framework
* [Mokito](https://site.mockito.org/) - Mock test framework
* [Maven](https://maven.apache.org/) - Dependency Management

## Design
The application designed in the way that covers all the business requirements and is flexible for any further changes while keeping the solution simple.
The **Command** design pattern is chosen for creating the toy robot application. 

The command pattern is a behavioural design pattern in which an object is used to encapsulate all information needed to perform an action or trigger an event at a later time.

For each function of the robot application, there is a Command object that has two main methods to validate and execute the business function.

There is a command processor that receives the submitted command and tries to call the validate() method at the first step.
If the validation result is fine, then call the execute() method from the received command. 

Each command has its validation and execution logic but if there is any shared and reusable logic between commands, that logic can be
moved to the AbstractCommand class to reduce any boilerplate codes.

Any cross-cutting functionality like logging, saving tracking of the robot movement,... can be added to the command processor and as a result
will be applied to all of the received commands.

The table dimensions are kept in the ``Table`` entity class and can be initialised at start-up. Therefore, the application can
work with different table sizes instead of having hard-coded dimensions.

Each Command encapsulated the validation rules and the functionality and it makes the design more flexible in case of implementation and testing 

There is a position service which is responsible for keeping the robot's position. In addition, it calculates the next movement of the robot based on the received command. 
This service easily can be modified to keep track of more than one robot in the table which is out of the scope of the current task.
      
Note: Instead of having the message ```Output: 3,3,NORTH``` in the output, I changed it to ```The Command 'MOVE' executed. Current position is {x=3, y=3, face=SOUTH}``` to make it more readable and user-friendly.                                                                         
## Versioning

We use [SemVer](http://semver.org/) for versioning. 

## Authors

* **Enayat Tahvildari** 

