# ==========================================
# STAGE 1: Build da Aplicação
# ==========================================
FROM maven:3.9-eclipse-temurin-25-alpine as builder

WORKDIR /app

#Copy the dependency files first to take advantage of Docker layer caching.
COPY pom.xml .
RUN mvn dependency:go-offline -B

# ==========================================
# STAGE 2: Imagem Final de Execução (Runtime)
# ==========================================
FROM eclipse-temurin:25-jre-alpine

WORKDIR /app

# Cria um usuário não-root por boas práticas de segurança
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

EXPOSE 8080

ENTRYPOINT ["java", "-XX:+UseG1GC", "-XX:MaxRAMPercentage=75.0", "-jar", "app.jar"]