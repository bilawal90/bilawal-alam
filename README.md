# bilawal-alam

Setting up the environment:

1- Download and install the Java and then set the environment variable.
2- Download and install the Maven and then set its environment variable.
3- Setup pet store swagger Api playgroup and run it locally.
4- Install the script editor i.e. Eclipse.
5- Install the Maven plugin in Eclipse.
6- Download the Code from the GitHub link provided.
7- Import the project in eclipse or run the project from command line.
8- install the Jenkins and configure a pet store smoke test suite job to schedule a test run.


Technology Stack/ Approach

Java: 1.8.0_271.
Maven: Apache Maven 3.6.3.
Rest-Assured 4.3.1.
TestNG 7.1.0.
Maven Plugin needs to install on the Eclipse.
Java to write Code.


Why used Maven:
Maven can add all the dependencies with the required versions required for the project automatically from pom.xml file.
Maven provides a folder skeleton to manage code efficiently.
We can run our maven project from command line and that can be use to integrate with CI/CD tools like Jenkins for build management and scheduling.
Maven can be used for better team collaboration as team mates pulling project from GIT does not have to worry about dependencies versions compatibility.

Why used Rest Assured:
It integrates with TestNG and JUnit seamlessly.
It supports a Given/When/Then test notation, which makes tests human readable.
It removes the need for writing a lot of boilerplate code required to set up an HTTP connection, send a request and receive a response and then parse it for assertions
It is a Java library, integrating it with a continuous integration like Jenkins is very easy specially when combine with TestNG and Junit Framework.
Open Source and good community support.

Why used TestNG:
It is easy to set priorities the test cases when using TestNG framework.
It is easy to set dependencies of test Cases when using TestNG Framework.
It provides Parallel execution, testing can be done on multiple browsers simultaneously by integration it with CI/CD tools.
TestNG can generate reports for the tests execution.
It provides assertions.
Support Data-driven testing using data providers.

Why used java to write code.
This is the programming language i am comfortable with to write code.
Since java is being widely used to write code for test automation so the community support is better.
