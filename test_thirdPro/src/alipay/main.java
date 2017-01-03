/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package alipay;

import java.text.SimpleDateFormat;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;

public class main {

	public static void main(String[] args) {
		
		
		AlipayClient alipayClient = AlipayAPIClientFactory.getAlipayClient();
		
		
				AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();//创建API对应的request类
//				request.setBizContent("{" +
//				"    \"out_trade_no\":\"20150320010101002\"," +
//				"    \"total_amount\":0.01," +
//				"    \"subject\":\"Iphone6 16G\"," +
////				"    \"store_id\":\"NJ_001\"," +
//				"    \"timeout_express\":\"90m\"," +
//				"  }");//设置业务参数
				
				String out_trade_no = 100230095+"";
		        String total_amount = "0.03";
		        String subject = "subject标题2";
		        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		        String time_expire= sdf.format(System.currentTimeMillis()+24*60*60*1000);
		        
		        StringBuilder sb = new StringBuilder();
		        sb.append("{\"out_trade_no\":\"" + out_trade_no + "\",");
		        sb.append("\"total_amount\":\""+total_amount+"\",\"discountable_amount\":\"0.00\",");
		        sb.append("\"subject\":\""+subject+"\",\"body\":\""+subject+"\",");
		        sb.append("\"goods_detail\":[],");
		        sb.append("\"operator_id\":\"op009\",\"store_id\":\"shop009\",\"terminal_id\":\"mac009\",");//任意
		        sb.append("\"time_expire\":\""+time_expire+"\"}");
		        request.setBizContent(sb.toString());
		        request.setNotifyUrl("http://15105u8z38.iask.in/TradePayDemo/callBack");//成功支付回调
				
				
				try {
					AlipayTradePrecreateResponse response = alipayClient.execute(request);
		            if (null != response && response.isSuccess()) {
		                if (response.getCode().equals("10000")) {
		                    System.out.println("商户订单号："+response.getOutTradeNo());
		                    System.out.println("二维码值："+response.getQrCode());//商户将此二维码值生成二维码，然后展示给用户，用户用支付宝手机钱包扫码完成支付
		                    //二维码的生成，网上有许多开源方法，可以参看：http://blog.csdn.net/feiyu84/article/details/9089497
		                    try {
								QrcodeTest.create_image(response.getQrCode());
							} catch (Exception e) {
								e.printStackTrace();
							}
		                } else {

		                //打印错误码
		                System.out.println("错误码："+response.getSubCode());
		                System.out.println("错误描述："+response.getSubMsg());
		                }
		            }
				} catch (AlipayApiException e) {
					e.printStackTrace();
				}
		
		
		
		
		
		
		
		
		
		
		
		
		
//		String out_trade_no="";// order no
//		String total_amount="";//付款额
//		
//		
//        StringBuilder sb = new StringBuilder();
//        sb.append("{\"out_trade_no\":\"" + out_trade_no + "\",");
//        sb.append("\"total_amount\":\""+total_amount+"\",\"discountable_amount\":\"0.00\",");
//        sb.append("\"subject\":\""+subject+"\",\"body\":\""+subject+"\",");
//        sb.append("\"goods_detail\":[],");
//        sb.append("\"operator_id\":\"op001\",\"store_id\":\"pudong001\",\"terminal_id\":\"t_001\",");
//        sb.append("\"time_expire\":\""+time_expire+"\"}");
//        //System.out.println(sb.toString());
//
//        AlipayClient alipayClient = AlipayAPIClientFactory.getAlipayClient();
//        // 使用SDK，构建群发请求模型
//        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
//        request.setBizContent(sb.toString());
//        request.setNotifyUrl("http://15105u8z38.iask.in/TradePayDemo/"+"/notify_url.jsp");
//        AlipayTradePrecreateResponse response = null;
//        try {
//
//            // 使用SDK，调用交易下单接口
//            response = alipayClient
//                    .execute(request);
//            // 这里只是简单的打印，请开发者根据实际情况自行进行处理
//            if (null != response && response.isSuccess()) {
//                if (response.getCode().equals("10000")) {
//                   // System.out.println("商户订单号："+response.getOutTradeNo());
//                   // System.out.println("二维码值："+response.getQrCode());//商户将此二维码值生成二维码，然后展示给用户，用户用支付宝手机钱包扫码完成支付
//                    //二维码的生成，网上有许多开源方法，可以参看：http://blog.csdn.net/feiyu84/article/details/9089497
//                    resultMap.put("alipayQRCode", response.getQrCode());
//                } else {
//
//                //打印错误码
//                //System.out.println("错误码："+response.getSubCode());
//                //System.out.println("错误描述："+response.getSubMsg());
//                }
//            }
//        } catch (AlipayApiException e) {
//            e.printStackTrace();
//        }
	}
}
