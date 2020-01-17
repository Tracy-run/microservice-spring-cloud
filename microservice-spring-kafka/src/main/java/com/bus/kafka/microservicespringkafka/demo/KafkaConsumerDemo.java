package com.bus.kafka.microservicespringkafka.demo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

public class KafkaConsumerDemo {

    private final KafkaConsumer<String,String> consumer;


    public KafkaConsumerDemo(){
        Properties pros = new Properties();
        pros.put("bootstrap.servers","localhost:9092");
        pros.put("group.id","test");
        pros.put("enable.auto.commit","false");
        pros.put("auto.commit.interval.ms","1000");
        pros.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        pros.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");

        consumer = new KafkaConsumer<String, String>(pros);
    }

    void consume(){
        consumer.subscribe(Arrays.asList(KafkaProducerDemo.TOPIC));
        while(true){
            ConsumerRecords<String,String> records = consumer.poll(100);
            for(ConsumerRecord<String,String> record:records){
                System.out.println("我是神！！！");
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(),record.key(),record.value());
            }

        }
    }

    public static void main(String[] args) {
        KafkaConsumerDemo kafkaConsumerDemo = new KafkaConsumerDemo();
        kafkaConsumerDemo.consume();
    }


}
