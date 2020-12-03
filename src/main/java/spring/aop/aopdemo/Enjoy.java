package spring.aop.aopdemo;


import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Import(EnjoyAopBeanPostProcessor.class)
public @interface Enjoy {
}
