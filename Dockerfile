# Stage 1: Build the application using Maven
FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /app

# Copy the entire project to the image
COPY . .

# Build the application using Maven
RUN mvn clean package -DskipTests

# Stage 2: Create the final image with only the app.jar
FROM eclipse-temurin:21-jre-alpine

ARG USER=default
ENV HOME=/home/$USER

ENV TZ=Europe/Oslo
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

# Install sudo as root
RUN apk add --update sudo
RUN adduser -D $USER \
        && echo "$USER ALL=(ALL) NOPASSWD: ALL" > /etc/sudoers.d/$USER \
        && chmod 0440 /etc/sudoers.d/$USER

USER $USER
WORKDIR $HOME

# Copy only the built JAR from the previous stage
COPY --from=build /app/target/app.jar app.jar

CMD ["sh", "-c", "java -jar -Xmx16m $JAVA_OPTS app.jar"]