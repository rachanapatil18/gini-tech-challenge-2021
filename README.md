* Time investment: max. 4 hours without an optional challenge

You have a table containing document metadata such as type, serial number and number of pages. 
Your table is heavy, with millions of rows and millions more submitted each day. Serial number is provided by an external client so
documents do not have a serial number when inserted.

Your task is to create a service that will update the missing serial numbers periodically (e.g. once per week). Service should
 * retrieve all the documents without a serial number
 * call the external client endpoint at ${client.api.uri} for each document separately (mock is provided)
 * check the returned processing status and if OK, extract the serial number 
 * persist the serial number for the document

Technical constraints and details:
* Client's API is not very efficient and each call is very heavy, up to several seconds
* Client API only expects document id
* It's planned to deploy multiple instances of your Spring Boot service

#### Bonus optional challenges

Imagine there is another microservice called document-collector where users can add or delete pages to existing documents.
You are not concerned how the service works. All you need to know is that document-collector calls your service to update page count in the database.
Create a REST endpoint that accepts document id and number of added/removed pages (not the total number of pages in the document). 
Update the document count in the database.

`Technical constraints: new endpoint should handle thousands of requests each second as there are several instances of document-collector running.`
 
Optionally cover all your code with tests.


#### Notes

You are encouraged to make arbitrary decisions on details that are not specified. Do not feel pressured to cover all the points.
 It's much better to cover few points and do them well than do half-hearted job on all of them. 
 Feel free to use the provided skeleton project or start from scratch on your own. You can use Maven or Gradle.
 
 
http://localhost:8080/gini-tech/documents
http://localhost:8080/h2-console/login.jsp