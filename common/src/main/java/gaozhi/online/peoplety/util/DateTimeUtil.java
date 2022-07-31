package gaozhi.online.peoplety.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author LiFucheng
 * @version 1.0
 * @description: TODO
 * @date 2021/10/23 1:05
 */
public class DateTimeUtil {
    private static final long _1h = 3600000;

    public static boolean isToday(long time) {
        //Calendar使用单例，多次调用不重复创建对象
        Calendar calendar = Calendar.getInstance();
        //使用System获取当前时间
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        long today = calendar.getTimeInMillis();
        if (time - today < _1h*24&&time-today>0)
            return true;
        return false;
    }

    private static final SimpleDateFormat defaultFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String getDefaultFormatTime(long time) {
        return defaultFormat.format(new Date(time));
    }
}
