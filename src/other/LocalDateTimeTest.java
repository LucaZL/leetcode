package other;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @description:
 * @author: zhaolu
 * @createDate: 2021/7/21
 */
public class LocalDateTimeTest {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(now));
    }
}
