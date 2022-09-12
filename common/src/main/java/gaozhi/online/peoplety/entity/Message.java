package gaozhi.online.peoplety.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author LiFucheng
 * @version 1.0
 * @description: TODO  消息
 * @date 2022/7/16 12:11
 */
@Data
@NoArgsConstructor
public class Message {
    public static final long SERVER = -1;
    private static final AtomicLong ID = new AtomicLong(0);

    private long id;
    private int type;
    private int typeMsg;
    //消息来源
    private long fromId;
    //消息去向
    private long toId;
    //消息内容
    private String msg;
    //摘要
    private String remark;
    //消息时间
    private long time;

    public Message(int type, long fromId, long toId, String msg, String remark, long time) {
        this.type = type;
        this.fromId = fromId;
        this.toId = toId;
        this.msg = msg;
        this.remark = remark;
        this.time = time;
    }

    public static long generateId() {
        return ID.getAndAdd(1);
    }

    //消息类型
    public enum Type {
        //未知消息
        UNKNOWN(-1),
        //系统消息
        SYSTEM(0),
        //新评论
        NEW_COMMENT(1),
        //新粉丝
        NEW_FANS(2),
        //新派生
        NEW_EXTEND(3),
        //新收藏
        NEW_FAVORITE(4),
        //新朋友消息
        NEW_FRIEND_MESSAGE(5);
        private final int type;

        Type(int type) {
            this.type = type;
        }

        public int getType() {
            return type;
        }

        public static Type getType(int type) {
            for (Type e : Type.values()) {
                if (e.getType() == type) {
                    return e;
                }
            }
            return UNKNOWN;
        }
    }
}
