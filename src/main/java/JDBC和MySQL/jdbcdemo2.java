package JDBC和MySQL;


import org.apache.ibatis.annotations.Select;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class jdbcdemo2 {
    public static void main(String[] args) {
        ShopMapper shopMapper = (ShopMapper) Proxy.newProxyInstance(jdbcdemo2.class.getClassLoader(), new Class[]{ShopMapper.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
                Select annotaion  = method.getAnnotation(Select.class);
                if (annotaion!=null){
                    String[] value = annotaion.value();
                    System.out.println(Arrays.toString(value));
                }
                return null;
            }
        });
        shopMapper.selectShpoList("a");
    }

    public static Map<String,Object> buildMethodArsNameMap(Method method,Object[] args){
        Map<String,Object> nameArgMap = new HashMap<String, Object>();
        Parameter[] parameters = method.getParameters();
        int index[] = {0};
        Arrays.asList(parameters).parallelStream().forEach(parameter ->{
           String name = parameter.getName();
           nameArgMap.put(name,args[index[0]]);
           index[0]++;
        });
        return nameArgMap;

    }
}


interface ShopMapper{
    @Select("select * from shop where author = #{author}")
    List<Shop> selectShpoList(String author);
}

class Shop{
    private String article;
    private String author;
    private String price;

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}