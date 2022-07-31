package gaozhi.online.peoplety.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 发送邮件
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleEmailEntity {

    /**

     * 主题
     */
    private String subject;

    /**

     * 主题内容
     */
    private String content;

    /**

     * 接收人邮箱列表
     */
    private String[] tos;

}
