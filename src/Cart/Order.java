package Cart;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import login.*;
import Menu.*;

public class Order {

    private Scanner scanner = new Scanner(System.in);
    private String customerChoice;
    private String[] timeOptions;
    private String restaurantName;
    // private Payment payment;

    public Order() {
        timeOptions();
    }

    private void timeOptions() {
        System.out.println("Enter the suitable period to deliver your order:");
        timeOptions = new String[]{
                "At 9AM-12PM",
                "At 12PM-3PM",
                "At 3PM - 6PM",
                "At 6PM-8PM",
                "At 8PM - 10PM",
        };
    }

    public String getSelectedTime() {
        return customerChoice;
    }

    public void setCustomerChoice(String customerChoice) {
        this.customerChoice = customerChoice;
    }

    public void selectOrderTime() {
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.println("Choose your preferred order receive time:");
                for (int i = 0; i < timeOptions.length; i++) {
                    System.out.println((i + 1) + ". " + timeOptions[i]);
                }
                System.out.println((timeOptions.length + 1) + ". Back to cart");

                int choice = scanner.nextInt();

                if (choice >= 1 && choice <= timeOptions.length) {
                    customerChoice = timeOptions[choice - 1];
                    System.out.println("Pickup Time: " + customerChoice);
                    isValid = true;
                } else if (choice == timeOptions.length + 1) {
                    return;
                } else {
                    System.out.println("Invalid choice! Please try again.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid value.");
                scanner.nextLine();
            }
        }

        // processPayment();
    }

    public void processPayment() {
        deliverOrder();
    }

    public void displayOrderDetails(Payment pay, int arr[], ArrayList<Resturant> resturants, ArrayList<customer> acc, int index1) {
        double TotalPrice=0;
        System.out.println("Your order details:");
        System.out.println("Restaurant: " + resturants.get(arr[0]).name);
        for (int i=0;i<acc.get(index1).itmes1.size();i++){

            System.out.println(acc.get(index1).itmes1.get(i));
            System.out.println(acc.get(index1).itmesprice.get(i));
        }

        for (int i=0;i<acc.get(index1).itmesprice.size();i++){
            TotalPrice+=acc.get(index1).itmesprice.get(i);
        }
        System.out.print("Total Price :");
        System.out.println(TotalPrice);
        System.out.println("Delivery Time: " + customerChoice);
        System.out.println("Payment Information:");
        System.out.println("Payment Method: " + pay.getPaymentMethod());
    }

    public void deliverOrder() {
        System.out.println("Your order is being prepared and will be ready for pickup shortly.");
        OrderTimer orderTimer = new OrderTimer();
        //orderTimer.startTracking();
    }
}

//    public static void main(String[] args) {
//        Order order = new Order();
//        order.selectOrderTime();
//        order.displayOrderDetails();
//    }
//}
