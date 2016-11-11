package wxpay;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;

public class WxPayResultService extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public WxPayResultService() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			LogUtil.infoRes("WxPay Res Post Request ");
			Map<String, String> reqParamMap = WxUtils.parseXml(request.getInputStream());
			Map<String, String> resParamMap = new HashMap<String, String>();
			LogUtil.infoRes("WxPay Res Post Param "+reqParamMap);
			String return_code = reqParamMap.get("return_code");
			if(!"SUCCESS".equals(return_code)){
				LogUtil.infoRes("WxPay Res Not SUCCESS ");
				resParamMap.put("return_code", reqParamMap.get("return_code"));
				resParamMap.put("return_msg", reqParamMap.get("return_msg"));
			}else if(!checkSign(reqParamMap)){
				LogUtil.infoRes("WxPay Res Sign Not Right");
				resParamMap.put("return_code", "FAIL");
				resParamMap.put("return_msg", reqParamMap.get("签名失败"));
			}else {
				String appid = reqParamMap.get("appid");
				String mch_id = reqParamMap.get("mch_id");
//				if ((Configure.getAppid().equals(appid) && Configure.getMchid().equals(mch_id)) 
//				        || (Configure.getAppIDMobile().equals(appid) && Configure.getMchIDMobile().equals(mch_id))
//				        || (Configure.getAppIDMobileHD().equals(appid) && Configure.getMchIDMobileHD().equals(mch_id))) {
//                    resParamMap.put("return_code", "SUCCESS");
//				} else {
//				    LogUtil.infoRes("WxPay Res Param Not Right : 参数格式校验错误");
                    resParamMap.put("return_code", "FAIL");
//                    resParamMap.put("return_msg", reqParamMap.get("参数格式校验错误"));
//				}
			}
			LogUtil.infoRes("WxPay Res END :"+resParamMap);
			WxUtils.out(WxUtils.map2Xml(resParamMap), response);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static boolean checkSign(Map<String, String> reqParamMap) {
		String sign = reqParamMap.get("sign");
		if(sign == null || sign.trim() == ""){
			return false;
		}
		reqParamMap.put("sign", "");
		String newSign = WxUtils.getSign(reqParamMap);
		if(newSign.equals(sign)){
			return true;
		}
		return false;
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}
//	{is_subscribe=Y, appid=wx810701ac2de85f26, fee_type=CNY, nonce_str=lzl7podze9nb, out_trade_no=9939912325323, transaction_id=4005982001201611109301046814, trade_type=NATIVE, result_code=SUCCESS, sign=AE7F2A352C2F7D03E06D7B38E962402E, mch_id=10033336, total_fee=2, time_end=20161110144536, openid=oXikOuO3BARE3WBVNkOvQ__AvA9w, bank_type=CFT, return_code=SUCCESS, cash_fee=2}

	

//	public static void main(String[] args){
//			Map<String, String> reqParamMap = new HashMap<String, String>();
//			reqParamMap.put("is_subscribe", "Y");
//			reqParamMap.put("appid", "wx810701ac2de85f26");
//			reqParamMap.put("fee_type", "CNY");
//			reqParamMap.put("nonce_str", "fzoqggjkjdf3");
//			reqParamMap.put("out_trade_no", "20");
//			reqParamMap.put("transaction_id", "1009080184201502280022632425");
//			reqParamMap.put("trade_type", "NATIVE");
//			reqParamMap.put("result_code", "SUCCESS");
//			reqParamMap.put("sign", "Y");
//			reqParamMap.put("mch_id", "10033336");
//			reqParamMap.put("total_fee", "1");
//			reqParamMap.put("time_end", "20150228135943");
//			reqParamMap.put("openid", "oXikOuJc1bgzecOWkFImB838QjVU");
//			reqParamMap.put("bank_type", "CITIC_CREDIT");
//			reqParamMap.put("return_code", "SUCCESS");
//			reqParamMap.put("cash_fee", "1");
//			Map<String, String> resParamMap = new HashMap<String, String>();
//				String appid = reqParamMap.get("appid");
//				String mch_id = reqParamMap.get("mch_id");
//				if((!Configure.getAppid().equals(appid)) || (!Configure.getMchid().equals(mch_id))){
//					resParamMap.put("return_code", "FAIL");
//					resParamMap.put("return_msg", reqParamMap.get("参数格式校验错误"));
//				}else{
//					WxPayHelper.saveRes2Db(reqParamMap);
//					resParamMap.put("return_code", "SUCCESS");
//				}
//			System.out.println(resParamMap);
//	}
}
