package gaozhi.online.peoplety.entity;

import lombok.Data;

/**
 * @author LiFucheng
 * @version 1.0
 * @description: TODO  用户身份及权限
 * @date 2022/5/2 10:23
 */
@Data
public class Status {
    private int id;
    private int grade;
    private String name;
    private String privileges;
    private String description;
    private long createTime;
    private boolean enable;
}
