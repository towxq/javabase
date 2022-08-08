package 数据结构和算法;

/**
 * @author wxq
 * @ClassName ArrayListdemo
 * @Description TODO
 * @date 2021/2/13  17:09
 */
public class ArrayListdemo {
    Object[] data;

    Object[] emptyData = {};

    ArrayListdemo(int inintsize) {
        if (inintsize > 0) {
            data = new Object[inintsize];
        } else if (inintsize == 0) {
            data = emptyData;
        } else {
            System.out.println("初始化失败");
        }
    }


}
