##Framework

* Struts2 ()
* Spring (4.1.6.RELEASE)
* Mybatis ()

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
