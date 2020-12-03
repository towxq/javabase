package spring.aop.aopdemo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

@Component
public class EnjoyAopBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Object o = null;
        if (beanName.equals("index")){
            Class<?>[] interfaces = bean.getClass().getInterfaces();
            o  = Proxy.newProxyInstance(EnjoyAopBeanPostProcessor.class.getClassLoader(),interfaces,new EnjoyInvocationHandler(bean));
        }
        return o;
    }
}
