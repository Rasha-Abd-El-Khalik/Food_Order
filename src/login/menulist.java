package login;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import Cart.*;
import Menu.*;
import Every.*;
public class menulist {
    public static void show_main_menu(ArrayList<owner> owners, ArrayList<customer> accounts , ArrayList<Resturant> reslist , ArrayList<Menu_Section> catList, ArrayList<Dish> dishList) throws IOException {
        System.out.println("----------------------------------------------------------");
        System.out.println();
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("=====================================");
            System.out.println("|        WELCOME TO L7d 2l Beet     |");
            System.out.println("|      --------------------------   |");
            System.out.println("|   Choose Your Option:             |");
            System.out.println("|   _______                         |");
            System.out.println("|   1-Create Account.               |");
            System.out.println("|   2-Login as Customer.            |");
            System.out.println("|   3-Login as form.Admin.          |");
            System.out.println("|   4-Login as Owner.               |");
            System.out.println("|   5-Forget Password.              |");
            System.out.println("|   6-Exit from System.             |");
            System.out.println("=====================================");
            String choose = input.next();
            if(choose.equals("1")) {
                customer.create_account(owners,accounts , reslist ,catList , dishList);
                break;
            }else if (choose.equals("2")){
                int index1=customer.login(accounts,owners ,reslist , catList , dishList);

                break;
            }
            else if (choose.equals("3")) {
                Admin.login(owners,accounts , reslist ,catList ,dishList);
                break;
            }else if(choose.equals("4")){
                int index=owner.log_in(owners,accounts,reslist,catList,dishList);
                System.out.println("welcome"+reslist.get(index).name);
                menulist.show_main_owner_list(owners,accounts,reslist,catList,dishList,index);
                break;
            }
            else if (choose.equals("5")){
                customer.forget_password(owners,accounts,reslist,catList,dishList);
                break;
            } else if (choose.equals("6")) {
                free.thank();
                System.out.println("                                         Thank You For Using 'L7D 2L BEET' System ");
                System.out.println("                                         ----------------------------------------");
                break;
            }
            else {
                System.out.println("Invalid Choice");
                System.out.println("PLease Reechoes Your Option");
                System.out.println("---------------------------");
                continue;
            }
        }
    }
    public static void show_admin_restaurant_list( ArrayList<owner> owners,ArrayList<customer> accounts , ArrayList<Resturant> reslist , ArrayList<Menu_Section> catList, ArrayList<Dish> dishList) throws IOException {
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("Choose Your Option");
            System.out.println("-------------------");
            System.out.println("1-Add Restaurant");
            System.out.println("2-Remove Restaurant");
            System.out.println("3-Back");
            String choose = input.next();
            if (choose.equals("1")) {
                Resturant.add_restaurant( reslist ,catList,dishList,owners,accounts);
                return;
            } else if (choose.equals("2")) {
                Resturant.remove(reslist,catList,dishList,owners,accounts);
                return;
            } else if (choose.equals("3")) {
                show_main_admin_list(owners,accounts ,reslist ,catList ,dishList);
                return;
            } else {
                System.out.println("Invalid Choice");
                System.out.println("PLease Reechoes Your Option");
                System.out.println("---------------------------");
                continue;
            }
        }
    }
    public static void show_main_admin_list(ArrayList<owner> owners,ArrayList<customer> accounts , ArrayList<Resturant> reslist , ArrayList<Menu_Section> catList, ArrayList<Dish> dishList) throws IOException {
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("Choose Your Option");
            System.out.println("-------------------");
            System.out.println("1-Edit in Restaurant");
            System.out.println("2-Back");
            String choose = input.next();
            if(choose.equals("1")) {
                show_admin_restaurant_list(owners,accounts, reslist,catList, dishList);
                break;
            }
            else if (choose.equals("2")){
                 show_main_menu(owners,accounts , reslist ,catList ,dishList);
                break;
            }
            else {
                System.out.println("Invalid Choice");
                System.out.println("PLease Reechoes Your Option");
                System.out.println("---------------------------");
                continue;
            }
        }
    }
    public static void show_main_owner_list(ArrayList<owner> owners,ArrayList<customer> accounts , ArrayList<Resturant> reslist , ArrayList<Menu_Section> catList, ArrayList<Dish> dishList,int i) throws IOException {
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("Choose Your Option");
            System.out.println("-------------------");
            System.out.println("1-Add dish");
            System.out.println("2-Remove dish");
            System.out.println("3-Update Price");
            System.out.println("4-Log out");
            String choose = input.next();
            if(choose.equals("1")) {
                owner.add_dish(owners,accounts,reslist,catList,dishList,i);
                return;
            }
            else if (choose.equals("2")){
                owner.remove_dish(owners,accounts,reslist,catList,dishList,i);
                return;
            }
            else if (choose.equals("3")){
                owner.update_price(owners,accounts,reslist,catList,dishList,i);
                return;
            }
            else if (choose.equals("4")) {
                show_main_menu(owners,accounts , reslist ,catList ,dishList);
                return;
            }
            else {
                System.out.println("Invalid Choice");
                System.out.println("PLease Reechoes Your Option");
                System.out.println("---------------------------");
                continue;
            }
        }
    }
}