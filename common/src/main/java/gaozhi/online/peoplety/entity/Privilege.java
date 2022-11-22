package gaozhi.online.peoplety.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
* @description: TODO 权限
* @author http://gaozhi.online
* @date 2022/11/21 22:02
* @version 1.0
*/
@Data
@TableName("privilege")
public class Privilege {
    /**总URL*/
    @TableId
    private String url;
    /**一级URL*/
    @TableField("first_url")
    private String firstUrl;
    /**二级URL*/
    @TableField("sub_url")
    private String subUrl;
    /**权限名*/
    private String name;
    /**权限描述*/
    private String description;
}
