//package aliProduct.MessageQueue;
//
//import java.util.Properties;
//
//import com.aliyun.openservices.ons.api.ConsumeContext;
//import com.aliyun.openservices.ons.api.ONSFactory;
//import com.aliyun.openservices.ons.api.PropertyKeyConst;
//import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.consumer.listener.MessageListener;
//import com.aliyun.openservices.shade.com.alibaba.rocketmq.common.message.Message;
//import com.aliyun.openservices.shade.com.alibaba.rocketmq.shade.io.netty.util.internal.MessagePassingQueue.Consumer;
//import com.aliyun.openservices.shade.com.alibaba.rocketmq.shade.io.netty.util.internal.chmv8.ConcurrentHashMapV8.Action;
//
//
//
//
///**   
//* @author lzw   
//* @date 2017年1月13日 下午2:17:45 
//* @Description: 
//* @version V1.0   
//*/
//public class ConsumerShadeTest2 {
//    public static void main(String[] args) {
//        Properties properties = new Properties();
//        properties.put(PropertyKeyConst.ConsumerId, "CID_20170113");// 您在MQ控制台创建的Consumer ID
//        properties.put(PropertyKeyConst.AccessKey, "xgDsn3fjZCTSkmV8");// 鉴权用AccessKey，在阿里云服务器管理控制台创建
//        properties.put(PropertyKeyConst.SecretKey, "nSKXlwTHLLMZyCz8NtA56TpxzMmsbp");// 鉴权用SecretKey，在阿里云服务器管理控制台创建
//        Consumer consumer = ONSFactory.createConsumer(properties);
//        consumer.subscribe("todolist", "*", new MessageListener() {
//            public Action consume(Message message, ConsumeContext context) {
//                System.out.println("Receive: " + message);
//               System.out.println( new String(message.getBody()));
//                return Action.CommitMessage;
//            }
//        });
//        consumer.start();
//        System.out.println("Consumer Started");
//    }
//}
