package 基础知识.aop;

/**
 * Created by MSI on 2016/7/17.
 */
public interface PersonService {
    public void save(String name);
    public void update(String name, Integer id);
    public String getPersonName(Integer id);
}
