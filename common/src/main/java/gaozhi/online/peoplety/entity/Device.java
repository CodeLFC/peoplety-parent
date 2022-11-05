package gaozhi.online.peoplety.entity;

import lombok.Data;

/**
 * @author http://gaozhi.online
 * @version 1.0
 * @description: TODO 硬件设备
 * @date 2022/11/5 20:22
 */
@Data
public class Device {
    /**
     * 硬件id
     */
    private long id;
    /**
     * 硬件类型
     */
    private int type;
    /**
     * 硬件所属用户
     */
    private long userid;
    /**
     * 硬件名称
     */
    private String name;
    /**
     * 硬件备注
     */
    private String remark;
    /**
     * 硬件归属ip地址
     */
    private String ip;
    /**
     * 硬件最后一次上线时间
     */
    private long lastOnlineTime;
    /**
     * 硬件注册时间
     */
    private long time;

    /**
     * @author http://gaozhi.online
     * @version 1.0
     * @description: TODO 设备类型
     * @date 2022/11/5 20:30
     */
    public static class Type {
        /**
         * 硬件类型id
         */
        private int id;
        /**
         * 硬件品牌
         */
        private String brand;
        /**
         * 硬件版本类型
         */
        private String version;
        /**
         * 硬件收录时间
         */
        private String time;
    }
}
