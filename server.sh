#!/bin/bash
# java 服务管理脚本
. /etc/profile
APP_PATH=$(pwd)
JAVA_OPTS="-server -Xms512m -Xmx512m -Xss512k -XX:MaxNewSize=64m -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+DisableExplicitGC -XX:+CMSParallelRemarkEnabled"
JAVA_OPTS="$JAVA_OPTS -Dspring.profiles.active=local"
JAR_FILE=$(find $APP_PATH/ -maxdepth 1 -name "*.jar")

Pid()
{
    PID=$(ps ax | grep "$APP_PATH/" | grep -v grep | awk '{print $1}')
}

Start()
{
    Pid
    if [ -n "$PID" ]
    then
        echo "服务正在运行"
    else
        sudo -u java java -jar $JAVA_OPTS $JAR_FILE >/dev/null 2>&1 &
        echo $(history uax | grep 'java java -jar')
        [ $? -eq 0 ] && echo "启动服务" || echo "启动服务失败"
    fi
}

Stop()
{
    Pid
    if [ -n "$PID" ]
    then
        kill -9 $PID && echo "停止服务"
    else
        echo "服务未运行"
    fi
}

Status()
{
    Pid
    if [ -n "$PID" ]
    then
        echo "服务正在运行，PID: $PID"
        ps aux | grep -v grep | grep "$APP_PATH/.*.jar"
    else
        echo "服务未运行"
    fi
}

case "$1" in
'start')
    Start
    ;;
'stop')
    Stop
    ;;
'restart')
    Stop
    Start
    ;;
'status')
    Status
    ;;
*)
    echo "Usage: $0 {status | start | stop}"
    ;;
esac
exit 0
