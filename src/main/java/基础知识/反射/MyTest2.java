package 基础知识.反射;

import org.junit.Test;

import java.util.stream.Stream;

public class MyTest2 {
    @Test
    public void test(){
        UserController userController = new UserController();
        Class clazz = userController.getClass();
        Stream.of(clazz.getDeclaredFields()).forEach(field->{
            AutoWired annotation = field.getAnnotation(AutoWired.class);
            if(annotation!= null){
                field.setAccessible(true);
                Class<?> type = field.getType();
                try {
                    Object obj = type.newInstance();
                    field.set(userController,obj);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println(userController.getUserService());
    }
}
