package alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;

/**   
* @author lzw   
* @date 2016年9月6日 下午5:26:41 
* @Description: 
* @version V1.0   
*/
public class 退款 {
	public static void main(String[] args) throws AlipayApiException {
		AlipayClient alipayClient = AlipayAPIClientFactory.getAlipayClient();
				AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();//创建API对应的request类
				request.setBizContent("{" +
				"    \"out_trade_no\":\"100004\"," +  //订单号
//				"    \"trade_no\":\"2014112611001004680073956707\"," +
				"    \"out_request_no\":\"1000001\"," +
				"    \"refund_amount\":\"0.04\"," +
				"    \"operator_id\":\"op001\",\"store_id\":\"pudong001\",\"terminal_id\":\"t_001\""+
				"  }"); //设置业务参数
				AlipayTradeRefundResponse response = alipayClient.execute(request);//通过alipayClient调用API，获得对应的response类
				// TODO 根据response中的结果继续业务逻辑处理
				System.out.println(response.getRefundFee());
	}

}
