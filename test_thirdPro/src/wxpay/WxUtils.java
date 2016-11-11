package wxpay;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class WxUtils {
	/**
	 * 输出字符串
	 */
	public static void out(String str, HttpServletResponse response) {
		Writer out = null;
		try {
			response.setContentType("text/xml;charset=UTF-8");
			out = response.getWriter();
			out.append(str);
			out.flush();
		} catch (IOException e) {
			// ignore
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					// ignore
				}
			}
		}
	}

	/**
	 * 解析请求中的xml元素为Map
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> parseXml(InputStream in)
			throws DocumentException, IOException {
		Map<String, String> map = new HashMap<String, String>();
		SAXReader reader = new SAXReader();
		Document document = reader.read(in);
		Element root = document.getRootElement();
		List<Element> elementList = root.elements();
		for (Element e : elementList) {
			map.put(e.getName(), e.getText());
		}
		return map;
	}
	
	public static Map<String,String> str2Xml(String xmlStr) throws DocumentException{
		Map<String,String> map = new HashMap<String,String>();
		Document doc = DocumentHelper.parseText(xmlStr);
		Element root = doc.getRootElement();
		List<Element> elemList = root.elements();
		for(Element e:elemList){
			map.put(e.getName(),e.getText());
		}
		return map;
	}
	
    public static String getSign(Map<String,String> map){
        ArrayList<String> list = new ArrayList<String>();
        for(Map.Entry<String,String> entry:map.entrySet()){
            if(!"".equals(entry.getValue())){
                list.add(entry.getKey() + "=" + entry.getValue() + "&");
            }
        }
        int size = list.size();
        String [] arrayToSort = list.toArray(new String[size]);
        Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i ++) {
            sb.append(arrayToSort[i]);
        }
        String result = sb.toString();
        result += "key=" + Configure.getKey();
        result = MD5.MD5Encode(result).toUpperCase();
        return result;
    }

	public static String map2Xml(Map<String, String> unifyPayReqData) {
		StringBuilder sb = new StringBuilder("<xml>");
		for(Map.Entry<String,String> entry :unifyPayReqData.entrySet()){
			sb.append("<"+entry.getKey()+"><![CDATA["+entry.getValue()+"]]></"+entry.getKey()+">");
		}
		sb.append("</xml>");
		return sb.toString();
	}
	
    /**
     * 获取一定长度的随机字符串
     * @param length 指定字符串长度
     * @return 一定长度的字符串
     */
    public static String getRandomStringByLength(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
	
	public static void main(String[] args) throws DocumentException{
		String soap = "<xml><result>sdds</result><sfd>dd</sfd></xml>";
		System.out.println(str2Xml(map2Xml(str2Xml(soap))));
	}
}
