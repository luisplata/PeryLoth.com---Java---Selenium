# Base image con Maven y un JDK moderno (ajustado a JDK 23 si necesario)
FROM maven:3.9.9-eclipse-temurin-23 AS build

# Configurar directorio de trabajo
WORKDIR /app

# Copiar archivos al contenedor
COPY . .

# Añadir argumentos si Maven requiere ajustes para tu JDK
ARG MAVEN_OPTS="--add-opens java.base/java.lang=ALL-UNNAMED"

# Construir el proyecto Maven
RUN mvn clean package

# Imagen de ejecución
FROM eclipse-temurin:23-jdk

# Copiar el jar generado desde la etapa de construcción
COPY --from=build /app/target/selenium-tests-1.0-SNAPSHOT.jar app.jar

# Comando de inicio
ENTRYPOINT ["java", "-jar", "app.jar"]
