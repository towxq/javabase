package spring;

import org.springframework.stereotype.Component;
import spring.iocdemo.Autowired;

/**
 * @author wxq
 * @ClassName Aa
 * @Description TODO
 * @date 2021/6/15  16:26
 */
@Component
public class Aa {

    @Autowired
    Employee employee;

    public void print(){
        System.out.println(employee);
    }
}
