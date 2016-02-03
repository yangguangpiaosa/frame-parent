##Framework

* jFinal ()

========
###Start HSQLDB database:

frame-ssh root directory:
```javascript
mvn exec:java -Dexec.mainClass="org.hsqldb.server.Server" -Dexec.args="-database.0  file:target/data/test"
```
start client:
```javascript
mvn exec:java -Dexec.mainClass="org.hsqldb.util.DatabaseManager"
```
or
```javascript
mvn exec:java -Dexec.mainClass="org.hsqldb.util.DatabaseManagerSwing"
```

========
###Run it:
We imagine that your environment is already there, so let's begin.

Move to the directory of project, then
Command Line:
```javascript
mvn clean tomcat7:run
```