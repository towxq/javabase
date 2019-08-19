package spring.aop;

public class OrderServiceImpl implements OrderService {
    @Override
    public void add() {
//        PerformanceMonitor.begin("spring.aop.add");//开启监视

        System.out.println("模拟新增订单");

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        PerformanceMonitor.end();//结束监视
    }

    @Override
    public void addByJDKProxy() {
        add();
    }
}
