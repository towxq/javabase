package spi;

import java.util.ServiceLoader;

/**
 * @author wxq
 * @ClassName Test
 * @Description TODO
 * @date 2021/9/11  23:34
 */
public class Test {
    public static void main(String[] args) {
        ServiceLoader<Search> spis = ServiceLoader.load(Search.class);
        for (Search search:spis){
            search.search();
        }
    }
}
