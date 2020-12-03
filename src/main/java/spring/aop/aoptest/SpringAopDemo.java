package spring.aop.aoptest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan("spring.aop.aoptest")
@EnableAspectJAutoProxy
public class SpringAopDemo {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringAopDemo.class);
        applicationContext.getBean(IndexService.class).index();
    }
}
