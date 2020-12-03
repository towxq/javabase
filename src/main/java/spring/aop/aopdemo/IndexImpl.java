package spring.aop.aopdemo;


import org.springframework.stereotype.Component;

@Component(value="index")
public class IndexImpl implements Index{
    @Override
    public void index() {
        System.out.println("index");
    }
}
