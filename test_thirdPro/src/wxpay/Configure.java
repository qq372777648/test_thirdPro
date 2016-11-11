package wxpay;

/**
 * User: rizenguo
 * Date: 2014/10/29
 * Time: 14:40
 * 这里放置各种配置数据
 */
public class Configure {

	//sdk的版本号
	private static final String sdkVersion = "1.0";
	
	//调用微信支付API的机器IP
	public static final String WXPAY_IP = "121.14.36.51";

	//TODO 接收微信支付异步通知回调地址
	public static String NOTIFY_URL = "http://music1.zhenxian.fm/interfacetest/wxorder/result";
	public static String HOST_URL = "http://music1.zhenxian.fm/interfacetest/";
	public static String MEMCACHED_SERVERS = "";
	
	//手机登录页面
	public static String LOGIN_URL = "http://if2.zhenxian.fm/activity/login.jsp";
	
	//免费流媒体套餐领用券限额
	public static int FREE_STREAM_MEDIA_COUNT = 1000;
	
	//免费流媒体套餐领用卷分派时间
	public static String FREE_STREAM_MEDIA_TIME = "20:00:00";
	
	//小米合作协议终结时间
    public static String XIAOMI_ENDTIME = "2016-12-25";
    
    //海贝合作协议终结时间
    public static String HIBY_ENDTIME = "2018-03-31";

	public static final String NATIVE = "NATIVE";
	
	public static final String APP = "APP";
	
	public static final String WX_PACKAGE = "Sign=WXPay";

	// 每次自己Post数据给API的时候都要用这个key来对所有字段进行签名，生成的签名会放在Sign这个字段，API收到Post数据的时候也会用同样的签名算法对Post过来的数据进行签名和验证
	// 收到API的返回的时候也要用这个key来对返回的数据算下签名，跟API的Sign数据进行比较，如果值不一致，有可能数据被第三方给篡改

	private static String key = "lzw8888888888888888888888888888";//dfim

	//微信分配的公众号ID（开通公众号之后可以获取到）
	private static String appID = "wx810701ac2de85f26";
	private static String appsecret="8189fbadcc519a2dab35d19a5decbe2a";
	private static String token="dfim";

	private static String appIDMobile = "wx6fd6152987f72d55";
	private static String appsecretMobile="d469ca6cf50f0821f865c796ee1f7de6";
	
	private static String appIDMobileHD = "wxd2da5d983e738fd2";
    private static String appsecretMobileHD="1067f928935912fe274d3bb48e24c015";
	//微信支付分配的商户号ID（开通公众号的微信支付功能之后可以获取到）
	private static String mchID = "10033336";
	
	private static String mchIDMobile = "1267519601";
	
	private static String mchIDMobileHD = "1362431502";
	
	//小米支付的相关配置（AppId,AppKey 和 AppSecret）
	/*private static String xiaomiAppId = "2882303761517414080";
	private static String xiaomiAppKey = "5471741487080" ; 
	private static String xiaomiAppSecret = "hjP6LNAxERKQPIyPe9RXsQ==" ;*/
	public static String XIAOMI_RSA_PUBLIC_Key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCw0egKHkz59Ahb/8e1DSWndQawUj/giQNuGPse199Xrf9LrOwSLMz7GerbrH+rm07T8/IqbAeeHflnodfiEgzXQ71CMDMyrpNUfotMX4iZrHaaENr0WeStVsX5HFrtUs030ZzoS6D93X5dEg/k8NzY5aB34c1OTgL7inC6SeNpUQIDAQAB";
	public static String MY_XIAOMI_RSA_PRIVATE_KEY = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAO8Bnvmu1YZEAtshhOkFe0IbScxZyooyBVq+lfK2zYTElemNrns1g1c+l+nXmhjHpbPysSCWOYjdlXbXOiq0M46iVl1XsKHL0oOfBz/UPB4Zedvy4LoFlKHP4LUveQk9DQL9zlRI/jkGZXDVMefYR7tl2whAuOeNpP2FFpD35L0fAgMBAAECgYA6TYftWpPl2+NidyvH+DlYJ/X5rpG04nzh5QoJGkTKNXZocdJ1ZdlzR+ag+aIyl0k5u2MwEtVYKM2UHu6miizlDs807mA4BoMA89TxnacgwflGXBJun5+KVI6bSrHn9boHKjtA8qKMKKQkbLGWgHhmQKe5JgFvIj5ErOVQEwdl0QJBAPllIGK0HhMjBSDzIuNbXu6cdzAgDBpJLuI3JxPu1hVNQ21hbiidmRUpX8E5CQ5idiaGr9zCBQWEQ9rwHrOJ1QcCQQD1Vg9oGfzxuTDIs2tY2sBVsvhEXYQDHpTLWPKyTJZYgkKUFe3tNTuaDhOH15N6gTGRBzrRnLahFe8MpXphUKkpAkBr9KOFNnTCUel5buYORtIcNey+D1FN25oI4FjxHvTa+bwTUBaQTFAkwekqShcqe+KrIKhlxjLIRY3d6w1PKH3nAkEApKFtkUPvMx48mFGd9XBFpLyGUQoX7if1XUeBBRjTwu0WVF0q3gTczBIqFPwaoRhU9KdPVx28h/g6A9h/eRIxkQJBAOFOlS5aYN8fuGmM2wAT5k0EPuYmdF+7euZEcqo1RK84ZMh3F7UbsrqmDT7uyKX2GkjpFmr1vAsHwXuZLjwUIbY=";
	
