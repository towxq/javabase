package 基础知识.Stream;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author wxq
 * @ClassName Localdate
 * @Description TODO
 * @date 2021/10/15  15:28
 */
public class Localdate {
    public static void main(String[] args) {
        //当前日期
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        //当前时间
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        //当前日期 和 时间
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.format(formatter));
    }
}
