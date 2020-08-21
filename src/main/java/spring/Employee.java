package spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class Employee implements BeanFactoryAware,BeanNameAware,InitializingBean,DisposableBean{
    private String name;
    private String id;

    public Employee() {
        System.out.println("---构造方法");
    }

    public Employee(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactory的setBeanFactory");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("BeanNameAware接口setBeanName");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DiposibleBean的destory");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean的afterPropertiesSet");
    }

    public void innit(){
        System.out.println("init......");
    }
}
