package wxpay;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.dom4j.DocumentException;

/**   
* @author lzw   
* @date 2016年11月10日 下午2:58:40 
* @Description: 
* @version V1.0   
*/
public class QueryOrder {
//	公众账号ID  appid  是  String(32)  wxd678efh567hg6787 微信分配的公众账号ID（企业号corpid即为此appId）  
//	商户号  mch_id  是  String(32) 1230000109  微信支付分配的商户号  
//	
//	微信订单号  transaction_id  二选一 String(32)  1009660380201506130728806387 微信的订单号，优先使用  
//	商户订单号  out_trade_no  String(32) 20150806125346  商户系统内部的订单号，当没提供transaction_id时需要传这个。
//	
//	随机字符串  nonce_str  是  String(32)  C380BEC2BFD727A4B6845133519F3AD6  随机字符串，不长于32位。推荐随机数生成算法 
//	签名  sign  是  String(32)  5K8264ILTKCH16CQ2502SI8ZNMTM67VS  签名，详见签名生成算法 
//	签名类型 sign_type 否 String(32) HMAC-SHA256 签名类型，目前支持HMAC-SHA256和MD5，默认为MD5 

	
	public static void main(String[] args) {
		HashMap<String, String> unifyPayReqData = new HashMap<String, String>();
		unifyPayReqData.put("appid","wx810701ac2de85f26" );//微信分配的公众号ID（开通公众号之后可以获取到）
		unifyPayReqData.put("mch_id", "10033336");////微信支付分配的商户号ID（开通公众号的微信支付功能之后可以获取到）
		unifyPayReqData.put("nonce_str", WxUtils.getRandomStringByLength(12));
		String out_trade_no =  "9939912325323";
		unifyPayReqData.put("out_trade_no", out_trade_no);
		unifyPayReqData.put("sign", WxUtils.getSign(unifyPayReqData));
		
		
		try {
			Map m=queryOrder(unifyPayReqData);
			System.out.println(m.get("trade_state"));//支付状态

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static final Log logger = LogFactory.getLog(WxPayTest.class);
	static DefaultHttpClient sslHttpClient;
	static SSLSocketFactory sslSocketFactory;
	
	
	public static Map<String, String> queryOrder(Map<String, String> unifyPayReqData) throws ClientProtocolException, IOException, DocumentException {
		 HttpPost httpPost = new HttpPost(Configure.PAY_QUERY_API);
		 httpPost.addHeader("Content-Type","text/xml");
		 String xmlParamString = WxUtils.map2Xml(unifyPayReqData);
		 try {
			StringEntity st = new StringEntity(xmlParamString, "UTF-8");
			httpPost.setEntity(st);
		}catch (Exception e) {
			e.printStackTrace();
		}
		 HttpResponse rep = getSSLHttpClient().execute(httpPost);
		 HttpEntity ent = rep.getEntity();
		 String xmlRespStrin = EntityUtils.toString(ent, "UTF-8");
		 Map<String, String> unifyPayMap = WxUtils.parseXml(new ByteArrayInputStream(xmlRespStrin.getBytes()));
		 return unifyPayMap;
	}
	
	
	
	public static SSLSocketFactory getSSLSockFact(){
		if(sslSocketFactory != null){
			return sslSocketFactory;
		}else{
			SSLContext sslcontext = null;
			try {
				sslcontext = SSLContext.getInstance("SSL");
				sslcontext.init(null, new TrustManager[]{new TrustAnyTrustManager()}, null);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			sslSocketFactory = new SSLSocketFactory(sslcontext);
			sslSocketFactory.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
			return sslSocketFactory;
		}
	}
	
	private static DefaultHttpClient getSSLHttpClient() {
		if(sslHttpClient == null){
			sslHttpClient = new DefaultHttpClient();
			
			ClientConnectionManager ccm = sslHttpClient.getConnectionManager();
			SchemeRegistry sr = ccm.getSchemeRegistry();
			Scheme sch = new Scheme("https", getSSLSockFact(), 443);
			sr.register(sch);
			sslHttpClient = new DefaultHttpClient(ccm,sslHttpClient.getParams());
		}
		return sslHttpClient;
	}
	
	

}
