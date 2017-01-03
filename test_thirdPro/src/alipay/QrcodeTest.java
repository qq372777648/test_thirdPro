package alipay;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;

/**
 * @auther Lzw   e-mail:372777648@qq.com
 * @date 2016��6��21��
 * <p>Description: <��p>
 */

public class QrcodeTest {
     static int width = 140;  
     static int height = 140;  

      public QrcodeTest()  
      {  
      }  	

      public static void create_image(String sms_info)throws Exception{  
       try{  
             Qrcode testQrcode =new Qrcode();  
                 testQrcode.setQrcodeErrorCorrect('M');  
                 testQrcode.setQrcodeEncodeMode('B');  
                 testQrcode.setQrcodeVersion(7);  
                 String testString = sms_info;  
                 byte[] d = testString.getBytes("gbk");  
                 BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);  
                 Graphics2D g = bi.createGraphics();  
                 g.setBackground(Color.WHITE);  
                 g.clearRect(0, 0, width, height);  
                 g.setColor(Color.BLACK);  

                 // ��������ֽ���Ϊ119  
                 if (d.length>0 && d.length <120){  
                     boolean[][] s = testQrcode.calQrcode(d);  
                     for (int i=0;i<s.length;i++){  
                         for (int j=0;j<s.length;j++){  
                             if (s[j][i]) {  
                                 g.fillRect(j*3+3,i*3+2,3,3); //��ά���Сλ�õ��� 
                             }  
                         }  
                     }  
                 }  
                 g.dispose();  
                 bi.flush();  
                 File f = new File("E:\\db.png");  
                 if(!f.exists()) f.createNewFile();  
                 ImageIO.write(bi, "jpg", f);  
             }  
             catch (Exception e) {  
                 e.printStackTrace();  
             }   
      }  

      public static void main(String[] args) throws Exception {  
          long start = System.currentTimeMillis();  
          String string = "https://qr.alipay.com/bax08554lmvmwtmgkfgo8080";  
          string="weixin://wxpay/bizpayurl?pr=iZaX5ib";
          string="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx810701ac2de85f26&redirect_uri=http://if2.zhenxian.fm/interfacetest2/wx/wxQrCallback&response_type=code&scope=snsapi_userinfo&state=1479974363353BAND47285806-21fb-3939-ba72-f2f6cc8c70a8#wechat_redirect";
          string="https://h5.koudaitong.com/v2/goods/1yjzjzus4buly";
          
          QrcodeTest.create_image(string);  
             long end = System.currentTimeMillis();  
             long last = end  - start;  
             System.out.println("time consume:" + last);  
         }   

}



