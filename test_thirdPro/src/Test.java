import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**   
* @author lzw   
* @date 2016年11月10日 下午3:25:44 
* @Description: 
* @version V1.0   
*/
public class Test {
	public static void main(String[] args) {
		Date start=null;
		Date end=null;
		Date now=null;
		try {
			start = new SimpleDateFormat("yyyy-MM-dd").parse("2016-11-11");
			end = new SimpleDateFormat("yyyy-MM-dd").parse("2016-11-14");
			now = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2016-11-10 23:59:59");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(now);
		
		System.out.println(now.before(end));
		System.out.println(now.after(start));
		
		if(!(now.before(end)&&now.after(start))){
			System.out.println("not start or overdue");
		}
	}

}
