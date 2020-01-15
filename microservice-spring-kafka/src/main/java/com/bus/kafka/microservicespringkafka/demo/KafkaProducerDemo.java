package com.bus.kafka.microservicespringkafka.demo;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;

public class KafkaProducerDemo {

    private final Producer<String,String> kafkaProducer;

    public final static String TOPIC= "JAVA_TOPIC";

    public KafkaProducerDemo(){
        kafkaProducer = createKafkaProducer();
    }

    private Producer<String,String> createKafkaProducer(){
        Properties pros = new Properties();
        pros.put("bootstrap.servers","localhost:9092");
        pros.put("acks","all");
        pros.put("retries",0);
        pros.put("batch.size",16384);
        pros.put("linger.ms",1);
        pros.put("buffer.memory",33554432);
        pros.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        pros.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");

        Producer<String,String> kafkaProducer = new KafkaProducer<String, String>(pros);

        return kafkaProducer;
    }

    void producer(){
        for(int i=0;i<10;i++){

            final String key = "key" + i;
            String data = "hello kafka message:" + key;
            kafkaProducer.send(new ProducerRecord<String, String>(TOPIC, key, data), new Callback() {
                @Override
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    System.out.println("发送了key" + key + "成功");
                }
            });
        }
    }

    public static void main(String [] args){
        KafkaProducerDemo kafka = new KafkaProducerDemo();
        kafka.producer();
    }

}
