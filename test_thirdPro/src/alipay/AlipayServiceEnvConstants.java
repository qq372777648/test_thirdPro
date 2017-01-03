

/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package alipay;

/**
 * 支付宝服务窗环境常量（demo中常量只是参考，需要修改成自己的常量值）
 * 
 * @author taixu.zqq
 * @version $Id: AlipayServiceConstants.java, v 0.1 2014年7月24日 下午4:33:49 taixu.zqq Exp $
 */
public class AlipayServiceEnvConstants {
	//-----------------------------沙箱------------------------
//    /**支付宝网关*/
//    public static final String ALIPAY_GATEWAY    = "https://openapi.alipaydev.com/gateway.do";
//	/** 服务窗appId  */
//    //TODO !!!! 注：该appId必须设为开发者自己的服务窗id  这里只是个测试id
//    public static final String APP_ID            = "2016072300103458";
//    
//  //开发者请使用openssl生成的密钥替换此处  请看文档：https://fuwu.alipay.com/platform/doc.htm#2-1接入指南
//    //TODO !!!! 注：该私钥为测试账号私钥  开发者必须设置自己的私钥 , 否则会存在安全隐患 
//    public static final String PRIVATE_KEY       = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBANIm1JEBh8E4lP1MXIVj7V/t3IVXCRZX6hCY3+QZ3C+eC28UemDDFjvdBvvsiE6gA0zjTnsHKh9NPSUdf1b7ToBA2mbcgPBrSoHIHdOC1kHeNtvNINcJ0Qim/FENtCqquSemlQSnIQZc/dyBh9j2bky05adStwlXxUYNnHuBDT55AgMBAAECgYBlJw2f8mWeqpaESZIrHosuZnaDs/4KxCxE6uCxkYT7Yo5MXEX/d0enbt8iuZpuhfSwuKSY8TzkLjBlQgp+Gp6QmxJ6qEX4EGDBF7JNZnTHaXvVQwvjKGZbm3BEXI2k9jCe+6RLVlTOD8cW3dR7QsZ2+IMnnN+9ZmIfX1sW3bPYVQJBAPxM5KNYiClqR3gSrTqB2tt3mtCdIlfQ0aUiZWfJb3hwmzsKen18D/f6eJm/f4e2LTc6e63kQnqqj9aSiS+MDMcCQQDVO7dCZWyUe+KhXVuP4bNVdxwvHu903xy095FRMTN77QN8qZK4JkUZ3Q5Ych1NsRrySzzIhzhloijdh8xZIJq/AkBvf//vXHnYa7qoCwD5gVfac/I8TaVWz9dGtnvAMVqNDJ7dqdTWThS0j8HqmKHgtRcoeDUedWkX0vb8aggstiUTAkEAn7iFQuS5+lb5oSlO5m2HaSM5J0qizwY4eI1gelLCX7dff0d9sRZpeEAO+M0xifp5VrhopUQ0SFy5A4cu2CwF/QJAIiyxoe9ZbAuc3akTLuvzDv97T9iNYh+2Ndw/J//N8s8E/EbF0SPJf7VrYGLLfVf7aLt63IxDvS27rK7SVshKPA==";
//    //TODO !!!! 注：该公钥为测试账号公钥  开发者必须设置自己的公钥 ,否则会存在安全隐患
//    public static final String PUBLIC_KEY        = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDSJtSRAYfBOJT9TFyFY+1f7dyFVwkWV+oQmN/kGdwvngtvFHpgwxY73Qb77IhOoANM4057ByofTT0lHX9W+06AQNpm3IDwa0qByB3TgtZB3jbbzSDXCdEIpvxRDbQqqrknppUEpyEGXP3cgYfY9m5MtOWnUrcJV8VGDZx7gQ0+eQIDAQAB";
//    /**支付宝公钥 填完公钥 支付宝自动生成*/
//    public static final String ALIPAY_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDIgHnOn7LLILlKETd6BFRJ0GqgS2Y3mn1wMQmyh9zEyWlz5p1zrahRahbXAfCfSqshSNfqOmAQzSHRVjCqjsAw1jyqrXaPdKBmr90DIpIxmIyKXv4GGAkPyJ/6FTFY99uhpiq0qadD/uSzQsefWo0aTvP/65zi3eof7TcZ32oWpwIDAQAB";
    
    
    //-----------------------dfim-----------------------
    /**支付宝网关*/
    public static final String ALIPAY_GATEWAY    ="https://openapi.alipay.com/gateway.do";
    /** 服务窗appId  */
    //TODO !!!! 注：该appId必须设为开发者自己的服务窗id  这里只是个测试id
    public static final String APP_ID            ="2015121000952402";// //"2015121000952402";

