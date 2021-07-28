import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @description: code test
 * @author: zhaolu
 * @createDate: 2021/1/13
 */
public class CodeTest {

    public static void main(String[] args) {
        String dateStr = "2019-06-18T18:29:05+08:00";

        ZonedDateTime result = ZonedDateTime.parse(dateStr, DateTimeFormatter.ISO_DATE_TIME);
        result = result.withZoneSameInstant(ZoneId.systemDefault());
        System.out.println("result:" + result.toInstant());

        System.out.println("ZonedDateTime : " + result);

        System.out.println("TimeZone : " + result.getZone());

        LocalDateTime localDate = result.toLocalDateTime();
        System.out.println("localDate:" + localDate);
        System.out.println(localDate.toInstant(result.getOffset()));
    }
}
