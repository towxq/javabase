package aop;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by MSI on 2016/7/17.
 */
public class SpringAOPTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Test
    public void interceptorTest(){
        ApplicationContext cxt = new ClassPathXmlApplicationContext("calsspath:beans.xml");
        PersonService personService = (PersonService)cxt.getBean("personService");
        personService.save("xx");
    }
}