	//当贝支付的相关配置
	public static String DB_APPKEY = "a35232e39bc60128a04ffb89890919c5";
	public static String DB_NEWAPPKEY = "4274d05c4271d1632d6a5d31";
	
	//康佳支付的相关配置
    public static String KK_PARTNERKEY = "5ed1a3d8981bb9137ded18c570d47525";
    
    public static String KK_NOTIFY_URL = HOST_URL+"pay/kkcallback";
    
    public static String ALITV_NOTIFY_URL = HOST_URL+"pay/alitvcallback";
    
    //阿里大鱼短信相关配置
    public static String SMS_URL = "http://gw.api.taobao.com/router/rest";
    
    public static String SMS_APPID = "23319619";
    
    public static String SMS_APPKEY = "876a5c0e5f1192d77ed31bb797923637";
    
    public static String SMS_APPTEMPLATECODE = "SMS_6765953";
    
    public static String SMS_SIGN = "HIFI音乐";
    
    public static String SMS_CMX_APPTEMPLATECODE = "SMS_10200194";
    
    public static String SMS_CMX_SIGN = "HiFi车梦响";
    
	//受理模式下给子商户分配的子商户号
	private static String subMchID = "";

	//HTTPS证书的本地路径
	private static String certLocalPath = "";

	//HTTPS证书密码，默认密码等于商户号MCHID
	private static String certPassword = "";

	//是否使用异步线程的方式来上报API测速，默认为异步模式
	private static boolean useThreadToDoReport = true;

	//机器IP
	private static String ip = "";
	
	//货币类型
	public static String FREE_TYPE = "CNY";

	//以下是几个API的路径：
	//1）被扫支付API
	public static String PAY_API = "https://api.mch.weixin.qq.com/pay/micropay";

	//2）订单查询API
	public static String PAY_QUERY_API = "https://api.mch.weixin.qq.com/pay/orderquery";

	//3）退款API
	public static String REFUND_API = "https://api.mch.weixin.qq.com/secapi/pay/refund";

	//4）退款查询API
	public static String REFUND_QUERY_API = "https://api.mch.weixin.qq.com/pay/refundquery";

	//5）撤销API
	public static String REVERSE_API = "https://api.mch.weixin.qq.com/secapi/pay/reverse";

	//6）下载对账单API
	public static String DOWNLOAD_BILL_API = "https://api.mch.weixin.qq.com/pay/downloadbill";

	//7) 统计上报API
	public static String REPORT_API = "https://api.mch.weixin.qq.com/payitil/report";
	
	//8) 关闭订单
	public static String PAY_CLOSE_API = "https://api.mch.weixin.qq.com/pay/closeorder";
	
	//8) 统一下单
	public static String UNIFY_PAY_API = "https://api.mch.weixin.qq.com/pay/unifiedorder";

	public static String getSdkversion() {
		return sdkVersion;
	}

	public static String getWxpayIp() {
		return WXPAY_IP;
	}

