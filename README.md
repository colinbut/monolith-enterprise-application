# Enterprise Application : Snowman

## Table of Contents

- [Preamble](#preamble)
- [Uber Jar](#uber-jar)
- [Embedded Jetty](#embedded-jetty)
- [Database Migration](#database-migration)
- [Scalability](#scalability)
- [Clustering](#clustering)
- [Failover & Recovery](#f&r)
- [Disaster & Recovery](d&r)

This project aims to provide a skeleton example of a common traditional (perhaps now viewed as legacy) enterprise
like application. 

_Note, this project is not a complete application, it only serves the purpose of providing a variety of specific
demonstrations only._

#### <a name="preamble"></a>Preamble

Snowman is an fictional enterprise scale/ready employee management system (EMS). This project uses Snowman to 
demonstrate the characteristics of a stereotypical backend enterprise application.
  
![Image of a Snowman](etc/snowman.jpeg)  
  
Snowman exposes its functionality via REST (-like) endpoints. Essentially this is a 
backend web service.

#### <a name="uber-jar"></a>Uber Jar

As part of the deployment process, Application is packaged up in a "uber" runnable executable jar.
This jar contains all dependencies copied in. And can be easily run from a command line with:

```java
java -jar target/Snowman.jar
```

This whole process is achieved by the [Maven Shade Plugin](https://maven.apache.org/plugins/maven-shade-plugin/)

#### <a name="embedded-jetty"></a>Embedded Jetty

Rather than deploying the application in either a full blown JavaEE application server (JBoss/Wildfly, Websphere, Weblogic, Geronimo etc)
or a Web/JSP Container (Tomcat, Jetty, UnderTow), we embed a HTTP listener into the application in the form of
"Embedded Jetty". 

All dependencies are bundled/packaged together in an Uber jar file so it works. This means it is therefore
wasn't necessary required to be provided with specific JavaEE dependencies from the JavaEE platform.

#### <a name="database-migration"></a>Database Migration

Database updates are implemented using patches via changesets with a database migration tool in [liquibase](http://www.liquibase.org/)
to execute them in order to 'patch' up the database.

To run, execute the maven liquibase plugin by...

Running update patches:

```xml
mvn liquibase:update
```

And to rollback those particular patches:

```xml
mvn liquibase:rollback -Dliquibase.rollbackCount=1
```

### <a name="scalability"></a>Scalability

1. Horizonantal Scalability
2. Vertical Scalability

#### Horizontal Scalability a.k.a "Scaling Out"

To support horizontal scalability you run multiple instances of the same application.

You can do this manually like:

```java
java -jar -Dport=[port number] target/Snowman.jar
```

where port number is an unused port

#### Veritcal Scalability a.k.a "Scaling Up"

This option is limited kind of a way. You can opt to run this application in a higher spec 
machine. Alternatively, you can give more memory to the JVM by tuning the min and max 
parameters like the following:

```java
java -jar -Xms256m -Xmx2048m target/Snowman.jar
```

### <a name="clustering"></a>Clustering

No clustering options. This application does not run in a managed cluster. Horizontal scalability
was chosen as demonstration in favour of running Cluster Servers to achieve Clustering.

See [Scalability](#scalability) for more info.

### <a name="f&r"></a>Failover and Recovery

No F&R is supported. 

You can failover the application easily (assuming you are running 
multiple instances to mimic multiple nodes servers). Just do a:

```bash
kill -9 [pid]
```

where pid is the process id of the particular application node server.

But there is no Recovery. Because no Clustering options. Refer to [Clustering](#clustering) section.

### <a name="d&r"></a>Disaster and Recovery

Although not specifically supported here, you can achieve this also. Manual intervention is required 
though in order to start up the application (or group of applications) together. 

To do Disaster Recovery a.k.a DR, you need to have the concept of a "Site". Commonly, use 
multiple sites. For simplicity, assume 2 sites - 1 Primary Site and the other is Standby Site.
Both sites would house the set of applications but only one site is up.

If Primary site considered fail (i.e. multiple failovers of one or more applications (or application components
if it is a Distributed Component Architecture)), then the Primary site should shutdown and thus Standby site
would be required to be started up. 