    //开发者请使用openssl生成的密钥替换此处  请看文档：https://fuwu.alipay.com/platform/doc.htm#2-1接入指南
    //TODO !!!! 注：该私钥为测试账号私钥  开发者必须设置自己的私钥 , 否则会存在安全隐患 
    public static final String PRIVATE_KEY       = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAM3IY3vNBKfsgLjykM+PQK015ttHiTn1K2zcgY/PbzwYDtN2a4GowB+gi2ZB3QuUyTyr2tZ4yGBc0emCGIvAPeQRUA0+ffV2teTFQ49vUqgxjH/EYlcieORWyIuMZGtbL7mVSylIBlElL60ySV6Z6YJ2Mfz6D7e1hFX95wosw9hdAgMBAAECgYBnJ1BXOspesvtDurREl3bAXQjAWve7Cd8eztpTkJQd96FW90Gk2UaVlBDMza9UotzNgQhOAnXPeDfxabmMNG3RAkMX6l5FWX4BcJ7J6x5qBWA3wB9NLtfpzGc2pT2356e2VEk1dRab16LL8YQOxj7xuuBS/C1z4L0NQ26vgZxCgQJBAP9FoAJ0j5T0dR00xktz5KrPN96Bo2oE2y03h8gXI2lF7uFg4gbTxV5V5ImQAJX+TJxRDHeZxME2tEk9wPnOv9UCQQDOXqGevEESYs/jpzgHSNufWKeuVwtyl7B7IXbf2nj++fwbfzoFSbqzkSkoxVWU2KoR+AWjl1Tvnthny9Sm2YJpAkAiQdq+WZwnNkM9PybZW101mwd5YdZnVO2A/PHI5WoIJ61uK41Js0PKbCZ2W4/okS8Az1On/UfNUiURqyrpm1hdAkEAuSVjYNNKmiE2m+rRNI/kIhDa12nWpmd6+O0sBmeueCt1SIIbXtUoAKQyRhbM0i6UXmyjOoKxvA1J382aKlsoSQJAOO9gxRbnyA3saOYcaWLzIMukI6wjyfvTsKD+BruPf54PScESFHespNTKCdXmjQ1IeMvN6N8GrrxFiarioSF6PA==";

    //TODO !!!! 注：该公钥为测试账号公钥  开发者必须设置自己的公钥 ,否则会存在安全隐患
    public static final String PUBLIC_KEY        = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDNyGN7zQSn7IC48pDPj0CtNebbR4k59Sts3IGPz288GA7TdmuBqMAfoItmQd0LlMk8q9rWeMhgXNHpghiLwD3kEVANPn31drXkxUOPb1KoMYx/xGJXInjkVsiLjGRrWy+5lUspSAZRJS+tMklememCdjH8+g+3tYRV/ecKLMPYXQIDAQAB";
    /**支付宝公钥-从支付宝服务窗获取*/
    public static final String ALIPAY_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDI6d306Q8fIfCOaTXyiUeJHkrIvYISRcc73s3vF1ZT7XN8RNPwJxo8pWaJMmvyTn9N4HQ632qJBVHf8sxHi/fEsraprwCtzvzQETrNRwVxLO5jVmRGi60j8Ue1efIlzPXV9je9mkjzOmdssymZkh2QhUrCmZYI/FCEa3/cNMW0QIDAQAB";
//-----------------------------
    
    
    
	

    /**支付宝公钥-从支付宝服务窗获取*/
//    public static final String ALIPAY_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDI6d306Q8fIfCOaTXyiUeJHkrIvYISRcc73s3vF1ZT7XN8RNPwJxo8pWaJMmvyTn9N4HQ632qJBVHf8sxHi/fEsraprwCtzvzQETrNRwVxLO5jVmRGi60j8Ue1efIlzPXV9je9mkjzOmdssymZkh2QhUrCmZYI/FCEa3/cNMW0QIDAQAB";

    
    public static final String ALIPAY_PUBLIC_KEY_MOBILE = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";
    /**签名编码-视支付宝服务窗要求*/
    public static final String SIGN_CHARSET      = "GBK";

    /**字符编码-传递给支付宝的数据编码*/
    public static final String CHARSET           = "UTF-8";

    /**签名类型-视支付宝服务窗要求*/
    public static final String SIGN_TYPE         = "RSA";
    
    
    public static final String PARTNER           = "2088701644310231";
    
    public static final String PARTNER_MOBILE           = "2088211537714113";

    

    


    /**授权访问令牌的授权类型*/
    public static final String GRANT_TYPE        = "authorization_code";
}