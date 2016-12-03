all:S
hello=./lib/mina-statemachine-2.0.16.jar:./lib/mina-integration-beans-2.0.16.jar:./lib/mina-transport-apr-2.0.16.jar:./lib/tomcat-jni-9.0.0.M11.jar:./lib/jzlib-1.1.3.jar:./lib/xbean-spring-4.5.jar:./lib/mina-integration-ognl-2.0.16.jar:./lib/slf4j-api-1.7.21.jar:./lib/mina-example-2.0.16.jar:./lib/mina-integration-jmx-2.0.16.jar:./lib/getAllname.java:./lib/result.txt:./lib/javassist-3.20.0-GA.jar:./lib/mina-core-2.0.16.jar:./lib/commons-logging-1.0.3.jar:./lib/spring-2.5.6.SEC03.jar:./lib/ognl-3.1.11.jar:./lib/mina-filter-compression-2.0.16.jar:./lib/jcl-over-slf4j-1.7.21.jar:./lib/mina-http-2.0.16.jar:./lib/mina-integration-xbean-2.0.16.jar:
mina.MinaTimeServer.class mina.TimeHandler.class:./mina/MinaTimeServer.java ./mina/TimeHandler.java
	@javac -classpath .:$(hello) ./mina/MinaTimeServer.java ./mina/TimeHandler.java
S: mina.MinaTimeServer.class mina.TimeHandler.class
	@java -cp .:$(hello) mina.MinaTimeServer

123
