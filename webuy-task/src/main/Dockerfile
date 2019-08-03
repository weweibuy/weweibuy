FROM openjdk:8-jdk-alpine
VOLUME /tmp
VOLUME /logs
RUN mkdir -p /tmp  \
mkdir -p /logs \
mkdir -p /logs/webuy-task \
touch -p /logs/webuy-task/gc.log
ADD webuy-task.jar app.jar
#RUN sh -c 'touch /app.jar'

#ENV命令用于设置环境变量。这些变量以”key=value”的形式存在，并可以在容器内被脚本或者程序调用。
ENV JAVA_OPTS=" \
-server \
-Xmx180m \
-Xms180m \
-XX:+PrintGCDetails \
-XX:+PrintTenuringDistribution \
#-XX:+PrintGCTimeStamps \
-XX:+PrintGCDateStamps \
-XX:+HeapDumpOnOutOfMemoryError \
-XX:HeapDumpPath=/logs/webuy-task/webuy-task-heap.dump \
-Xloggc:/logs/webuy-task/gc.log \
# --------- 为 sentinel 配置 ------------
-Dcsp.sentinel.dashboard.server=192.168.0.4:8080 \
-Dcsp.sentinel.heartbeat.client.ip=192.168.0.5 \
-Dcsp.sentinel.api.port=8721 \
-Dcsp.sentinel.log.dir=/logs/webuy-task/sentinel \
-Dproject.name=webuy-task \
# --------------------------------------
-Djava.compiler=NONE \
-Duser.timezone=GMT+08 \
-Djava.security.egd=file:/dev/./urandom"
# ENTRYPOINT 帮助你配置一个容器使之可执行化
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]

#启动容器:
#docker run -d -v /docker/app/logs:/logs -v /docker/app/tmp:/tmp -p 7501:7501 -p 8721:8721  --name webuy-task webuy-task:latest