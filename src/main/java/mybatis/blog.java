package mybatis;

import lombok.Data;

import java.util.List;

/**
 * @author wxq
 * @ClassName blog
 * @Description TODO
 * @date 2021/8/29  21:37
 */
@Data
public class blog {
    private Integer id;
    private String blog;
    private List<Comment> comments;
    private Author author;
}
