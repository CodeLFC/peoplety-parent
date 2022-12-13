package gaozhi.online.peoplety.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
/**
 * @author http://gaozhi.online
 * @version 1.0
 * @description: TODO 日志
 * @date 2022/8/4 15:21
 */
@Data
@TableName("sys_log")
public class SysLog {
    @TableId(type=IdType.AUTO)
    private Long id;
    private String url;
    private Long userid;
    private String ip;
    private Long time;
}