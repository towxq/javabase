package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class springdemo {
    public static void main(String[] args){
        ApplicationContext applicationContext  = new ClassPathXmlApplicationContext("bean.xml");//ApplicationContext容器
//        DemoMessage demoMessage = (DemoMessage) applicationContext.getBean("messagedemo");
//        DemoMessage demoMessage1 = (DemoMessage) applicationContext.getBean("messagedemo1");
        Employee employee = (Employee) applicationContext.getBean("employee");
//        System.out.println(demoMessage.getMessgae());
//        System.out.println("++++"+demoMessage1.getMessgae());
        System.out.println("---------------");
        System.out.println(employee.toString());

//        ApplicationContext applicationContext1  = new AnnotationConfigApplicationContext(CompanyConfig.class);
//        Employee employee = applicationContext1.getBean(Employee.class);
//        Employee employee1 = applicationContext1.getBean(Employee.class);
//        employee.setId("111");
//        employee.setName("sad");
//        employee1.setId("111");
//        employee1.setName("sad");
//        System.out.println(employee==employee1);





//        XmlBeanFactory xmlBeanFactory  = new XmlBeanFactory(new ClassPathResource("bean.xml"));//XmlBeanFactory容器
//        DemoMessage demoMessage2 = (DemoMessage) xmlBeanFactory.getBean("messagedemo");
//        System.out.println(demoMessage2.getMessgae());
//
//        System.out.println(demoMessage==demoMessage1);

    }
}

//ClassPathXmlApplication：它是从类的根路径下加载xml配置文件（推荐用这种）。
//FileSystemXmlApplication: 它是从磁盘路径上加载配置文件，配置文件可以在磁盘的任意位置。（但使用不灵活，不推荐）
//AnnotationConfigApplication：当我们使用注解配置容器对象时，需要使用此类来创建spring容器。它用来读取注解。（springboot默认使用这个）

//在Java中将不同的资源抽象成URL 通过注册不同的handler（URLStreamHandler）来处理不同来源的读取逻辑，spring对其内部使用到的资源实现了自己的
//抽象结构Resource接口来封装底层资源

//1，获取XML文件的验证模式
//2，加载XML文件，并获得对应的Document
//3，根据返回的Doucument注册Bean信息

//保证XML的正确性比较常用的验证模式 DTD和XSD
//DTD 文档类型定义，是一种XML约束模式语言，是XML文件的验证机制，属于XML文件组成的一部分，DTD是一种保证XML文档格式正确的有效的方法
//可以通过比较XML文档和DTD文件来看文档是否符合规范，元素和标签使用的是否正确
//一个DTD文档包含：元素的定义规则，元素间关系的定义规则，元素可使用的属性，可使用的实体或符号规则
//要使用DTD验证模式的时候需要在ＸＭＬ文件头部声明

//XML Schema语言就是XSD XML Schema描述了XML文档的结构，可以用一个指定的XML Schema来验证某个XML文档，以检查XML文档是否符合其要求
//文档设计者可以通过XML Schema指定一个XML文档所允许的结构和内容，并可据此检查一个XML文档是否有效，XML Schema本身是一个XML文档，他符合
//XML的语法结构，可以通过XML解析器解析它

//使用XML Schema文档对XML实例文档进行校验，除了要声明名称空间外，还必须指定该空间所对应的XML Schema文档的存储位置
