package kafka.app.demo;

import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class Producer1 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        String bootStrapServers = "127.0.0.1:9092";
        //creating properties 
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        
        // creating Kafka producer
        KafkaProducer<String, String>  first_producer = new KafkaProducer<String, String>(properties);
        // creating Producer Record 
        ProducerRecord<String, String> record = new ProducerRecord<String, String> ("my_first", "Hye Kafka");
        
        first_producer.send(record, new Callback () {
        	public void onCompletion(RecordMetadata recordMetadata, Exception e) {
        	     Logger logger=LoggerFactory.getLogger(Producer1.class);  
        	     if (e== null) {  
        	            logger.info("Successfully received the details as: \n" +  
        	                    "Topic:" + recordMetadata.topic() + "\n" +  
        	                    "Partition:" + recordMetadata.partition() + "\n" +  
        	                    "Offset" + recordMetadata.offset() + "\n" +  
        	                    "Timestamp" + recordMetadata.timestamp());  
        	                      }  
        	  
        	         else {  
        	            logger.error("Can't produce,getting error",e);  
        	  
        	        }  
        	}
        		
        });  
        
        
        first_producer.flush();
        first_producer.close();
        
    }
}
