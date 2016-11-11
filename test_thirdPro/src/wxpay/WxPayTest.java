package wxpay;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
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

public class WxPayTest {

	public static final Log logger = LogFactory.getLog(WxPayTest.class);
	static DefaultHttpClient sslHttpClient;
	static SSLSocketFactory sslSocketFactory;

	
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

	public static Map<String, String> unifyPay(Map<String, String> unifyPayReqData) throws ClientProtocolException, IOException, DocumentException {
		 HttpPost httpPost = new HttpPost(Configure.UNIFY_PAY_API);
		 httpPost.addHeader("Content-Type","text/xml");
		 String xmlParamString = WxUtils.map2Xml(unifyPayReqData);
//		 String xml="<xml>"+
//					"<appid>"+appid+"</appid>"+
//					"<mch_id>"+mch_id+"</mch_id>"+
//					"<nonce_str>"+nonce_str+"</nonce_str>"+
//					"<sign>"+sign+"</sign>"+
//					"<body><![CDATA["+body+"]]></body>"+
//					"<attach>"+attach+"</attach>"+
//					"<out_trade_no>"+out_trade_no+"</out_trade_no>"+
//					//金额，这里写的1 分到时修改
//					"<total_fee>"+1+"</total_fee>"+
//					//"<total_fee>"+finalmoney+"</total_fee>"+
//					"<spbill_create_ip>"+spbill_create_ip+"</spbill_create_ip>"+
//					"<notify_url>"+notify_url+"</notify_url>"+
//					"<trade_type>"+trade_type+"</trade_type>"+
//					"<openid>"+openid+"</openid>"+
//					"</xml>";
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
	
	
	public  static void main(String ...a){
		HashMap<String, String> unifyPayReqData = new HashMap<String, String>();
		unifyPayReqData.put("appid","wx810701ac2de85f26" );//微信分配的公众号ID（开通公众号之后可以获取到）
		unifyPayReqData.put("mch_id", "10033336");////微信支付分配的商户号ID（开通公众号的微信支付功能之后可以获取到）
		unifyPayReqData.put("product_id","12343453125");
		
		unifyPayReqData.put("nonce_str", WxUtils.getRandomStringByLength(12));
		unifyPayReqData.put("fee_type", Configure.FREE_TYPE);
		unifyPayReqData.put("spbill_create_ip", Configure.WXPAY_IP);
		unifyPayReqData.put("notify_url", "http://15105u8z38.iask.in/test_thirdPro/wxorder/result");
		unifyPayReqData.put("trade_type", Configure.NATIVE);
		
		
		
		
		
		unifyPayReqData.put("time_start", UtilDate.getDateNum(new Date(), "yyyyMMddHHmmss"));
		unifyPayReqData.put("time_expire", UtilDate.getDateNum(CalendarUtils.add(Calendar.HOUR, new Date(), 2), "yyyyMMddHHmmss"));
		String out_trade_no =  "9939912325323";
		unifyPayReqData.put("out_trade_no", out_trade_no);
//		unifyPayReqData.put("out_trade_no", param.get("id"));
		unifyPayReqData.put("total_fee", 2+"");
		unifyPayReqData.put("body", "test112");
		unifyPayReqData.put("sign", WxUtils.getSign(unifyPayReqData));
		
		
		try {
			Map m=unifyPay(unifyPayReqData);
			System.out.println(m);
//			{result_code=SUCCESS, 
//			sign=9FCB4F8B2485F91BBA1AE56007C92E10,
//			mch_id=10033336, 
//			prepay_id=wx2016110713023875e936dc800064181874, 
//			return_msg=OK, 
//			appid=wx810701ac2de85f26, 
//			code_url=weixin://wxpay/bizpayurl?pr=YiL9Owu, 
//				nonce_str=XFel3VM4hMlGKKzl, 
//				return_code=SUCCESS, 
//				trade_type=NATIVE}

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
	

}
