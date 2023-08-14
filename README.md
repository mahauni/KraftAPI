Kraft Challenge API
-------------------

This is the Kraft API, it is only the routes with the spring framework, and it
has dependency on the KraftService, so to make it work you will need to have the
.jar of the KraftService, and then you can build the .jar of the KraftAPI to be 
deployed in a docker container.

The way this application was created with the intent to have on a docker container, 
so the dockerfile is in this folder to be used.

However, this is a microservice meaning it has a docker compose that will make all the 
microservices run and make sure it can run in most of the systems.

The docker compose file will be stored in the https://github.com/mahauni/KraftChallenge
repo.

This code is possible to be run alone, but it will be most for test purposes.