@echo off
call java -jar -javaagent:../agent/skywalking-agent.jar  ../webuy-learning-event-*.jar
pause