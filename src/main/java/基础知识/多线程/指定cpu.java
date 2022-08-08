package 基础知识.多线程;

import net.openhft.affinity.AffinityLock;

/**
 * @author wxq
 * @ClassName 指定cpu
 * @Description TODO
 * @date 2021/6/25  16:45
 */
public class 指定cpu {
    public static void main(String[] args) {
        //绑定指定cpu
        try (AffinityLock affinityLock = AffinityLock.acquireLock(7)) {
            // do some work while locked to a CPU.
            while(true) {}
        }
    }
}

