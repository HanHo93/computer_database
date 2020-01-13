# Computer Database Introduction

This is my project for doing web automation testing with selenium + java + testNG on maven. This project tests some of the functionalities of the computer database website. (http://computer-database.herokuapp.com/)


# Running these tests

♫ Prerequisites:
-  Java JDK 1.8
- Apache Maven 3.5+ (Follow this guide to install maven: https://mkyong.com/maven/how-to-install-maven-in-windows/)
- IntelliJ IDE (Community)
- Chrome, Firefox, IE latest version

♫ Select browser/ test classes to run:
- The tests are run on Chrome by default.
- If you want to run on another browser( Firefox, Internet Explorer). Please select test/java/resources/run.xml and edit browser parameter from "chrome" to "firefox" or "ie".
- And of course you can change the class test you want to run by replacing the class test from this line: 
        <class name="TestScript.AddComputerTest"/>

♫ Run tests:
1. Right click on the run.xml, select "Run .../srctest/java/resources/run.xml"
2. After finishing running, expand "log" folder to get the log file.
Refer this instruction: https://ttprivatenew.s3.amazonaws.com/pulse/myhanspkt2-gmail/attachments/12278635/TinyTake+by+MangoApps-12-01-2020-11-53-13.mp4
