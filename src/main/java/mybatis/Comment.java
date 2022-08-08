package mybatis;

import lombok.Data;

/**
 * @author wxq
 * @ClassName Comment
 * @Description TODO
 * @date 2021/8/29  21:38
 */
@Data
public class Comment {
    private Integer id;
    private String comment;
    private User user;
}
