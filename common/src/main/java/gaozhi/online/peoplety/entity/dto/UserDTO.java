package gaozhi.online.peoplety.entity.dto;

import gaozhi.online.peoplety.entity.UserInfo;
import lombok.Data;

/**
 * 用户信息
 */
@Data
public class UserDTO {
    private UserInfo userInfo;
    //粉丝数量
    private long fanNum;
    //关注数量
    private long attentionNum;
}
