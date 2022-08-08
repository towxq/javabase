package mybatis;

import lombok.Data;

import java.util.List;

/**
 * @author wxq
 * @ClassName Author
 * @Description TODO
 * @date 2021/8/29  21:36
 */
@Data
public class Author {
    private Integer id;
    private String author;
    private List<blog> blogs;
}
