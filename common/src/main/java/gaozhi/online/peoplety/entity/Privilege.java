package gaozhi.online.peoplety.entity;

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
    @TableId
    private String url;
    private String name;
    private String description;
}
