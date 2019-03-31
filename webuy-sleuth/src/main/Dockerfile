FROM openjdk:8-jdk-alpine
VOLUME /tmp
VOLUME /logs
RUN mkdir -p /tmp  \
mkdir -p /logs \
mkdir -p /logs/webuy-sleuth \
touch -p /logs/webuy-sleuth/webuy-sleuth-gc.log
ADD webuy-task.jar app.jar
#RUN sh -c 'touch /app.jar'

#ENV命令用于设置环境变量。这些变量以”key=value”的形式存在，并可以在容器内被脚本或者程序调用。
ENV JAVA_OPTS=" \
-server \
-Xmx180m \
-Xms180m \
-XX:+PrintGCDetails \
-XX:+PrintTenuringDistribution \
-XX:+PrintGCTimeStamps \
#-XX:+PrintGCDateStamps \
-XX:+HeapDumpOnOutOfMemoryError \
-XX:HeapDumpPath=/logs/webuy-sleuth/webuy-sleuth-heap.dump \
-Xloggc:/logs/webuy-sleuth/webuy-sleuth-gc.log \
-Djava.compiler=NONE \
-Duser.timezone=GMT+08 \
-Djava.security.egd=file:/dev/./urandom"
# ENTRYPOINT 帮助你配置一个容器使之可执行化
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]

#启动容器:
#docker run -d -v /docker/app/logs:/logs -v /docker/app/tmp:/tmp -p 9301:9301 --name webuy-sleuth webuy-sleuth:1.0