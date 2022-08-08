package mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * @author wxq
 * @ClassName onetooneTest
 * @Description TODO
 * @date 2021/8/11  21:46
 */
public class MybatisTest {

    @Test
    public void test() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        demoMapper mapper = sqlSession.getMapper(demoMapper.class);

        //一对一
        blog blog = mapper.selectBlogAuthor(2);
        System.out.println(blog);

        //一对多
        Author author = mapper.selectAuthorBlogs(1);
        System.out.println(author);

        //多对一
        List<Comment> comments = mapper.selectUserComment(Arrays.asList(1,2,3));
        System.out.println(comments);

        //多对多
        List<blog> blogs = mapper.selectBlogComment(Arrays.asList(1,2,3));
        System.out.println(blogs);
    }

}
