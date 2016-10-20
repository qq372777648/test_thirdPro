import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;

import com.aliyun.opensearch.CloudsearchClient;
import com.aliyun.opensearch.CloudsearchDoc;
import com.aliyun.opensearch.CloudsearchIndex;
import com.aliyun.opensearch.CloudsearchSearch;
import com.aliyun.opensearch.object.KeyTypeEnum;

/** 
* @author lzw 
* @version 创建时间：2016年7月4日 下午2:32:17 
* @Description:  
*/
public class OpenSearchUtil {
	String accesskey= "xgDsn3fjZCTSkmV8";
	String secret =   "nSKXlwTHLLMZyCz8NtA56TpxzMmsbp";
	String appName =  "testb";
	
	//公网
	String host="http://opensearch-cn-beijing.aliyuncs.com";
	
	
	
	Map<String, Object> opts = new HashMap<String, Object>();

	// 这里的host需要根据访问应用详情页中提供的的API入口来确定
	CloudsearchClient client = null;
	CloudsearchIndex app = null;
	

	// 您可以根据自己的需求来选择相应的模板，根据模板名称创建应用；创建自定义结构时您需要在网站中先创建好应用结构并保存成模板，然后再通过SDK使用模板名称进行创建。
	
	
	public  void test(){
		try {
			CloudsearchClient client = new CloudsearchClient(accesskey, secret , host, opts, KeyTypeEnum.ALIYUN);
			
			//创建应用
//			CloudsearchIndex app = new CloudsearchIndex("xx", client);
//			System.out.println(app.createByTemplateName("lib"));
//			System.out.println(app.status());
			
			
//			//文档操作
			CloudsearchDoc doc = new CloudsearchDoc(appName, client);
			
			//1、添加
//			String table_name = "main";
//			String data = "[{\"fields\": {\"id\": \"11\",\"title\": \"java系列\",\"book\": 99},\"cmd\": \"ADD\"}]";
//			System.out.println(doc.push(data, table_name));
				//----doc.add(fields);
				//----doc.push("main");//main是上传到的表名
			
//			table_name = "book";
//			data = "[{\"fields\": {\"bookid\": \"99\",\"bookname\": \"爪哇是世界上最酷的语言\"},\"cmd\": \"ADD\"}]";
//			System.out.println(doc.push(data, table_name));
			
			//2、查看（getby文档id）
//			System.out.println(doc.detail("11"));
			
			//3、更新(只能单表更新)
//			Map fields = new HashMap<>();
//			fields.put("bookid", "102");
//			fields.put("bookname", "对爪哇道的领悟(第3版)");
//			doc.update(fields);
//		    doc.push("book");//book为待更新的文档所在的表名
			
			//4、删除
//			Map fields = new HashMap<>();
//			fields.put("bookid", "102");
//			doc.remove(fields);
//		    doc.push("book");//book为待更新的文档所在的表名
			
		    
//			开始搜索
			CloudsearchSearch search = new CloudsearchSearch(client);
			// 添加指定搜索的应用：
			search.addIndex(appName);
			// 指定搜索的关键词，这里要指定在哪个索引上搜索，如果不指定的话默认在使用“default”索引（索引字段名称是您在您的数据结构中的“索引到”字段。）
//			search.setQueryString("'词典'");
			search.setQueryString("default:'java'");
//			search.setQueryString("index_name:'词典'");
			
			//增加过滤器
			search.addFilter("book>101","AND");//and /or  -------- 勾选可过滤才能使用
			
			//分组字段统计
			search.addAggregate("book", "max(book)");
			
			
			
			// 指定搜索返回的格式。
			search.setFormat("json");
			//设置返回结果数
			search.setStartHit(0);//start
			search.setHits(4);//size
			
			//排序
			search.addSort("book", "+");//有设置返回的列才可以
			
			// 返回搜索结果
//			opts.put(key, value)
			
			System.out.println(search.search(opts));
			
			
			//------------
			//应用类的调试信息调用接口
			//System.out.println(app.getDebugInfo());
			//文档类的调试信息调用接口
			//System.out.println(doc.getDebugInfo());
			//搜索类的调试信息调用接口
			System.out.println(search.getDebugInfo());
			
			
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		new OpenSearchUtil().test();
	}

}

