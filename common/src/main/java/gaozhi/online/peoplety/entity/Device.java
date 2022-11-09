package gaozhi.online.peoplety.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author http://gaozhi.online
 * @version 1.0
 * @description: TODO 硬件设备
 * @date 2022/11/5 20:22
 */
@Data
@TableName("device")
public class Device {
    /**
     * 硬件id
     */
    @TableId(type = IdType.AUTO)
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
     * 硬件端口
     */
    private int port;
    /**
     * 硬件最后一次上线时间
     */
    @TableField("last_online_time")
    private long lastOnlineTime;
    /**
     * 硬件注册时间
     */
    private long time;
}
