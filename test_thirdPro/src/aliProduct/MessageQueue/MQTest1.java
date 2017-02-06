package aliProduct.MessageQueue;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.ONSFactory;
import com.aliyun.openservices.ons.api.Producer;
import com.aliyun.openservices.ons.api.PropertyKeyConst;
import com.aliyun.openservices.ons.api.SendResult;
 
/**
 *  send 
 */
public class MQTest1 {
 
    public static void main(String[] args) {
       Properties properties = new Properties();
       properties.put(PropertyKeyConst.ProducerId, "PID_20170113");
       properties.put(PropertyKeyConst.AccessKey, "xgDsn3fjZCTSkmV8");
       properties.put(PropertyKeyConst.SecretKey, "nSKXlwTHLLMZyCz8NtA56TpxzMmsbp");
       //公有云生产环境：http://onsaddr-internal.aliyun.com:8080/rocketmq/nsaddr4client-internal
       //公有云公测环境：http://onsaddr-internet.aliyun.com/rocketmq/nsaddr4client-internet
       //杭州金融云环境：http://jbponsaddr-internal.aliyun.com:8080/rocketmq/nsaddr4client-internal
       //杭州深圳云环境：http://mq4finance-sz.addr.aliyun.com:8080/rocketmq/nsaddr4client-internal
       properties.put(PropertyKeyConst.ONSAddr,
//          "http://onsaddr-internal.aliyun.com:8080/rocketmq/nsaddr4client-internal"//此处以公有云生产环境为例
    		   "http://onsaddr-internet.aliyun.com/rocketmq/nsaddr4client-internet"
    		   );
       Producer producer = ONSFactory.createProducer(properties);
            
       //在发送消息前，必须调用start方法来启动Producer，只需调用一次即可。
       producer.start();
       Message msg = new Message(
            //Message Topic
            "todolist",
            //Message Tag,
            //可理解为Gmail中的标签，对消息进行再归类，方便Consumer指定过滤条件在ONS服务器过滤       
            "t3",
            //Message Body
            //任何二进制形式的数据，ONS不做任何干预，需要Producer与Consumer协商好一致的序列化和反序列化方式
            "Hello ONS".getBytes()
        );
         
        // 设置代表消息的业务关键属性，请尽可能全局唯一。
        // 以方便您在无法正常收到消息情况下，可通过ONS Console查询消息并补发。
        // 注意：不设置也不会影响消息正常收发
        msg.setKey("lzw31");
        
        
        
        /**
         * 定时消息投递，设置投递的具体时间戳，单位毫秒例如2016-03-07 16:21:00投递
        */
		try {
//			long  timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2016-03-07 16:21:00").getTime();
//			msg.setStartDeliverTime(timeStamp);
			msg.setStartDeliverTime(System.currentTimeMillis() + 30000);//延时
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
         
//		OrderProducer orderproducer = ONSFactory.createOrderProducer(properties);
//		 // 分区顺序消息中区分不同分区的关键字段，sharding key于普通消息的key是完全不同的概念。
//        // 全局顺序消息，该字段可以设置为任意非空字符串。
//        String shardingKey ="分片1";
//        // 发送消息，只要不抛异常就是成功
//        SendResult sendResult = orderproducer.send(msg, shardingKey);
		
		
        //发送消息，只要不抛异常就是成功
    	try {
    		int count=5;
    		int c_count=0;
        while(c_count<count){
        	
        	SendResult sendResult = producer.send(msg);
        	System.out.println(sendResult);
        	c_count++;
        }
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
        // 在应用退出前，销毁Producer对象
        // 注意：如果不销毁也没有问题
        producer.shutdown();
        
        System.exit(0);
    }
}