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
public class mongoDbTest2 {
	public static void main(String[] args){ 
		MongoClient mongoClient=null;
        try {  
            //ServerAddress()两个参数分别为 服务器地址 和 端口  
            ServerAddress serverAddress = new ServerAddress("localhost",27017);  
            List<ServerAddress> addrs = new ArrayList<ServerAddress>();  
            addrs.add(serverAddress);  
              
            //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码  
            MongoCredential credential = MongoCredential.createScramSha1Credential("root", "admin", "root".toCharArray());
            List<MongoCredential> credentials = new ArrayList<MongoCredential>();  
            credentials.add(credential);  
              
            //通过连接认证获取MongoDB连接  
//            mongoClient = new MongoClient(addrs,credentials);  
            
         // 连接到 mongodb 服务（无密码连接)
//          mongoClient = new MongoClient("localhost", 27017);
          
//          String sURI = String.format("mongodb://%s:%s@%s:%d/", "root", "root2", "localhost", 27017); 
//          MongoClientURI uri = new MongoClientURI(sURI); 
//          mongoClient = new MongoClient(uri); 
          //DB db = mongoClient.getDB("test2");

              
            //连接到数据库  
            MongoDatabase mongoDatabase = mongoClient.getDatabase("test2");  
            System.out.println("Connect to database successfully");  
            
            //集合创建
            mongoDatabase.createCollection("bb");
            System.out.println("集合创建成功");
            //集合选择
            MongoCollection<Document> collection = mongoDatabase.getCollection("bb");
            System.out.println("集合 bb 选择成功");
            
            
          //插入文档  
            /** 
            * 1. 创建文档 org.bson.Document 参数为key-value的格式 
            * 2. 创建文档集合List<Document> 
            * 3. 将文档集合插入数据库集合中 mongoCollection.insertMany(List<Document>) 插入单个文档可以用 mongoCollection.insertOne(Document) 
            * */
            Document document = new Document("title", "MongoDB").  
            append("description", "database").  
            append("likes", 300).  
            append("by", "Fly");  
            Document document2 = new Document("title", "2MongoDB").  
                    append("description", "2database").  
                    append("likes", 300).  
                    append("by", "2Fly");  
            List<Document> documents = new ArrayList<Document>();  
            documents.add(document);  
            documents.add(document2);  
            collection.insertMany(documents);  
            System.out.println("文档插入成功");  
           
            
          //集合选择
            MongoCollection<Document> collection2 = mongoDatabase.getCollection("bb");
            System.out.println("集合 bb 再次选择成功");
          //检索所有文档  
            /** 
            * 1. 获取迭代器FindIterable<Document> 
            * 2. 获取游标MongoCursor<Document> 
            * 3. 通过游标遍历检索出的文档集合 
            * */  
            FindIterable<Document> findIterable = collection2.find();  
            MongoCursor<Document> mongoCursor = findIterable.iterator();  
            while(mongoCursor.hasNext()){  
               System.out.println(mongoCursor.next());  
            }  
            System.out.println("集合 bb 遍历完毕");
            
            
          //更新文档   将文档中likes=100的文档修改为likes=200   
            collection2.updateMany(Filters.eq("likes", 2100), new Document("$set",new Document("likes",500)));  
            //检索查看结果  
            findIterable = collection2.find();  
            mongoCursor = findIterable.iterator();  
            while(mongoCursor.hasNext()){  
               System.out.println(mongoCursor.next());  
            }
            System.out.println("集合 bb 更新后遍历完毕");
            
            
          //删除符合条件的第一个文档  
            //collection.deleteOne(Filters.eq("likes", 300));  
            //删除所有符合条件的文档  
            collection.deleteMany (Filters.eq("likes", 300));  
            //检索查看结果  
            findIterable = collection.find();  
            mongoCursor = findIterable.iterator();  
            while(mongoCursor.hasNext()){  
              System.out.println(mongoCursor.next());  
            }  
         
            
            
        } catch (Exception e) {  
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );  
        }finally{  
        	if(mongoClient!=null)
        		mongoClient.close();  
        }  
    }  

}

