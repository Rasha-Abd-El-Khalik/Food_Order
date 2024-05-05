package Cart;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import Menu.Dish;
import Menu.Menu_Section;
import Menu.Resturant;
import login.*;

public class OrderTimer {
    private int remainingTime;
    private final int[] periods = {20,15,10,5};
    private final String[] messages = {
            "Order checking...",
            "Your order has reached the kitchen",
            "\rOrder status: Preparing. It won't be much longer",
            "\rDriver out for delivery. Expect your order soon.."
    };

    public OrderTimer() {
        this.remainingTime = 20;
    }

    public void startTracking(ArrayList<owner> owner, ArrayList<customer> acc, ArrayList<Resturant> reslist, ArrayList<Menu_Section> catlist, ArrayList<Dish> dishlist, customer c) {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        Runnable trackDeliveryTask = () -> {
            if (remainingTime > 0) {
                int seconds = remainingTime;

                for (int i = 0; i < periods.length; i++) {
                    if (remainingTime == periods[i]) {
                        System.out.println(messages[i]);
                        break;
                    }
                }

                System.out.printf("\rRemaining Time: %02d seconds\r", seconds);
                remainingTime--;
            } else {
                System.out.println("Order successfully delivered. Enjoy your meal!");
                scheduler.shutdown();
                try {
                    Review.Reviewmenu(owner,acc,reslist,catlist,dishlist, c);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        };

        scheduler.scheduleAtFixedRate(trackDeliveryTask, 0, 1, TimeUnit.SECONDS);
    }

}
