# 测试连接

1. [http://127.0.0.1:3344/master/config-dev.yml](http://127.0.0.1:3344/master/config-dev.yml)
1. [http://127.0.0.1:3344/master/config-prod.yml](http://127.0.0.1:3344/master/config-prod.yml)

1. `curl -X POST http://127.0.0.1:3344/actuator/bus-refresh`
1. 刷新指定节点
   ```shell script
    curl -X POST http://127.0.0.1:3344/actuator/bus-refresh/{destination}
   
    curl -X POST http://127.0.0.1:3344/actuator/bus-refresh/{服务名称:端口号}
   
    curl -X POST http://127.0.0.1:3344/actuator/bus-refresh/config-client:3355
   ```
