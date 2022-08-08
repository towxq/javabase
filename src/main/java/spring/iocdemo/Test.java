package spring.iocdemo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Test {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        UserController userController = new UserController();
        Class<? extends UserController> classz = userController.getClass();
        Field[] fields = classz.getDeclaredFields();
        for (Field field : fields) {
            Annotation annotation = field.getAnnotation(Autowired.class);
            if (annotation != null) {
                field.setAccessible(true);
                Class<?> type = field.getType();
//              Object object = type.getConstructor().newInstance();
                Object object = type.newInstance();
                field.set(userController, object);
            }
            AutoValue autoValue = field.getAnnotation(AutoValue.class);
            if (autoValue != null) {
                field.setAccessible(true);
//                Class<?> type = autoValue.getType();
//                Object object = type.newInstance();
                field.set(userController, autoValue.value());
            }
        }

        System.out.println(userController);
        userController.print();

    }
}
