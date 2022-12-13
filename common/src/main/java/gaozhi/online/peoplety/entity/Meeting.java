package gaozhi.online.peoplety.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
* @description: TODO 会议
* @author http://gaozhi.online
* @date 2022/12/13 16:01
* @version 1.0
*/
@Data
@TableName("meeting")
public class Meeting {
    @TableId(type = IdType.AUTO)
    private Long id;
    @TableField("head_url")
    private String headUrl;
    private String name;
    private Long time;
}
