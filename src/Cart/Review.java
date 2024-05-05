package Cart;
import Menu.Dish;
import Menu.Menu_Section;
import Menu.Resturant;
import login.customer;
import login.menulist;
import login.owner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Review {
    public static void Reviewmenu(ArrayList<owner> owner, ArrayList<customer> acc, ArrayList<Resturant> reslist, ArrayList<Menu_Section> catlist, ArrayList<Dish> dishlist, customer c) throws IOException {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Do You Want to Give A feedback?(y/n)");
            String b = in.next();
            if (b.equals("y") || b.equals("Y") || b.equals("n") || b.equals("N")) {
                if (b.equals("y") || b.equals("Y")) {
                    while (true) {
                        System.out.println("Fill The Next List");
                        System.out.println("------------------");
                        while (true) {
                            while (true) {
                                try {
                                    System.out.println("Rate your Received Dish");
                                    String ratedish = in.next();
                                    System.out.println("Rate your Chosen Restaurant");
                                    String rateres = in.next();
                                    Double kdish = Double.parseDouble(ratedish);
                                    Double kres = Double.parseDouble(rateres);
                                    if ((kdish >= 0 && kdish <= 5) && (kres >= 0 && kres <= 5)) {
                                        break;
                                    } else {
                                        System.out.println("Please Enter A valid Range Between(0-->5)");
                                        continue;
                                    }
                                }catch(Exception e)
                                {
                                    System.out.println("Please Enter A valid Range Between(0-->5)");
                                    continue;
                                }
                            }
                            System.out.println("Thank you for your feedback! We appreciate your input and will use it to improve.");
                            customer.Settings(c , acc , owner , reslist , catlist , dishlist);
                            return;
                        }
                    }
                } else if (b.equals("n") || b.equals("N")) {
                    customer.Settings(c , acc , owner , reslist , catlist , dishlist);
                    return;
                }
            } else {
                System.out.println("Please Enter a Valid Choice");
                System.out.println("---------------------------");
                continue;
            }
        }
    }
}

