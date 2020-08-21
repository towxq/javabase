package spring;

import org.springframework.beans.factory.InitializingBean;

public class DemoMessage implements InitializingBean
{
    private String messgae;

    public DemoMessage(){
        System.out.println("---构造方法");
    }

    public DemoMessage(String messgae) {
        this.messgae = messgae;
    }

    private void setvalue(){
        this.messgae = "init方法---123456";
    }

    public String getMessgae() {
        return messgae;
    }

    public void setMessgae(String messgae) {
        this.messgae = messgae;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用afterPropertiesSet方法");
        this.messgae = "after----wxq123";
    }

    @Override
    public String toString() {
        return "DemoMessage{" +
                "messgae='" + messgae + '\'' +
                '}';
    }
}
