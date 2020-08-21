package spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition b = beanFactory.getBeanDefinition("messagedemo1");
        System.out.println("属性值----"+b.getPropertyValues().toString());
        MutablePropertyValues pv =  b.getPropertyValues();
        if (pv.contains("messgae")) {
            pv.addPropertyValue("messgae", "messgae123");
        }
        b.setScope(BeanDefinition.SCOPE_PROTOTYPE);

    }
}
