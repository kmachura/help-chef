FROM maven:3.6.3-openjdk-17 as build

COPY . /app

WORKDIR /app

RUN mvn clean package

FROM openjdk:17-jdk-alpine

ENV APP_FILE help-chef-0.0.1-SNAPSHOT.jar
ENV APP_HOME /usr/app

EXPOSE 8082

COPY --from=build /app/target/$APP_FILE $APP_HOME/

WORKDIR $APP_HOME

ENTRYPOINT ["sh", "-c"]

CMD ["exec java -jar $APP_FILE"]