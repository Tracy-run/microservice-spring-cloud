package com.bus.kafka.microservicespringkafka.demo;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@SpringBootApplication
public class MyKafkaProducer {

    public static void main(String [] args) throws ExecutionException, InterruptedException{
        //1. 准备配置信息
        Properties prop = new Properties();
        //定义kafka服务器地址列表，不需要制定所有broker
        prop.put("bootstrap.servers","node01:9092,node02:9092,node03:9093");
        //生产者需要leader确认请求完成之前接受的应答数
        prop.put("acks",1);
        //客户端失败重试次数
        prop.put("retries",1);
        //生产者打包消费的批量大小，以字节为单位，此处是16k
        prop.put("batch.size",16384);
        //生产者延时1ms发送消息
        prop.put("linger.ms",1);
        //生产者缓存内存的大小，以字节为单位，此处是32m
        prop.put("buffer.memory",33554432);
        //key  序列化
        prop.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        //value 序列化
        prop.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");

    // 2.创建生产者对象
        KafkaProducer<String,String> producer = new KafkaProducer<>(prop);

    //3.通过生产者发送消息
        //　同步消息的方式 3 种
        /**  1.同步阻塞发送
        *
        *   2.异步发送
        *
        *   3.异步发送（进行回调处理）
        */

        // 1.同步阻塞发送
        System.out.println("----------------同步发送start----------------------");

        ProducerRecord<String,String> record = new ProducerRecord<String, String>("oc.kafka,topic",0,"key-sync","这是同步发送的内容");

        Future<RecordMetadata> send = producer.send(record);
        RecordMetadata recordMetadata = send.get(); //通过get()同步阻塞

        System.out.println(recordMetadata);
        System.out.println("-----------------同步发送end---------------------------");


        //2.异步发送（发送后就忘记）
        System.out.println("--------------------异步发送（发送后就忘记）start----------");
        ProducerRecord<String,String> record1 = new ProducerRecord<String, String>("oc.kafka.topic",0,"key.async1","异步发送后忘记的内容");
        //发送后就忘记
        producer.send(record1);
        System.out.println("--------------------异步发送（发送后就忘记）end----------");


        // 3 异步发送后回调
        System.out.println("--------------------异步发送后回调 start -------------------");
        ProducerRecord<String,String> record2 = new ProducerRecord<String, String>("oc.kafka.topic",0,"key-async","发送异步消息并回调");
        //发送后就回调
        producer.send(record2, new Callback() {
            @Override
            public void onCompletion(RecordMetadata metadata, Exception exception){
                System.out.println("异步消息发送成功：" + metadata);
                System.out.println("异常现象：" + exception);
            }
        });

        System.out.println("--------------------异步发送后回调 end -------------------");




    }


}
