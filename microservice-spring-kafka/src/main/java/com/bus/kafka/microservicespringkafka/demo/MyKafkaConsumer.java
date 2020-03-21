package com.bus.kafka.microservicespringkafka.demo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.record.Records;

import java.util.Arrays;
import java.util.Properties;

//@SpringBootApplication
public class MyKafkaConsumer {



    public static void main(String [] args){

        //1. 准备配置信息
        Properties prop = new Properties();
        //定义kafka服务器地址列表，不需要制定所有broker
        prop.put("bootstrap.servers","node01:9092,node02:9092,node03:9093");
        // 消费者组id
        prop.put("group.id","xxxxx");
        //是否自动确认offset
        prop.put("enable.auto.commit","true");
        //自动确认offset的 世间
        prop.put("auto.commit.interval.ms","1000");
        //key  序列化
        prop.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        //value 序列化
        prop.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");

    // 2. 创建一个消费者
        KafkaConsumer<String,String> consumer = new KafkaConsumer<String, String>(prop);

    // 3. 指定消费哪一个 topic 的数据
        //指定分区消费
        TopicPartition partition = new TopicPartition("XXXXX",0);

        // 获取已经提交的偏移量
        long offset = 0L;
        OffsetAndMetadata offsetAndMetadata = consumer.committed(partition);
        if(offsetAndMetadata != null){
            offset = offsetAndMetadata.offset();
        }
        System.out.println("当前消费者的偏移量是：" + offset);

        //指定偏移量消费
        consumer.assign(Arrays.asList(partition));
        //定位
        consumer.seek(partition,offset);

        while(true){
            // 拉取数据
            ConsumerRecords<String,String> records = consumer.poll(1000);

            //打印数据
            for(ConsumerRecord<String,String> record: records){
                System.out.println("消费者的数据为：" + record);
            }

        }








    }
}
