# 创建消费者集群

```shell script

 java -Dserver.port=8802 -Deureka.instance.instance-id=receive-8802.com -jar com.example.cloud_stream_rabbitmq_provider.StreamReceiveMQApplication 
 java -Dserver.port=8803 -Deureka.instance.instance-id=receive-8803.com -jar com.example.cloud_stream_rabbitmq_provider.StreamReceiveMQApplication 

```
