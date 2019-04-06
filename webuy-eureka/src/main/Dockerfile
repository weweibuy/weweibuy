FROM openjdk:8-jdk-alpine
VOLUME /tmp
VOLUME /logs
RUN mkdir -p /tmp  \
mkdir -p /logs \
mkdir -p /logs/webuy-eureka \
touch -p /logs/webuy-eureka/webuy-eureka-gc.log
ADD webuy-eureka.jar app.jar
#RUN sh -c 'touch /app.jar'

#ENV命令用于设置环境变量。这些变量以”key=value”的形式存在，并可以在容器内被脚本或者程序调用。
ENV JAVA_OPTS=" \
-server \
-Xmx150m \
-Xms56m \
-XX:+PrintGCDetails \
-XX:+PrintTenuringDistribution \
#-XX:+PrintGCTimeStamps \
-XX:+PrintGCDateStamps \
-XX:+HeapDumpOnOutOfMemoryError \
-XX:HeapDumpPath=/log/webuy-eureka/webuy-eureka-heap.dump \
-Xloggc:/logs/webuy-eureka/webuy-eureka-gc.log \
-Djava.compiler=NONE \
-Duser.timezone=GMT+08 \
-Djava.security.egd=file:/dev/./urandom"
# ENTRYPOINT 帮助你配置一个容器使之可执行化
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]

#启动容器:
    #docker run -d -v /docker/app/logs:/logs -v /docker/app/tmp:/tmp -p 7001:7001 --name eureka webuy-eureka:3.0