
package Menu;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import login.*;
import Cart.*;
public class Menu_Section {
    public String name;
    public static int cat_count;
    public int dishes_count = 0;
    public    ArrayList<Dish> dishes = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    public static void section_search(int index1, ArrayList<Menu_Section> sections, String m, ArrayList<Resturant> reses, ArrayList<Dish> dishes, ArrayList<owner> owners, ArrayList<customer> acc, customer c) throws FileNotFoundException {
        while (true) {
            try {
                int mint = Integer.parseInt(m);
                mint--;
                int s = 0;
                for (int i = 0; i < reses.get(mint).catcount; i++) {
                    System.out.println((i + 1) + " - " + reses.get(mint).sections.get(i).name);
                    s = i;
                }
                int f = s + 2;
                System.out.println((s + 2) + " - " + "Back");
                Scanner input = new Scanner(System.in);
                String d = input.next();
                int dint = Integer.parseInt(d);
                dint--;
                int y = Integer.parseInt(d);
                if (dint < 0 || dint > (reses.get(mint).catcount + 1)) {
                    System.out.println("invalid");
                } else if (y == f) {
                    Resturant.res_search( index1,reses, sections, dishes,owners,acc, c);
                    break;
                } else {
                    int check_dish=0;
                    while (true) {

                        try {


                            for (int i = 0; i < reses.get(mint).sections.get(dint).dishes_count; i++) {
                                System.out.println("                                                        DISH : " + (i + 1));
                                reses.get(mint).sections.get(dint).dishes.get(i).display_info();
                            }

                            System.out.println(reses.get(mint).sections.get(dint).dishes_count + 1 + " - " + "Back");

                            String dish_num = input.next();
                            if(Integer.parseInt(dish_num)<0||Integer.parseInt(dish_num)>(reses.get(mint).sections.get(dint).dishes_count + 1)){
                                System.out.println("INVALID CHOICE");
                                continue;
                            }
                            else if(Integer.parseInt(dish_num)==reses.get(mint).sections.get(dint).dishes_count + 1){
                                check_dish=1;
                                break;
                            }
                            else if(Integer.parseInt(dish_num)>=1||Integer.parseInt(dish_num)<=(reses.get(mint).sections.get(dint).dishes_count)) {
                                int check_cart=0;
                                while (true) {
                                    check_cart=0;
                                    System.out.println("1- ADD TO CART");
                                    System.out.println("2-BACK");
                                    String choose_cart = input.next();
                                    if (choose_cart.equals("1")) {
                                        int arr[]=new int[3];
                                        arr=  cart_index(mint,dint,(Integer.parseInt(dish_num)-1));
                                        Usercart.addToCartInteractive(arr,reses,sections,dishes,acc,owners,index1,dish_num,d, c);
                                        break;

                                    } else if (choose_cart.equals("2")) {
                                        check_cart=1;
                                        break;
                                    } else {
                                        System.out.println("INVALID CHOICE");
                                        continue;

                                    }
                                }
                                if(check_cart==1){
                                    continue;
                                }
                                else {
                                    break;
                                }
                            }

                        }
                        catch (Exception e) {
                            System.out.println("INVALID CHOICE");
                            continue;

                        }
                    }



                    if(check_dish==1){
                        continue;
                    }
                    else {
                        break;
                    }
                }
            }
            catch (Exception e) {
                System.out.println("INVALID CHOICE");
                continue;
            }

        }
    }

    public static void section_search_rate(int index1, ArrayList<Menu_Section> sections, String m, ArrayList<Resturant> reses, ArrayList<Dish> dishes, String resrate, ArrayList<Integer> arrindex, ArrayList<owner> owners, ArrayList<customer> acc, customer c) throws FileNotFoundException {
        while (true) {
            try {
                int mint = Integer.parseInt(m);
                mint--;
                for (int i = 0; i <reses.get(mint).catcount; i++) {
                    System.out.println((i + 1) + " - " + reses.get(mint).sections.get(i).name);
                }
                int back = (reses.get(mint).catcount)+1;
                System.out.println(back + " - " + "Back");
                Scanner input = new Scanner(System.in);
                String d = input.next();
                int dint = Integer.parseInt(d);
                dint--;
                if (Integer.parseInt(d)<=0||Integer.parseInt(d)>(reses.get(mint).catcount + 1)) {
                    System.out.println("invalid");
                    continue;

                } else if (Integer.parseInt(d)==back) {
                    Resturant.rate( index1,reses, sections, dishes,resrate,arrindex,owners,acc, c);
                    break;

                } else {
                    int check_dish=0;
                    while (true) {

                        try {


                            for (int i = 0; i < reses.get(mint).sections.get(dint).dishes_count; i++) {
                                System.out.println("                                                        DISH : " + (i + 1));
                                reses.get(mint).sections.get(dint).dishes.get(i).display_info();
                            }

                            System.out.println(reses.get(mint).sections.get(dint).dishes_count + 1 + " - " + "Back");

                            String dish_num = input.next();
                            if(Integer.parseInt(dish_num)<0||Integer.parseInt(dish_num)>(reses.get(mint).sections.get(dint).dishes_count + 1)){
                                System.out.println("INVALID CHOICE");
                                continue;
                            }
                            else if(Integer.parseInt(dish_num)==reses.get(mint).sections.get(dint).dishes_count + 1){
                                check_dish=1;
                                break;
                            }
                            else if(Integer.parseInt(dish_num)>=1||Integer.parseInt(dish_num)<=(reses.get(mint).sections.get(dint).dishes_count)) {
                                int check_cart=0;
                                while (true) {
                                    check_cart=0;
                                    System.out.println("1- ADD TO CART");
                                    System.out.println("2-BACK");
                                    String choose_cart = input.next();
                                    if (choose_cart.equals("1")) {
                                        int arr[]=new int[3];
                                        arr=  cart_index(mint,dint,(Integer.parseInt(dish_num)-1));
                                        Usercart.addToCartInteractive(arr,reses,sections,dishes,acc,owners,index1,dish_num,d, c);
                                        break;

                                    } else if (choose_cart.equals("2")) {
                                        check_cart=1;
                                        break;
                                    } else {
                                        System.out.println("INVALID CHOICE");
                                        continue;

                                    }
                                }
                                if(check_cart==1){
                                    continue;
                                }
                                else {
                                    break;
                                }
                            }

                        }
                        catch (Exception e) {
                            System.out.println("INVALID CHOICE");
                            continue;

                        }
                    }



                    if(check_dish==1){
                        continue;
                    }
                    else {
                        break;
                    }
                }
            }
            catch (Exception e) {
                System.out.println("INVALID CHOICE");

            }
        }
    }

