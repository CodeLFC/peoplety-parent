package gaozhi.online.peoplety.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * @author gaozhi.online
 * @version 1.0
 * @description 字符串工具
 * @date 2021/2/5 0005
 */
public class StringUtil {
    private static final Gson gson = new Gson();
    /**
     * @return boolean
     * @description (Returns true if, and only if, length () is 0 or if is null.)
     * @author gaozhi.online
     * @date 2021/2/5 0005
     */
    public static boolean isEmpty(String arg) {
        if (arg != null) {
            return arg.isEmpty();
        }
        return true;
    }

    public static boolean isBlank(String arg) {
        if (arg != null) {
            return arg.isBlank();
        }
        return true;
    }

    public static boolean equals(String arg1, String arg2) {
        if (arg1 != null) {
            return arg1.equals(arg2);
        }
        return arg2 == null;
    }

    /**
     * 生成随机数
     *
     * @param len 随机数的长度
     */
    public static String random(int len) {
        int min = (int) Math.pow(10, len - 1);
        int max = (int) Math.pow(10, len);
        int random = (int) (Math.random() * max);
        if (random < min) {
            random *= 10;
        } else if (random >= max) {
            random /= 10;
        }
        return String.valueOf(random);
    }

    /**
     * @description: list转json
     * @param: list
     * @return: java.lang.String
     * @author LiFucheng
     * @date: 2022/8/2 17:01
     */
    public static <T> String list2Json(List<T> list) {
        return gson.toJson(list);
    }

    /**
     * @description: json转list
     * @param: json
     * @return: java.util.List<T>
     * @author LiFucheng
     * @date: 2022/8/2 17:01
     */
    public static <T> List<T> json2List(String json) {
        return gson.fromJson(json, new TypeToken<List<T>>() {
        }.getType());
    }
}
