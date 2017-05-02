# Query_Spring_Project
-------------------
Demonstrates the capabilities of the Spring MVC web framework and the RESTful web service through query application.
After reviewing this project, you should have a good understanding of what Spring MVC and REST can do and get a feel for how easy it is to use.

In this application you'll see the following in action:

* @Controller
* @RestController
* Mapping Requests
* Obtaining Request Data
* Generating Responses
* Rendering Views
* Type Conversion
* Validation
* Forms
* File Upload
* Exception Handling

To get the code:
-------------------
Clone the repository:

    $ git clone https://github.com/SamiOksanen/Query_Spring_Project.git

If this is your first time using Github, review http://help.github.com to learn the basics.

To run the application:
-------------------	
From the command line with Maven:

    $ cd kysely
    $ mvn tomcat8:run [-Dmaven.tomcat.port=<port no.>] (In case 8080 is busy] 

or

In your preferred IDE such as SpringSource Tool Suite (STS) or IDEA:

* Import kysely as a Maven Project
* Drag-n-drop the project onto the "SpringSource tc Server Developer Edition" or another Servlet 2.5 or > Server to run, such as Tomcat.

Access the deployed web application at: http://localhost:8080/kysely/

Show Queries:
------------------
Returns json data about queris.

* URL:

  http://localhost:8080/kysely/kysymykset/kysymykset.json

* Method:

  `GET` | `POST` | `DELETE` | `PUT`

* Sample Call:

  ```javascript
    $.ajax({
      url: "/users/1",
      dataType: "json",
      type : "GET",
      success : function(r) {
        console.log(r);
      }
    });
  ```

Note:
-------------------
Group project made by:
* Ville Lepistö
* Samuli Nuorteva
* Jimi Nurmi
* Sami Oksanen
* Mikko Puntanen
