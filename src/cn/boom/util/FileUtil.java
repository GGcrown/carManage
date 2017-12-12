package cn.boom.util;

import java.io.File;
import java.util.Calendar;

/**
 * @author Crown
 * @ClassName FileUtil
 * @Description TODO
 * @email 1084961504@qq.com
 * @date 2017/12/12
 */
public class FileUtil {

    /**
     * 分日期创建文件夹存储图片
     *
     * @return
     */
    public static String mkCalendarDir() {
        // 日期获取年月日
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        // 月份从0开始实际要+1
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String pathName = "H:\\car_photo\\" + year + "\\" + month + "\\" + day+"\\";
        File file = new File(pathName);
        file.mkdirs();
        return pathName;
    }

    /**
     * 移动文件 默认临时文件夹路径--H:\car_photo\temp\
     *
     * @param fileName 文件名
     * @param filePath 文件路径
     * @return
     */
    public static boolean moveFile(String fileName, String filePath) {
        boolean flag = false;
        File tempFile = new File("H:\\car_photo\\temp\\" + fileName);
        System.out.println(tempFile.exists());
        File movefile = new File(filePath + fileName);
        // 文件存在
        if (tempFile.exists()) {
            tempFile.renameTo(movefile);
            flag = true;
        }
        return flag;
    }

}
