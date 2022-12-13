package gaozhi.online.peoplety.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author LiFucheng
 * @version 1.0
 * @description: TODO  用户身份及权限
 * @date 2022/5/2 10:23
 */
@TableName("status")
@Data
public class Role {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer grade;
    private String name;
    private String privileges;
    private String description;
    @TableField("create_time")
    private Long createTime;
    private Boolean enable;
}
