package wxpay;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;

public class LogUtil {

	private static final Log dfLogger = LogFactory.getLog("wxpay");
	private static final Log resLogger = LogFactory.getLog("wxpayres");
    public static final String LOG_TYPE_TRACE = "trace";
    public static final String LOG_TYPE_DEBUG = "debug";
    public static final String LOG_TYPE_INFO = "info";
    public static final String LOG_TYPE_WARN = "warn";
    public static final String LOG_TYPE_ERROR = "error";
	
    private Logger logger;
    
    public LogUtil(Logger log){
        logger = log;
    }
    public void t(String s){
        logger.trace(s);
    }

    public void d(String s){
        logger.debug(s);
    }

    public void i(String s){
        logger.info(s);
    }

    public void w(String s){
        logger.warn(s);
    }

    public void e(String s){
        logger.error(s);
    }

    public void log(String type,String s){
        if(type.equals(LogUtil.LOG_TYPE_TRACE)){
            t(s);
        }else if(type.equals(LogUtil.LOG_TYPE_DEBUG)){
            d(s);
        }else if(type.equals(LogUtil.LOG_TYPE_INFO)){
            i(s);
        }else if(type.equals(LogUtil.LOG_TYPE_WARN)){
            w(s);
        }else if(type.equals(LogUtil.LOG_TYPE_ERROR)){
            e(s);
        }
    }
	
    public static void info(Object s){
    	dfLogger.info(s);
    }
    
    public static void infoRes(Object s){
    	resLogger.info(s);
    }
    
	public static void Error2LogUtils(Exception e) {
		StringBuilder em = new StringBuilder();
		for(StackTraceElement es:e.getStackTrace()){
			em.append("\t\t").append(es.toString()).append("\r\n"); 
		}
		dfLogger.info(em.toString());
	}
	
}
