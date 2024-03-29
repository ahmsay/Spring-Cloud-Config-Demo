# Spring-Cloud-Config-Demo

This demo project uses Spring Cloud Config which allows fetching configuration properties from a centralized location
and change them in run time.

## To Run

- Start the server
- Start the client
- Go to http://localhost:8080/ to see the result that comes from the git repo

## How it works ?

In the config server, a <a href="https://github.com/ahmsay/Spring-Cloud-Config-Demo-Repo">git repository</a> is specified. This can be a local repo or a remote repo. When the config server
is ready, it continuously watches this repo. The properties can be seen from http://localhost:8888/actuator/default.

In the config client, the config server's url is specified. This way it connects to the config server.
http://localhost:8080/ shows the result that comes from the git repo through the config server.

### Changing Properties at Run Time
If you change the git repo and refresh the config server's actuator url (http://localhost:8888/actuator/default), you
can see that it is updated. The same thing does not apply for the config client, though. Because it's not the client's job to
ask the config server "Are you updated ?" continuously. We need to trigger a manual update.

To do this, we can post an empty request to the client's actuator. 
This can be done by Postman or this command from terminal: `curl localhost:8080/actuator/refresh -d {} -H "Content-Type: application/json"`
Now if you refresh http://localhost:8080/, you will see the updated value.
