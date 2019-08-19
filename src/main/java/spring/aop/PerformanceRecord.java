package spring.aop;

public class PerformanceRecord {
    private final String methodName;//方法名
    private final long begin;//开始时间

    public PerformanceRecord(String method) {
        this.methodName = method;
        this.begin = System.currentTimeMillis();
    }

    public void print(){
        long end = System.currentTimeMillis();
        long elapse = end -begin;
        System.out.println(methodName+"耗时："+elapse+"毫秒");
    }
}
