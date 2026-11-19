FROM maven:3.9-eclipse-temurin-21 AS build

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src
RUN mvn clean package -DskipTests -B

FROM tomcat:10.1.61-jdk21-temurin-jammy

RUN rm -rf /usr/local/tomcat/webapps/*

COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/ROOT.war

CMD sh -c 'sed -i "s/port=\"8080\"/port=\"${PORT:-10000}\"/" /usr/local/tomcat/conf/server.xml && catalina.sh run'