    public static void section_search_type(int index1, ArrayList<Menu_Section> sections, String m, ArrayList<Resturant> reses, ArrayList<Dish> dishes, ArrayList<Integer> arrindex2, ArrayList<owner> owners, ArrayList<customer> acc, customer c) throws FileNotFoundException {
        while (true) {
            try {
                int mint = Integer.parseInt(m);
                mint--;
                for (int i = 0; i <reses.get(mint).catcount; i++) {
                    System.out.println((i + 1) + " - " + reses.get(mint).sections.get(i).name);
                }
                int back = (reses.get(mint).catcount)+1;
                System.out.println(back + " - " + "Back");
                Scanner input = new Scanner(System.in);
                String d = input.next();
                int dint = Integer.parseInt(d);
                dint--;
                if (Integer.parseInt(d)<=0||Integer.parseInt(d)>(reses.get(mint).catcount + 1)) {
                    System.out.println("invalid");
                    continue;

                } else if (Integer.parseInt(d)==back) {
                    Resturant.type( index1,reses,m, sections, dishes,arrindex2,owners,acc, c);
                    break;

                } else {
                    int check_dish=0;
                    while (true) {

                        try {


                            for (int i = 0; i < reses.get(mint).sections.get(dint).dishes_count; i++) {
                                System.out.println("                                                        DISH : " + (i + 1));
                                reses.get(mint).sections.get(dint).dishes.get(i).display_info();
                            }

                            System.out.println(reses.get(mint).sections.get(dint).dishes_count + 1 + " - " + "Back");

                            String dish_num = input.next();
                            if(Integer.parseInt(dish_num)<0||Integer.parseInt(dish_num)>(reses.get(mint).sections.get(dint).dishes_count + 1)){
                                System.out.println("INVALID CHOICE");
                                continue;
                            }
                            else if(Integer.parseInt(dish_num)==reses.get(mint).sections.get(dint).dishes_count + 1){
                                check_dish=1;
                                break;
                            }
                            else if(Integer.parseInt(dish_num)>=1||Integer.parseInt(dish_num)<=(reses.get(mint).sections.get(dint).dishes_count)) {
                                int check_cart=0;
                                while (true) {
                                    check_cart=0;
                                    System.out.println("1- ADD TO CART");
                                    System.out.println("2-BACK");
                                    String choose_cart = input.next();
                                    if (choose_cart.equals("1")) {
                                        int arr[]=new int[3];
                                        arr=  cart_index(mint,dint,(Integer.parseInt(dish_num)-1));
                                        Usercart.addToCartInteractive(arr,reses,sections,dishes,acc,owners,index1,dish_num,d, c);
                                        break;

                                    } else if (choose_cart.equals("2")) {
                                        check_cart=1;
                                        break;
                                    } else {
                                        System.out.println("INVALID CHOICE");
                                        continue;

                                    }
                                }
                                if(check_cart==1){
                                    continue;
                                }
                                else {
                                    break;
                                }
                            }

                        }
                        catch (Exception e) {
                            System.out.println("INVALID CHOICE");
                            continue;

                        }
                    }



                    if(check_dish==1){
                        continue;
                    }
                    else {
                        break;
                    }
                }
            }
            catch (Exception e) {
                System.out.println("INVALID CHOICE");

            }
        }
    }
    public static int[] cart_index(int mint,int dint,int dish_num){
        int[] arr1=new int[3];
        arr1[0]=mint;
        arr1[1]=dint;
        arr1[2]=dish_num;
        return arr1;
    }
}