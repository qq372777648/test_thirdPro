package aliProduct.MessageQueue;

import java.util.Properties;

import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Consumer;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import com.aliyun.openservices.ons.api.ONSFactory;
import com.aliyun.openservices.ons.api.PropertyKeyConst;


/**   
* @author lzw   
* @date 2017年1月13日 下午2:17:45 
* @Description: 
* @version V1.0   
*/
public class ConsumerTest {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.ConsumerId, "CID_201701132");// 您在MQ控制台创建的Consumer ID
        properties.put(PropertyKeyConst.AccessKey, "xgDsn3fjZCTSkmV8");// 鉴权用AccessKey，在阿里云服务器管理控制台创建
        properties.put(PropertyKeyConst.SecretKey, "nSKXlwTHLLMZyCz8NtA56TpxzMmsbp");// 鉴权用SecretKey，在阿里云服务器管理控制台创建
        
        
        //配置对应 Consumer ID 的最大消息重试次数为20 次
        properties.put(PropertyKeyConst.MaxReconsumeTimes,20);
        
        Consumer consumer = ONSFactory.createConsumer(properties);
        consumer.subscribe("todolist", "t1||t2||t3", new MessageListener() {
            public Action consume(Message message, ConsumeContext context) {
                System.out.println("Receive: " + message);
                
                String key = message.getKey();
                String body= new String(message.getBody());
               
             //获取消息的重试次数
               System.out.println(message.getReconsumeTimes());
               
                return Action.CommitMessage;
                
//                //方式1：返回 Action.ReconsumeLater, 消息将重试
//                return Action.ReconsumeLater;
//                //方式2：返回 null, 消息将重试
//                return null;
//                //方式3：直接抛出异常 , 消息将重试
//                throw new RuntimeException("Consumer Message exceotion");
            }
        });
        consumer.start();
        System.out.println("Consumer Started");
    }
}
