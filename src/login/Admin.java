package login;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.awt.SystemColor.menu;
import Cart.*;
import Menu.*;
public class Admin {

    public final static String name= "admin123";

    public final static String password = "admin123";
    public static void login(ArrayList<owner> owners, ArrayList<customer> accounts , ArrayList<Resturant> reslist , ArrayList<Menu_Section> catList, ArrayList<Dish> dishList) throws IOException {
        Scanner input = new Scanner(System.in);
        String value;
        while (true) {
            System.out.println("1-Enter Your Info: ");
            System.out.println("2-Back");
            value = input.next();
            if (value.equals("1")) {
                while (true) {
                    System.out.println("Enter your ID:");
                    String vale = input.next();
                    System.out.println("Enter your Password:");
                    String vale2 = input.next();
                    if (vale.equals(name) && vale2.equals(password)) {
                        System.out.println("You Have Logged In Successfully");
                        System.out.println("--------------------------------");
                        menulist.show_main_admin_list(owners, accounts, reslist, catList, dishList);
                        return;
                    } else {
                        System.out.println("YOUR ID OR PASSWORD IS WRONG");
                        System.out.println("ENTER YOUR ID AGAIN PLEASE : ");
                        continue;
                    }

                }

            } else if (value.equals("2")) {
                menulist.show_main_menu(owners, accounts, reslist, catList, dishList);
                return;
            } else {
                System.out.println("Invalid Choice");
                System.out.println("--------------");
                continue;
            }


        }
    }



}