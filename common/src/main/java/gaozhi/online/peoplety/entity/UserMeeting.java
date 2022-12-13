package gaozhi.online.peoplety.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
* @description: TODO 用户会议信息
* @author http://gaozhi.online
* @date 2022/12/13 16:12
* @version 1.0
*/
@Data
@TableName("user_meeting")
public class UserMeeting {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long userid;
    @TableField("meeting_id")
    private Long meetingId;
    private Long time;
}
