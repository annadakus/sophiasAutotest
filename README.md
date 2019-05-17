# Java Autotetsts for Sophia M1

## The following technologies were used for this project:
	• Java 8  
	• [Selenide](https://selenide.org) framework 
	• [Allure](http://allure.qatools.ru) test report 
	• Maven (project management and comprehension tool) (version 3.6.0)
	• Docker
	• Selenoid
	

Install [Java 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)  

Install [Maven](https://maven.apache.org/install.html)

Install [Docker](https://docs.docker.com/install/)  (choose your OS)

[Selenoid](https://aerokube.com/selenoid/latest/)
The fastest way to start Selenoid is to use Configuration Manager.
Download "cm" file from https://github.com/aerokube/cm/releases/tag/1.5.7 (rename the file to be cm, e.g.not cm_windows_386.exe but just cm.exe etc) 

Run the command: 
```
./cm selenoid start --vnc
```
Run ```docker ps -a ```command to see if there is selenoid container.

To install selenoid UI run the command:
```
./cm selenoid-ui start
``` 

## Jenkins configuration

	1) Add "Maven Integration Plugin"
	2) Add "Allure Jenkins Plugin" 

In **Jenkins** task do the following configuration:

	1) Create it as "Freestyle project"
	2) In General configuration choose GitHub project and project URL
	3) Choose "Git" as source code management and add repository URL
	4) Choose "GitHub hook trigger for GITScm polling" as Build Triggers
	5) Choose "Delete workspace before build starts"
	6) In Build drop-down choose “Invoke top-level Maven targets” and in Goals field enter clean test
	7) As Post-Build Actions add Allure report and add target/allure-results path to it
