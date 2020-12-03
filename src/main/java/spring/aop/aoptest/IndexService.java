package spring.aop.aoptest;

import org.springframework.stereotype.Component;

@Component
public class IndexService {
    public void index() throws InterruptedException {
        System.out.println("index");
        Thread.sleep(3000);
    }
}
