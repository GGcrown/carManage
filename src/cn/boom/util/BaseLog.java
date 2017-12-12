package cn.boom.util;

import org.apache.log4j.Logger;

/**
 * @author Crown
 * @ClassName BaseLog
 * @Description TODO
 * @email 1084961504@qq.com
 * @date 2017/12/8
 */
public class BaseLog {

    private static Logger logger;

    public static Logger getLogger(Class clazz) {
        if (null == logger) {
            logger = Logger.getLogger(clazz);
        }
        return logger;
    }
}
