package gaozhi.online.peoplety.entity;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Data;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @author lfc
 * @title: Token
 * @projectName huan
 * @description: TODO token payload部分
 * @date 2021/10/19 18:10
 */
@Data
public class TokenClaims {
    /**
     * 设备类型
     */
    public enum Device {
        /**
         * 移动端
         */
        MOBILE(0),
        /**
         * 桌面端
         */
        COMPUTER(1),
        /**
         * web端
         */
        WEB(2);

        private final int device;

        Device(int device) {
            this.device = device;
        }

        public int getDevice() {
            return device;
        }

        public static Device getDevice(int device) {
            for (Device e : Device.values()) {
                if (e.getDevice() == device) {
                    return e;
                }
            }
            return null;
        }
    }

    /**
     * 用户ID
     */
    private long userid;
    /**
     * 设备类型
     */
    private int device;
    /**
     * 上次活动时间
     */
    private long lastOnline;
    /**
     * 过期时间
     */
    private long expireTime;


    private static final Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
    private static final Type type = new TypeToken<Map<String, String>>() {
    }.getType();

    public static Map<String, String> toMap(TokenClaims tokenClaims) {
        return gson.fromJson(gson.toJson(tokenClaims), type);
    }

    public static TokenClaims toTokenClaims(Map<String, String> claims) {
        String json = gson.toJson(claims);
        return gson.fromJson(json, TokenClaims.class);
    }

    public static void main(String[] args) {
        TokenClaims tokenClaims = new TokenClaims();
        tokenClaims.setDevice(100);
        toMap(tokenClaims).entrySet().forEach(new Consumer<Map.Entry<String, String>>() {
            @Override
            public void accept(Map.Entry<String, String> stringStringEntry) {
                System.out.println(stringStringEntry.getKey() + ":" + stringStringEntry.getValue());
            }
        });
        System.out.println(toTokenClaims(toMap(tokenClaims)));
    }
}
