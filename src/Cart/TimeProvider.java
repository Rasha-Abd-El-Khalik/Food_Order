package Cart;
import login.*;
import Menu.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeProvider {

    public String getCurrentTime() {
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return currentTime.format(formatter);
    }

    public static void main(String[] args) {

        TimeProvider timeProvider = new TimeProvider();
        String currentTime = timeProvider.getCurrentTime();
        System.out.println("Current Time: " + currentTime);
    }
}