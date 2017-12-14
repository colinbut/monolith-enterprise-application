# Enterprise Application : Snowman

## Table of Contents

- [Database Migration](#database-migration)
- [Scalability](#scalability)
- [Clustering](#clustering)
- [Failover & Recovery](#f&r)

This project aims to provide a skeleton example of a common traditional (perhaps now viewed as legacy) enterprise
like application.

Snowman is an fictional enterprise scale/ready employee management system (EMS). This project uses Snowman to 
demonstrate the characteristics of a stereotypical backend enterprise application.
  
Snowman exposes its functionality via REST (-like) endpoints. Essentially this is a 
backend web service.

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

