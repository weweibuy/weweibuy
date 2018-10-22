# 将项目打包成jar，与Dockerfile 放在同一目录下
# 加载JDK
FROM openjdk:8-jdk-alpine
VOLUME /tmp
# 添加springboot项目到镜像中的home目录，并重命名为app.jar
# 这个app.jar 一定要和ENTRYPOINT 参数中app.jar名字一样
ADD webuy-eureka.jar app.jar
EXPOSE 7001
# 容器启动后执行的命令
ENTRYPOINT ["java","-jar","app.jar"]

======================== 另一种 ============================
FROM openjdk:8-jdk-alpine

# Create app directory
RUN mkdir -p /app
VOLUME /app
ADD webuy-eureka.jar app.jar
WORKDIR /app

# Bundle app source
COPY . /app

# Build the solution (using the gradle task)
RUN ./gradlew build

EXPOSE 7001

ENTRYPOINT exec java $JAVA_OPTS -jar build/libs/{app name}.jar