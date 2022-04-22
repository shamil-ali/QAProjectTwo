# **Hobby Project - Garage Repair Tracker**

# Introduction
The aim of the project was to create a CRUD application for a hobby of choice that encapsulated all of the core modules covered during training.

*OOP language* - Java SE and Spring Boot used to create application

*Project Management* - Jira Software used to organise project tasks

*Database* - MySQL used to store persistent data for the project

*Front-End Development* - CSS and Javascript used in VS Code to create a UI

*Testing* - JUnit Integration testing achieving an acceptable coverage level

# Prerequisites

This application requires Java 1.8 or newer and MySQL Server 5.7+ (local or CGP instance).

* [Java - Install](https://www.oracle.com/java/technologies/downloads/#java8)

* [MySQL - Install](https://dev.mysql.com/downloads/windows/installer/8.0.html)

# Planning

To begin this project, I used a project management software to create a Kanban board. This allowed me to input user stories assigned to their respective epics. This helped structure the format of my project and focus on tasks based on the sprint.

This is a screenshot of my project management board which displays tasks that are completed, in-progress and yet to be started. Each user story has estimate story points and priority assignment.

![Jira](https://i.imgur.com/q9XmZNK.png)

The next step in the design phase was to create a wireframe for the website interface. This would help understand how to write the html code and it's associated css and js code.

![Wireframe](https://i.imgur.com/2CxXjFi.jpg)


# Database

For this project, two separate databases were used. One within the Eclipse IDE which is used for testing (H2).

The other in MySQL to perform the CRUD functions and store the data.

The image below shows the ERD for the database.

![ERD](https://i.imgur.com/LJ06Lmf.png)

# Testing

Integration Tests were carried out for each controller function in order to confirm functionality of the app and check that the coverage of the code was sufficient.

Example of the Create function test is given below:

```
@Test // CREATE
	void testCreate() throws Exception {
		Vehicle testVehicle = new Vehicle(null, "Car", "ABC123", "MOT");
		testVehicle.setId(null);
		String testVehicleAsJSON = this.mapper.writeValueAsString(testVehicle);
		RequestBuilder req = post("/create").contentType(MediaType.APPLICATION_JSON).content(testVehicleAsJSON);
		
		Vehicle testCreatedVehicle = new Vehicle(3, "Car", "ABC123", "MOT");
		String testCreatedVehicleAsJSON = this.mapper.writeValueAsString(testCreatedVehicle);
		
		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkBody = content().json(testCreatedVehicleAsJSON);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);		
	}
```

# Front-End

HTML CSS and JS were used to replicate the wireframe to an extent. The Bootstrap framework was used for the buttons and input tags, as well as the form-control.

Below is the Home Page of the wesbite which displays all repairs in the database using the READ ALL function. This page allows us to redirect to the CREATE / UPDATE and DELETE pages as well as READ the entries by its respective element using a dropdown function.

![Home Page](https://i.imgur.com/wZ9lUeN.png)

The 'Search By' button is a drop down button that allows users to search by a respective input value such as the registration or Vehicle Type.

![Read By](https://i.imgur.com/tAusC6E.png)

This page takes inputs for the constructors of the vehicle and creates an entry in the database, displaying it on the homepage as a listed object.

![Create Page](https://i.imgur.com/TvksoR1.png)

This page takes an additional 'id' input whihc allows users to edit the values of the contructors assigned to that ID.

![Update Page](https://i.imgur.com/BDQR5MB.png)

This page allows users to input an 'id' in order to delete the entry from the database.

![Delete Page](https://i.imgur.com/86OFydW.png)

# Project Management Board

* [Jira](https://shamilali.atlassian.net/jira/software/projects/QAP2/boards/4)

# Built With

* [Spring](https://spring.io/projects/spring-boot)
* [Maven](https://maven.apache.org/)

# Author
## Syed Shamil Ali - [shamil-ali](https://github.com/shamil-ali)
