package gaozhi.online.peoplety.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author http://gaozhi.online
 * @version 1.0
 * @description: TODO 硬件设备类型
 * @date 2022/11/9 16:00
 */
@Data
@TableName("device_type")
public class DeviceType {
    /**
     * 硬件类型id
     */
    @TableId(type = IdType.AUTO)
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
