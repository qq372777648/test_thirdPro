package mongodb;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

/** 
* @author lzw 
* @version 创建时间：2016年7月11日 上午9:51:14 
* @Description:  
*/
public class mongoDbTest3 {
	public static void main(String[] args){ 
		MongoClient mongoClient=null;
        try {  
          mongoClient = new MongoClient("localhost", 27017);
            //连接到数据库  
            MongoDatabase mongoDatabase = mongoClient.getDatabase("test2");  
            System.out.println("Connect to database successfully");  
            
           
            //检索所有文档  
            /** 
            * 1. 获取迭代器FindIterable<Document> 
            * 2. 获取游标MongoCursor<Document> 
            * 3. 通过游标遍历检索出的文档集合 
            * */ 
            //集合选择
            MongoCollection<Document> collection2 = mongoDatabase.getCollection("bb");
            FindIterable<Document> findIterable = collection2.find();  
            MongoCursor<Document> mongoCursor = findIterable.iterator();  
            while(mongoCursor.hasNext()){  
               System.out.println(mongoCursor.next());  
            }  
            System.out.println("集合 bb 遍历完毕");
            
            
         
            
            
        } catch (Exception e) {  
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );  
        }finally{  
        	if(mongoClient!=null)
        		mongoClient.close();  
        }  
    }  

}

