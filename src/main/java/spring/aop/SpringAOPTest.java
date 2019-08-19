package spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.*;
import spring.DemoMessage;

import java.lang.reflect.Proxy;

/**
 * Created by MSI on 2016/7/17.
 */
public class SpringAOPTest {

//    @BeforeClass
//    public static void setUpBeforeClass() throws Exception {
//    }

    @Test
    public void interceptorTest(){
//        ApplicationContext applicationContext  = new ClassPathXmlApplicationContext("bean.xml");
//        DemoMessage demoMessage = (DemoMessage)applicationContext.getBean("messageconstructor");
//        System.out.println(demoMessage.getMessgae());

        OrderServiceImpl orderService = new OrderServiceImpl();
        orderService.add();

        PerformanceHandler performanceHandler = new PerformanceHandler(orderService);
        OrderService proxy = (OrderService) Proxy.newProxyInstance(orderService.getClass().getClassLoader(),orderService.getClass().getInterfaces(),performanceHandler);
        proxy.addByJDKProxy();

//        PerformanceProxy proxys = new PerformanceProxy();
//        OrderServiceImpl orderServices = (OrderServiceImpl) proxys.getProxy(OrderServiceImpl.class);
//        orderServices.addByJDKProxy();

//        ApplicationContext applicationContext  = new ClassPathXmlApplicationContext("bean.xml");//ApplicationContext容器
//        TargetClass targetClass = (TargetClass) applicationContext.getBean("targetClass");
//        String reslt = targetClass.joint("spring","aop");
//        System.out.println("result:"+reslt);
    }
}

//所创建的动态代理对象的性能，CGLib 是 JDK 的 10 倍；而创建动态代理对象所花费的时间上，
//CGLib 却比 JDK 多花 8 倍的时间。所以，对于单例模式或者具有实例池的代理类，适合采用 CGLib 技术；反之，则适合采用 JDK 技术