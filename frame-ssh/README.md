##Framework

========
* SpringMVC (4.1.6.RELEASE)
* Spring (4.1.6.RELEASE)
* Hibernate (4.3.9.Final)

========
Start HSQLDB database:
frame-ssh root directory:
mvn exec:java -Dexec.mainClass="org.hsqldb.server.Server" -Dexec.args="-database.0  file:target/data/test"
start client:
mvn exec:java -Dexec.mainClass="org.hsqldb.util.DatabaseManager"
or
mvn exec:java -Dexec.mainClass="org.hsqldb.util.DatabaseManagerSwing"