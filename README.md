# GSB-Pratical-Tests

This Repository contains all files related to the two pratical tests that you can find on this repository.

# First Test - Teste java 1 portugues.pdf

The file Result.java contains the resolution to the given problem. 

# Second Test - Java Practical Test.pdf

The folder named "Application" contains all the files for the API and for the client side (front end) and server side.

The folder inside the Application folder named "Librarie" (it was suppose to be libraries, but for some reason i forgot the s), contains the library gson, the google library for java to handle json file. I used it to create a json object from a string, to use it as a response on the server side.

The folder inside the Application folder named "crud-rest-api" it is the server side code. It was written on Java 11 using spring boot. There's not much about it, it is a simple api that has only one entity, that is users, and it has all the crud operations to this entity.

The folder inside the Application folder named "crudApp" contains the client side code. It was written using angular, and it was generated with Angular CLi 14.1.3 . To build the front end, i used a Bootstrap snippet in order to save some time. This snippet can be found on the following link https://www.bootdey.com/snippets/view/Contacts-Grid-Cards and it has MIT license, if i recall, so it can be used.

The App is supposed to be hosted on the AWS on the following link (if i remember there was no policy to restrict access) - http://crudappng.s3-website-us-east-1.amazonaws.com, but for some reason the API is returning 502. 
