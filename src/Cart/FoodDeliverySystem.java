package Cart;
import java.text.ParseException;
import java.util.ArrayList;
import login.*;
import Menu.*;

public class FoodDeliverySystem {
    public static void Ord(int[] arr, ArrayList<Resturant> resturants, ArrayList<customer> acc, int index1, ArrayList<owner> owner, ArrayList<Menu_Section> catlist, ArrayList<Dish> dishlist, customer c) throws ParseException {
        Order order = new Order();

        order.selectOrderTime();

        Payment payment = new Payment();
        payment.getPaymentDetails(payment,arr,resturants,acc,index1);


        System.out.println("\nPayment Details:");
        System.out.println("Payment Method: " + payment.getPaymentMethod());
        System.out.println("Transaction ID: " + payment.getTransactionId());
        System.out.println("Payment Status: " + payment.getPaymentStatus());


        CreditCard creditCard = payment.getCreditCard();
        if (creditCard != null) {
            System.out.println("\nCredit Card Information:");
            System.out.println("Transaction ID: " + creditCard.getTransactionId());
            System.out.println("Credit Card Number: " + creditCard.getCardNumber());
            System.out.println("Expiration Date: " + creditCard.getExpirationDate());
            System.out.println("CVV: " + creditCard.getCvv());
        }
        order.processPayment();

        order.displayOrderDetails(payment,arr,resturants,acc,index1);

        OrderTimer deliveryTracker = new OrderTimer();
        deliveryTracker.startTracking(owner, acc, resturants, catlist, dishlist, c);

    }


}
