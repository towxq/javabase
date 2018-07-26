package spring;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class springdemo {
    public static void main(String[] args){
        ApplicationContext applicationContext  = new ClassPathXmlApplicationContext("bean.xml");//ApplicationContext容器
        DemoMessage demoMessage = (DemoMessage) applicationContext.getBean("messagedemo");
        DemoMessage demoMessage1 = (DemoMessage) applicationContext.getBean("messagedemo");
        System.out.println(demoMessage.getMessgae());
        System.out.println(demoMessage1.getMessgae());

//        XmlBeanFactory xmlBeanFactory  = new XmlBeanFactory(new ClassPathResource("bean.xml"));//BeanFactory容器
//        DemoMessage demoMessage2 = (DemoMessage) xmlBeanFactory.getBean("messagedemo");
//        System.out.println(demoMessage2.getMessgae());

        System.out.println(demoMessage==demoMessage1);

    }
}
