Here is a simple Spring Boot restful WEB application.
It has three endpoints: /helloworld , /hello and /hellokitty.

Helloworld and hello endpoints call their HelloWorldService, which creates a object containing the desired message. (objects model in HelloWorld.java)

Endpoints act as a ID, so the HelloWorldService maps endpoints with their message, which is passed from the controller.

Hellokitty return a hardcoded image from the web, because no image was attached.

There are also some basic tests, which test each endpoints seperately and one more test, which tests if the HelloWorldService creates and maps objects correctly.

The assignment took me about 2-2.5 hours
