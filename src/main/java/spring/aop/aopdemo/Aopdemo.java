package spring.aop.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("spring.aop.aopdemo")
@Enjoy
public class Aopdemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Aopdemo.class);
        applicationContext.getBean(Index.class).index();
    }
}
