package kafka.app.demo;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class Consumer1 
{
    public static void main( String[] args )
    {
       System.out.println( "consumer1 application" );
       Logger logger = LoggerFactory.getLogger(Consumer1.class.getName());
       String bootStrapServer ="127.0.0.1:9092";
       String grp_id ="second_app";
       String topic = "my_first";
       
       // Creating Consumer properties 
       Properties proprties = new Properties ();
       proprties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServer);
       proprties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
       proprties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_DOC, StringDeserializer.class.getName());
       proprties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, grp_id);
       proprties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
       
       KafkaConsumer<String, String>  consumer = new KafkaConsumer<String, String>(proprties);
       
       // Subscribing 
       consumer.subscribe(Arrays.asList(topic));
       
       // polling 
       while(true) {
    	   ConsumerRecords <String, String> records = consumer.poll(Duration.ofMillis(100));
    	   for(ConsumerRecord<String, String> record : records ) {
    		   logger.info("key : "+record.key()+", value "+record.value());
    		   logger.info("Partition : "+record.partition()+", offset "+record.offset());
    	   }
       }
       
    }
}
