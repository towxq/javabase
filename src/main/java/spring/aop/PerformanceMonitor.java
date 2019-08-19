package spring.aop;

public class PerformanceMonitor {
    //通过ThreadLocal 保存与调用线程相关的性能监控信息
    private static ThreadLocal<PerformanceRecord> record = new ThreadLocal<PerformanceRecord>();

    public static void begin(String method){
        System.out.println("开启监视。。。");
        record.set(new PerformanceRecord(method));
    }

    public static void end(){
        System.out.println("结束监视。。。");
        record.get().print();
    }
}
