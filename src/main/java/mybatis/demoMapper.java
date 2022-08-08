package mybatis;

import java.util.List;

/**
 * @author wxq
 * @ClassName demoMapper
 * @Description TODO
 * @date 2021/8/29  21:35
 */
public interface demoMapper {

    //一对一
    blog selectBlogAuthor(int id);
    //一对多 一个作者多个博客
    Author selectAuthorBlogs(int id);
    //多对一 多个评论对应一个用户
    List<Comment> selectUserComment(List<Integer> ids);
    //多对多 博客评论
    List<blog> selectBlogComment(List<Integer> ids);
}
