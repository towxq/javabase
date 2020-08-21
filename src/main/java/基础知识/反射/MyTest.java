package 基础知识.反射;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MyTest {
    @Test
    public void test() throws Exception {
        UserController userController = new UserController();
        Class clazz = userController.getClass();
        //创建对象
        UserService userService = new UserService();
        System.out.println(userService);
        //获取属性
        Field serviceFiled = clazz.getDeclaredField("userService");
        serviceFiled.setAccessible(true);
        String name = serviceFiled.getName();
        String setMethodname = "setUserService";
        Method method = clazz.getMethod(setMethodname,UserService.class);
        method.invoke(userController,userService);
        System.out.println(userController.getUserService());
    }
}
