package 基础知识.集合;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test1 {
    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime.getDayOfMonth());
        System.out.println(dateTime.getMonthValue());
        System.out.println(dateTime.plusWeeks(1));
        System.out.println(dateTime.getDayOfWeek());
        System.out.println("11111----"+parse("2022-13"));
        System.out.println(1023%10);
    }

    static LocalDate parse(String text) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-w E").withLocale(Locale.CHINA);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-w e");
        return LocalDate.parse(text+" 2", formatter);
    }


}
