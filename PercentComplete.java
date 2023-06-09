import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PercentComplete {
    public static void main(String[] args) {

        // Found out how to do most of this here:
        // https://www.tutorialspoint.com/javatime/javatime_localdate_until1.htm
        LocalDate end = LocalDate.parse("2023-08-25");
        LocalDate now = LocalDate.now();

        // Has to be a long, not an int
        long diff = Math.abs(end.until(now, ChronoUnit.DAYS));

        // Calculate percent done
        float percentDone = (1 - diff/84f) * 100;

        // Make a string version of the float and cut off the decimals to the 10ths place
        String percentString = String.format("%.2f", percentDone);

        // The progress message
        System.out.println("We are currently " + percentString + "% done!\nKeep up the great work!");

        // Taking what we learned in the box problems, we can make a little progress bar
        int rounded = Math.round(percentDone);
        System.out.println("                                              PROGRESS:");
        System.out.print('|');
        for (int i = 0; i < rounded; i++) {
            System.out.print('#');
        }
        for (int j = 0; j < 100 - rounded; j++) {
            System.out.print('_');
        }
        System.out.print('|');
    }
}