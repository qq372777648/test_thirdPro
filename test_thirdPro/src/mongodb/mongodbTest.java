package mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 * @author lzw
 * @version 创建时间：2016年7月11日 上午9:45:04
 * @Description:
 */
public class mongodbTest {
	public static void main(String[] args) {
		try {
			// 连接到 mongodb 服务
			MongoClient mongoClient = new MongoClient("localhost", 27017);

			// 连接到数据库
			MongoDatabase mongoDatabase = mongoClient.getDatabase("test3");
			System.out.println("Connect to database successfully");

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}
}