	public static String getNOTIFY_URL() {
		return NOTIFY_URL;
	}

	public static String getHOST_URL() {
		return HOST_URL;
	}

	public static String getMEMCACHED_SERVERS() {
		return MEMCACHED_SERVERS;
	}

	public static String getLOGIN_URL() {
		return LOGIN_URL;
	}

	public static int getFREE_STREAM_MEDIA_COUNT() {
		return FREE_STREAM_MEDIA_COUNT;
	}

	public static String getFREE_STREAM_MEDIA_TIME() {
		return FREE_STREAM_MEDIA_TIME;
	}

	public static String getXIAOMI_ENDTIME() {
		return XIAOMI_ENDTIME;
	}

	public static String getHIBY_ENDTIME() {
		return HIBY_ENDTIME;
	}

	public static String getNative() {
		return NATIVE;
	}

	public static String getApp() {
		return APP;
	}

	public static String getWxPackage() {
		return WX_PACKAGE;
	}

	public static String getKey() {
		return key;
	}

	public static String getAppID() {
		return appID;
	}

	public static String getAppsecret() {
		return appsecret;
	}

	public static String getToken() {
		return token;
	}

	public static String getAppIDMobile() {
		return appIDMobile;
	}

	public static String getAppsecretMobile() {
		return appsecretMobile;
	}

	public static String getAppIDMobileHD() {
		return appIDMobileHD;
	}

	public static String getAppsecretMobileHD() {
		return appsecretMobileHD;
	}

	public static String getMchID() {
		return mchID;
	}

	public static String getMchIDMobile() {
		return mchIDMobile;
	}

	public static String getMchIDMobileHD() {
		return mchIDMobileHD;
	}

	public static String getXIAOMI_RSA_PUBLIC_Key() {
		return XIAOMI_RSA_PUBLIC_Key;
	}

	public static String getMY_XIAOMI_RSA_PRIVATE_KEY() {
		return MY_XIAOMI_RSA_PRIVATE_KEY;
	}

	public static String getDB_APPKEY() {
		return DB_APPKEY;
	}

	public static String getDB_NEWAPPKEY() {
		return DB_NEWAPPKEY;
	}

	public static String getKK_PARTNERKEY() {
		return KK_PARTNERKEY;
	}

	public static String getKK_NOTIFY_URL() {
		return KK_NOTIFY_URL;
	}

	public static String getALITV_NOTIFY_URL() {
		return ALITV_NOTIFY_URL;
	}

	public static String getSMS_URL() {
		return SMS_URL;
	}

	public static String getSMS_APPID() {
		return SMS_APPID;
	}

	public static String getSMS_APPKEY() {
		return SMS_APPKEY;
	}

	public static String getSMS_APPTEMPLATECODE() {
		return SMS_APPTEMPLATECODE;
	}

	public static String getSMS_SIGN() {
		return SMS_SIGN;
	}

	public static String getSMS_CMX_APPTEMPLATECODE() {
		return SMS_CMX_APPTEMPLATECODE;
	}

	public static String getSMS_CMX_SIGN() {
		return SMS_CMX_SIGN;
	}

	public static String getSubMchID() {
		return subMchID;
	}

	public static String getCertLocalPath() {
		return certLocalPath;
	}

	public static String getCertPassword() {
		return certPassword;
	}

	public static boolean isUseThreadToDoReport() {
		return useThreadToDoReport;
	}

	public static String getIp() {
		return ip;
	}

	public static String getFREE_TYPE() {
		return FREE_TYPE;
	}

	public static String getPAY_API() {
		return PAY_API;
	}

	public static String getPAY_QUERY_API() {
		return PAY_QUERY_API;
	}

	public static String getREFUND_API() {
		return REFUND_API;
	}

	public static String getREFUND_QUERY_API() {
		return REFUND_QUERY_API;
	}

	public static String getREVERSE_API() {
		return REVERSE_API;
	}

	public static String getDOWNLOAD_BILL_API() {
		return DOWNLOAD_BILL_API;
	}

	public static String getREPORT_API() {
		return REPORT_API;
	}

	public static String getPAY_CLOSE_API() {
		return PAY_CLOSE_API;
	}

	public static String getUNIFY_PAY_API() {
		return UNIFY_PAY_API;
	}
	
	
	

}
