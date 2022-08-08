package spi;

/**
 * @author wxq
 * @ClassName DataBaseSearch
 * @Description TODO
 * @date 2021/9/11  23:29
 */
public class DataBaseSearch implements Search{
    @Override
    public void search() {
        System.out.println("spi.Search database");
    }
}
