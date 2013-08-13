Requires [Apache Maven](http://maven.apache.org) 3.0 or greater, and JDK 6+ in order to run.

To build, run

    mvn package

To start the app, use the [App Engine Maven Plugin](http://code.google.com/p/appengine-maven-plugin/) that is already included.  Just run the command.

    mvn appengine:devserver

Tp upload the application to production, run the command.

    mvn appengine:upload

To see all the available goals for the App Engine plugin, run

    mvn help:describe -Dplugin=appengine
