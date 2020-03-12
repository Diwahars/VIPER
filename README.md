# VIPER  

### **V**ehicle **I**dentifcation **P**latform with **E**nhanced **R**eviews  
---

![java-springboot-graphql](https://i.morioh.com/c385fa2a26.png "Java + Spring Boot + GraphQL")  


This is a demo app written in Java that uses the Spring Boot framework, GraphQL and Mongo. The connection string for the database uses environmen varialbes (see application.properties), if you would like to connect to the db and test some queries/mutations, please contact me.  

### Instructions  

  1. mvn clean install -DskipTests  
  2. java -jar target/VIPER-0.0.1-SNAPSHOT.war  
  3. localhost:8080/graphiql  
