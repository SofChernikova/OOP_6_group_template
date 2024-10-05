package L6.util;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


@UtilityClass
public class Utils {

    private final static Random random = new Random();

    public static int getRandomInt() {
        return random.nextInt();
    }

    public static String getRandomString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;

        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static LocalDate getRandomDate() {
            int hundredYears = 100 * 365;

            return LocalDate.ofEpochDay(ThreadLocalRandom.current().nextInt(-hundredYears, hundredYears));
    }

}
