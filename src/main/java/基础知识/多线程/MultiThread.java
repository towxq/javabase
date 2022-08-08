package 基础知识.多线程;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @author wxq
 * @ClassName MultiThread
 * @Description TODO
 * @date 2021/6/17  23:23
 */
public class MultiThread {
    public static void main(String[] args) {
        //获取计算机核心数
        System.out.println(Runtime.getRuntime().availableProcessors());
        //获取java管理线程MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        //不需要获取同步的monitor和synchronizer信息，仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        //遍历线程信息，仅打印线程ID和线程名称信息
        for (ThreadInfo threadInfo:threadInfos){
            System.out.println(threadInfo.getThreadId()+"------"+threadInfo.getThreadName());
        }
    }
}
//      6------Monitor Ctrl-Break
//      5------Attach Listener     添加事件
//      4------Signal Dispatcher   分发处理给JVM信号的线程
//      3------Finalizer           调用对象finalize方法的线程
//      2------Reference Handler   清楚reference线程
//      1------main                 main线程 程序入口