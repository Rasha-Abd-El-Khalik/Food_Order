package Menu;
import login.*;
import Cart.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Dish {
    public double rate;
    public String description;
    public double discount;
    public static int dish_count;
    public int cout_removedish = 0;
    public int isveg;
    public String origin;
    public int quantity;
    public String name;
    public double price;

    public void display_info() {
        System.out.println("=====================================================================================================================");
        System.out.println("|Name:| " + name);
        System.out.println("|Price:| " + price);
        System.out.println("|Origin:| " + origin);
        System.out.println("|quantity:| " + quantity);
        System.out.println("|Description:| " + description);
        System.out.println("|Discount:| " + discount);
        System.out.println("|Rate: |" + rate);
        if (isveg == 1) {
            System.out.println("                                                vegetarian ");
        } else if (isveg == 0) {
            System.out.println("                                                 Not vegetarian ");
        }
        System.out.println("=====================================================================================================================");
    }

    public static void cart_dish(int index1, ArrayList<Resturant> reses, ArrayList<Menu_Section> sections, ArrayList<Dish> dishes, ArrayList<customer> acc, ArrayList<owner> owners, int[] arr, String inp, customer c) throws FileNotFoundException {


        for (int i = 0; i < reses.get(arr[0]).sections.get(Integer.parseInt(inp) - 1).dishes_count; i++) {
            System.out.println("                                                        DISH : " + (i + 1));
            reses.get(arr[0]).sections.get(arr[1]).dishes.get(i).display_info();
        }
        System.out.println(reses.get(arr[0]).sections.get(Integer.parseInt(inp) - 1).dishes_count + 1 + " - back");
        Scanner input = new Scanner(System.in);
        try {
            String opt = input.next();
            if (Integer.parseInt(opt) >= 1 && Integer.parseInt(opt) < reses.get(arr[0]).sections.get(arr[1]).dishes_count) {
                System.out.println("1- Add to cart");
                System.out.println("Press any Button to Back");

                String in = input.next();
                if (in.equals("1")) {
                    Usercart.addToCartInteractive(arr, reses, sections, dishes, acc, owners, index1, in, inp, c);

                } else {
                    cat_cart(index1, reses, sections, dishes, acc, owners, arr, c);
                }
            } else if (Integer.parseInt(opt) == reses.get(arr[0]).sections.get(Integer.parseInt(inp) - 1).dishes_count + 1) {

                cat_cart(index1, reses, sections, dishes, acc, owners, arr, c);
            } else {
                Dish.cart_dish(index1, reses, sections, dishes, acc, owners, arr, inp, c);

            }


        } catch (Exception e) {
            Dish.cart_dish(index1, reses, sections, dishes, acc, owners, arr, inp, c);
        }

    }

    public static void cat_cart(int index1, ArrayList<Resturant> reses, ArrayList<Menu_Section> sections, ArrayList<Dish> dishes, ArrayList<customer> acc, ArrayList<owner> owners, int[] arr, customer c) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < reses.get(arr[0]).catcount; i++) {
            System.out.println((i + 1) + " - " + reses.get(arr[0]).sections.get(i).name);
        }
        {
            try {
                String inp = scan.next();
                if (Integer.parseInt(inp) >= 1 && Integer.parseInt(inp) <= reses.get(arr[0]).catcount) {
                    dih(index1, reses, sections, dishes, acc, owners, arr, inp, c);
                } else {
                    cat_cart(index1, reses, sections, dishes, acc, owners, arr, c);

                }
            } catch (Exception e) {
                cat_cart(index1, reses, sections, dishes, acc, owners, arr, c);
            }
        }
    }

    public static void dih(int index1, ArrayList<Resturant> reses, ArrayList<Menu_Section> sections, ArrayList<Dish> dishes, ArrayList<customer> acc, ArrayList<owner> owners, int[] arr, String inp, customer c) throws FileNotFoundException {
        for (int i = 0; i < reses.get(arr[0]).sections.get(Integer.parseInt(inp) - 1).dishes_count; i++) {
            reses.get(arr[0]).sections.get(Integer.parseInt(inp) - 1).dishes.get(i).display_info();
        }


        System.out.println(reses.get(arr[0]).sections.get(Integer.parseInt(inp) - 1).dishes_count + 1 + " - back");
        Scanner input = new Scanner(System.in);
        try {
            String opt = input.next();
            if (Integer.parseInt(opt) >= 1 && Integer.parseInt(opt) <= reses.get(arr[0]).sections.get(Integer.parseInt(inp) - 1).dishes_count) {
                System.out.println("1- Add to cart");
                System.out.println("Press any Button to Back");

                String in = input.next();
                if (in.equals("1")) {
                    Usercart.addToCartInteractive(arr, reses, sections, dishes, acc, owners, index1, opt, inp, c);

                } else {
                    cat_cart(index1, reses, sections, dishes, acc, owners, arr, c);
                }
            }
            else if(Integer.parseInt(opt)==(reses.get(arr[0]).sections.get(Integer.parseInt(inp) - 1).dishes_count+1)){
                cat_cart(index1, reses, sections, dishes, acc, owners, arr, c);
            }
            else {
                cat_cart(index1, reses, sections, dishes, acc, owners, arr, c);
            }
        } catch (Exception e) {
            Dish.cart_dish(index1, reses, sections, dishes, acc, owners, arr, inp, c);
        }


    }
}