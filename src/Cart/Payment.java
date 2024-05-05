package Cart;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import login.*;
import Menu.*;
class Payment {
    private String paymentMethod;
    private String transactionId;
    private String paymentStatus;
    private CreditCard creditCard;
    private Order order;
    public boolean isValidPayment = false;

    public Payment() {
        this.paymentMethod = "";
        this.transactionId = "";
        this.paymentStatus = "";
        this.creditCard = null;
    }



    public void getPaymentDetails(Payment pay, int arr[], ArrayList<Resturant> resturants, ArrayList<customer> acc, int index1) throws ParseException {

        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Choose your payment method: ");
            System.out.println("1. Cash");
            System.out.println("2. Credit Card");
            System.out.println("3.back");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    paymentMethod = "Cash";
                    processCashPayment();
                    break;
                case 2:
                    paymentMethod = "Credit Card";
                    getCreditCardInfo();
                    break;
                case 3:
                    order.displayOrderDetails(pay,arr,resturants,acc,index1);
                default:
                    System.out.println("Invalid choice. Please choose again.");


            }
            if(isValidPayment)break;
        }

    }


    private void processCashPayment() {
        transactionId = generateTransactionId();
        paymentStatus = "Paid by cash";
        System.out.println("Cash payment processed successfully.");
        isValidPayment=true;
    }
    // get info of credit card (card number,cvv,expirationDate) and check if the card is correct
    private void getCreditCardInfo() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        String cardNumber;
        while (true) {
            System.out.print("Enter credit card number (16 digits only): ");
            cardNumber = scanner.next();
            if (cardNumber.matches("\\d{16}")) {
                break;
            } else {
                System.out.println("Invalid credit card number. Please enter 16 digits only.");
            }
        }

        String expirationDate;
        while (true) {
            System.out.print("Enter expiration date (MM/YY): ");
            try{
                expirationDate = scanner.next();


            int date1 = convertToComparableFormat(expirationDate);
            int date2 = convertToComparableFormat("12/23");
            if (expirationDate.matches("(0[1-9]|1[0-2])/(\\d{2})") && date1 >= date2) {
                System.out.println(expirationDate);
                break;
            }
            else if(expirationDate.matches("(0[1-9]|1[0-2])/(\\d{2})") && date2 > date1)
            {
                System.out.println("Date expired! re-enter it!");
            }
            else {
                System.out.println("Invalid expiration date format. Please enter in MM/YY format.");
            }
            }
            catch (Exception c){
                System.out.println("Invalid expiration date format. Please enter in MM/YY format.");
                continue;
            }
        }


        String cvv ;
        while (true) {
            System.out.print("Enter CVV: ");
            cvv = scanner.next();
            if (cvv.matches("\\d{3}")) {
                break;
            } else {
                System.out.println("Invalid CVV number. Please enter 3 digits only.");
            }
        }



        creditCard = new CreditCard(generateTransactionId(), cardNumber, expirationDate, cvv);
        saveCreditCardToFile();
        isValidPayment=true;
        System.out.println("Credit card information received and saved successfully.");
    }

    public static int convertToComparableFormat(String dateStr) throws ParseException {

        SimpleDateFormat inputFormat = new SimpleDateFormat("MM/yy");


        Date date = inputFormat.parse(dateStr);


        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyyMM");


        return Integer.parseInt(outputFormat.format(date));
    }
    private String generateTransactionId() {
        return String.valueOf(System.currentTimeMillis());
    }

    private void saveCreditCardToFile() {
        try (FileWriter writer = new FileWriter("credit_card_info.txt")) {
            writer.write("Transaction ID: " + creditCard.getTransactionId() + "\n");
            writer.write("Credit Card Number: " + creditCard.getCardNumber() + "\n");
            writer.write("Expiration Date: " + creditCard.getExpirationDate() + "\n");
            writer.write("CVV: " + creditCard.getCvv() + "\n");
        } catch (IOException e) {
            System.out.println("Error saving credit card information to file: " + e.getMessage());
        }
    }
    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }
}
