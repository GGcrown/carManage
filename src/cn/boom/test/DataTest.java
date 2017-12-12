package cn.boom.test;

import cn.boom.util.FileUtil;
import org.junit.Test;

import java.io.File;
import java.util.Calendar;


/**
 * @author Crown
 * @ClassName DataTest
 * @Description TODO
 * @email 1084961504@qq.com
 * @date 2017/12/12
 */
public class DataTest {

    @Test
    public void date1Test() {
        // 日期获取年月日
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        // 日期从0开始实际要+1
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        File file = new File("H:\\car_photo\\" + year + "\\" + month + "\\" + day);
        System.out.println(month);
        // file.mkdirs();
    }

    @Test
    public void date2Test() {
        FileUtil fileUtil = new FileUtil();
        String dirPath = fileUtil.mkCalendarDir();
        System.out.println(dirPath);
    }

    @Test
    public void file1Test() {
        File file = new File("H:\\car_photo\\temp\\7347c8e7-1c3a-4adb-8108-17c754a246a0.jpg");
        System.out.println(file.exists());
        File file1 = new File("H:\\car_photo\\2017\\12\\12\\7347c8e7-1c3a-4adb-8108-17c754a246a0.jpg");
        // 文件存在
        if (file.exists()) {
            file.renameTo(file1);
        }

    }


}
