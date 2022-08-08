package spi;

/**
 * @author wxq
 * @ClassName FileSearch
 * @Description TODO
 * @date 2021/9/11  23:29
 */
public class FileSearch implements Search{
    @Override
    public void search() {
        System.out.println("spi.Search file");
    }
}
