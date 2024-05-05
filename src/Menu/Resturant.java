package Menu;
import login.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
public class Resturant {
    public static int res_count;
    public String name;
    public int id;
    public String address;
    public int branch;
    public String phone_number;
    public String type;
    public double rate;
    public String origin;
    public int catcount = 0;
    public int cout_remove = 0;
    public ArrayList<Menu_Section> sections = new ArrayList<>();
    public ArrayList<String> extra_name = new ArrayList<>();
    public ArrayList<Double> extra_price = new ArrayList<>();
    public owner own = new owner();
    public static void res_search(int index1, ArrayList<Resturant> resturants, ArrayList<Menu_Section> sections, ArrayList<Dish> dishes, ArrayList<owner> owners, ArrayList<customer> acc, customer c) throws FileNotFoundException {
        int back = 0;
        int t = 0;
        while (true) {
            back = 0;
            t = 0;
            try {
                for (int i = 0; i < resturants.size(); i++) {
                    System.out.println((i + 1) + " - " + resturants.get(i).name);
                    back++;
                }
                back++;
                System.out.println(back + " - Back");
                Scanner input = new Scanner(System.in);
                String m = input.next();
                t = Integer.parseInt(m);
                if (t == (res_count + 1)) {
                    Resturant.Search(index1,resturants, sections, dishes, owners, acc, c);
                    break;
                } else if (t >= 1 && t < (res_count + 1)) {
                    Menu_Section.section_search(index1,sections, m, resturants, dishes, owners, acc, c);
                    break;
                } else {
                    System.out.println("INVALID CHOICE");
                }
            } catch (Exception e) {
                System.out.println("INVALID CHOICE");
                continue;
            }
        }
    }

    public static void type(int index1, ArrayList<Resturant> resturants, ArrayList<Menu_Section> sections, ArrayList<Dish> dishes, ArrayList<owner> owners, ArrayList<customer> acc, customer c) {
        ArrayList<String> strings = new ArrayList<>();
        String arr[] = new String[Resturant.res_count];
        ArrayList<Integer> arrindex2 = new ArrayList<>();
        int count = 0;
        int count1 = 0;
        int check = 0;

        while (true) {
            try {
                strings.clear();
                arrindex2.clear();
                count1 = 0;
                for (int i = 0; i < resturants.size(); i++) {
                    arr[i] = resturants.get(i).type;

                }
                Arrays.sort(arr);
                for (int i = 0; i < resturants.size(); i++) {
                    if ((i + 1) < Resturant.res_count) {
                        if (arr[i].equals(arr[i + 1])) {
                            continue;
                        } else {
                            strings.add(arr[i]);

                        }
                    } else {
                        strings.add(arr[(Resturant.res_count) - 1]);
                    }
                }
                for (int j = 0; j < strings.size(); j++) {
                    count1++;
                    System.out.println((j + 1) + " - " + strings.get(j).toUpperCase());
                }

                System.out.println((count1 + 1) + " - " + "Back");
                Scanner input = new Scanner(System.in);
                String type_input = input.next();
                int index = Integer.parseInt(type_input);
                if (index < 1 || index > (strings.size() + 1)) {
                    System.out.println("-------------------------------");
                    System.out.println("Invaild Choice");
                    continue;
                } else if (index == (strings.size() + 1)) {
                    Resturant.Search(index1,resturants, sections, dishes, owners, acc, c);
                    break;
                } else if (index >= 1 && index <= strings.size()) {
                    while (true) {
                        count = 0;
                        arrindex2.clear();
                        check = 0;
                        try {
                            for (int i = 0; i < resturants.size(); i++) {
                                if (resturants.get(i).type.equals(strings.get(index - 1))) {
                                    count++;
                                    System.out.println(count + " - " + resturants.get(i).name);
                                    arrindex2.add(i);
                                }
                            }
                            System.out.println((count + 1) + " - " + "Back");
                            String type_input2 = input.next();
                            if (Integer.parseInt(type_input2) < 1 || Integer.parseInt(type_input2) > (arrindex2.size() + 1)) {
                                System.out.println("-------------------------------");
                                System.out.println("Invaild Choice");
                                continue;
                            } else if (Integer.parseInt(type_input2) == (arrindex2.size() + 1)) {
                                check = 1;
                                break;//continue in the big while
                            } else if (Integer.parseInt(type_input2) >= 1 && Integer.parseInt(type_input2) <= arrindex2.size()) {
                                int type = arrindex2.get(Integer.parseInt(type_input2) - 1);
                                type++;

                                Menu_Section.section_search_type(index1,sections, String.valueOf(type), resturants, dishes, arrindex2, owners, acc, c);
                                break;
                            }
                        } catch (Exception d) {
                            System.out.println("---------------------------");
                            System.out.println("Invalid Choice");
                            continue;
                        }


                    }
                    if (check == 1) {
                        continue;
                    } else {
                        break;
                    }
                }
            } catch (Exception d) {
                System.out.println("---------------------------");
                System.out.println("Invalid Choice");
                continue;
            }
        }
    }

    public static void rate(int index1, ArrayList<Resturant> resturants, ArrayList<Menu_Section> sections, ArrayList<Dish> dishes, ArrayList<owner> owners, ArrayList<customer> acc, customer c) throws FileNotFoundException {
        int count = 0;
        int check = 0;
        int check1 = 0;
        int number = 0;//before resturant
        ArrayList<Integer> arrindex = new ArrayList<>();

        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println(" ========================");
            System.out.println("|  1- enter the rate     |");
            System.out.println("|  2-Back                |");
            System.out.println(" ========================");

            String rate = input.next();
            if (rate.equals("1") || rate.equals("2")) {
                if (rate.equals("2")) {
                    Resturant.Search( index1,resturants, sections, dishes, owners, acc, c);
                    break;
                } else if (rate.equals("1")) {
                    while (true) {
                        try {

                            System.out.println("----------------------");
                            System.out.println("enter the rate");
                            String resrate = input.next();
                            if (Double.parseDouble(resrate) >= 0 &&Double.parseDouble(resrate) <= 5) {
                                while (true) {
                                    arrindex.clear();
                                    number = 0;
                                    try {
                                        for (int i = 0; i < resturants.size(); i++) {

                                            if (resturants.get(i).rate == Double.parseDouble(resrate)) {
                                                arrindex.add(i);
                                                number++;
                                                System.out.println((number) + " - " + resturants.get(i).name);
                                                count = number + 1;
                                            }
                                        }

                                        if (count == 0) {
                                            check = 1;
                                            System.out.println("-----------------------------");
                                            System.out.println("No Resturant with this rate");
                                            break;
                                        }
                                        System.out.println((count) + " - Back");
                                        String res = input.next();
                                        if (Integer.parseInt(res) == count) {
                                            count = 0;
                                            check1 = 1;
                                            break;
                                        } else if (Integer.parseInt(res) < 0 || Integer.parseInt(res) > count) {

                                            System.out.println("-------------------------------");
                                            System.out.println("Invaild Choice");
                                            count = 0;
                                            continue;
                                        } else if (Integer.parseInt(res) > 0 && Integer.parseInt(res) < count) {
                                            count = 0;
                                            int i2 = arrindex.get(Integer.parseInt(res) - 1);
                                            String rescategory = String.valueOf(((int) i2) + 1);
                                            Menu_Section.section_search_rate(index1,sections, rescategory, resturants, dishes, resrate, arrindex, owners, acc, c);
                                            break;
                                        }

                                    } catch (Exception d) {
                                        System.out.println("---------------------------");
                                        System.out.println("Invalid Choice");
                                    }
                                }
                                if (check == 1) {
                                    check = 0;
                                    continue;
                                } else if (check == 0) {
                                    break;
                                }
                            } else {
                                System.out.println("---------------------------");
                                System.out.println("Invalid Rate");
                            }
                        } catch (Exception d) {
                            System.out.println("---------------------------");
                            System.out.println("Invalid Rate");
                        }
                    }
                }
                if (check1 == 1) {
                    check1 = 0;
                    continue;
                } else {
                    break;
                }
            } else {
                System.out.println("----------------------------------");
                System.out.println("Invalid Choice");
            }

        }
    }

    public static void Search(int index1, ArrayList<Resturant> reslist, ArrayList<Menu_Section> catList, ArrayList<Dish> dishList, ArrayList<owner> owners, ArrayList<customer> acc, customer c) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        while (true) {
            int loop_break = 0;
            System.out.println(("================================================"));
            System.out.println("|           1 - Search by restaurant            |");
            System.out.println("|           2 - Search by rate                  |");
            System.out.println("|           3 - Search by resturant Type        |");
            System.out.println("|           4 - Log Out                         |");
            System.out.println(" ================================================");
            String menu_input = input.next();
            try {
                if (menu_input.equals("1")) {
                    Resturant.res_search(index1,reslist, catList, dishList, owners, acc, c);
                    break;
                } else if (menu_input.equals("2")) {
                    Resturant.rate(index1,reslist, catList, dishList, owners, acc, c);
                    break;
                } else if (menu_input.equals("3")) {
                    Resturant.type(index1,reslist, catList, dishList, owners, acc, c);
                    break;
                } else if (menu_input.equals("4")) {

                    menulist.show_main_menu(owners, acc, reslist, catList, dishList);
                    break;
                } else {
                    System.out.println("Invalid number! Please enter 1 or 2 or 3 or 4.");
                }
            } catch (Exception e) {
                System.out.println("Error occurred: " + e.getMessage());
            }
        }
    }


    public static void rate(int index1, ArrayList<Resturant> resturants, ArrayList<Menu_Section> sections, ArrayList<Dish> dishes, String userrate, ArrayList<Integer> arrindex, ArrayList<owner> owners, ArrayList<customer> acc, customer c) throws FileNotFoundException {
        int back = 0;
        int t = 0;

        while (true) {
            back = 0;
            t = 0;
            try {
                for (int i = 0; i < resturants.size(); i++) {
                    if (resturants.get(i).rate == Float.parseFloat(userrate)) {
                        back++;
                        System.out.println((back) + " - " + resturants.get(i).name);
                    }
                }
                back++;
                System.out.println(back + " - Back");
                Scanner input = new Scanner(System.in);
                String m = input.next();
                t = Integer.parseInt(m);
                if (t == back) {
                    Resturant.rate(index1,resturants, sections, dishes, owners, acc, c);
                    break;
                } else if ((t < 1) || (t > back)) {
                    System.out.println("INVALID CHOICE");
                } else {
                    int i2 = arrindex.get(Integer.parseInt(m) - 1);
                    String rescategory = String.valueOf(((int) i2) + 1);
                    Menu_Section.section_search_rate(index1,sections, rescategory, resturants, dishes, userrate, arrindex, owners, acc, c);
                    break;
                }
            } catch (Exception e) {
                System.out.println("INVALID CHOICE");
                continue;
            }
        }
    }

    public static void type(int index1, ArrayList<Resturant> resturants, String m, ArrayList<Menu_Section> sections, ArrayList<Dish> dishes, ArrayList<Integer> arrindex2, ArrayList<owner> owners, ArrayList<customer> acc, customer c) throws FileNotFoundException {
        int back = 0;
        int t = 0;

        while (true) {
            back = 0;
            t = 0;
            try {
                for (int i = 0; i < arrindex2.size(); i++) {
                    back++;
                    System.out.println(back + " - " + resturants.get(arrindex2.get(i)).name);

                }
                back++;
                System.out.println(back + " - Back");
                Scanner input = new Scanner(System.in);
                String resnum = input.next();
                t = Integer.parseInt(resnum);
                if (t == back) {
                    Resturant.type(index1,resturants, sections, dishes, owners, acc, c);
                    break;
                } else if ((t < 1) || (t > back)) {
                    System.out.println("INVALID CHOICE");
                    continue;
                } else if (t >= 1 && t <= arrindex2.size()) {
                    int i2 = arrindex2.get(Integer.parseInt(resnum) - 1);
                    String rescategory = String.valueOf(((int) i2) + 1);
                    Menu_Section.section_search_type(index1,sections, rescategory, resturants, dishes, arrindex2, owners, acc, c);
                    break;
                }
            } catch (Exception e) {
                System.out.println("INVALID CHOICE");
                continue;
            }
        }
    }
    public static void add_restaurant(ArrayList<Resturant> reslist, ArrayList<Menu_Section> sections, ArrayList<Dish> dishes, ArrayList<owner> owners, ArrayList<customer> acc) {
        int check1 = 0;
        int check2 = 0;
        int check3 = 0;
        int check4 = 0;
        int check5 = 0;
        reslist.add(new Resturant());
        Resturant.res_count++;
        System.out.println("Enter name of Restaurant:");
        Scanner scan = new Scanner(System.in);
        reslist.get((reslist.size()) - 1).name = scan.next();
        reslist.get((reslist.size()) - 1).own.setUser_name(reslist.get((reslist.size()) - 1).name);
        reslist.get((reslist.size()) - 1).own.setPassword(customer.check_passord());
        reslist.get((reslist.size()) - 1).id = reslist.size();
        System.out.println("Enter address of Restaurant:");
        reslist.get((reslist.size()) - 1).address = scan.next();
        while (true) {
            System.out.println("Enter branch of Restaurant:");
            String c_branch = scan.next();
            if (Resturant.isNumeric(c_branch) == true) {
                reslist.get((reslist.size()) - 1).branch = Integer.parseInt(c_branch);
                break;
            } else {
                System.out.println("Invalid Input");
                continue;
            }
        }

        while (true) {
            System.out.println("Enter phone number of Restaurant:");
            //check long
            String c_phone = scan.next();
            if (Resturant.islong(c_phone) == true) {
                reslist.get((reslist.size()) - 1).phone_number = c_phone;
                break;
            } else {
                System.out.println("Invalid Input");
                continue;
            }
        }
        System.out.println("Enter type of Restaurant:");
        reslist.get((reslist.size()) - 1).type = scan.next();
        System.out.println("Enter origin of Restaurant:");
        reslist.get((reslist.size()) - 1).origin = scan.next();
        while (true) {
            System.out.println("Enter rate of Restaurant:");
            String c_rate = scan.next();
            if (Resturant.isdouble(c_rate) == true) {
                if(Double.parseDouble(c_rate)>=0&&Double.parseDouble(c_rate)<=5){
                    reslist.get((reslist.size()) - 1).rate = Integer.parseInt(c_rate);
                    break;
                }
                System.out.println("Invalid Input");
            } else {
                System.out.println("Invalid Input");
                continue;
            }
        }
        System.out.println("Enter number of extras options");
        while (true) {
            String s = new String();
            s = scan.next();
            if (Resturant.isNumeric(s) == true) {
                for (int h = 0; h < Integer.parseInt(s); h++) {
                    System.out.println("Enter Extra name " + (h + 1));
                    String name = scan.next();
                    reslist.get((reslist.size()) - 1).extra_name.add(name);
                    while (true) {
                        System.out.println("Enter the price");
                        {
                            String price = scan.next();
                            if (Resturant.isdouble(price)) {
                                reslist.get((reslist.size()) - 1).extra_price.add(Double.parseDouble(price));
                                break;
                            } else {
                                System.out.println("Invalid Input");
                                continue;
                            }
                        }
                    }


                }
                break;
            } else {
                System.out.println("Invalid Input");
                continue;
            }
        }
        System.out.println("Enter number of Section");
        int count = 1;
        while (true) {
            try {
                String opt = scan.next();
                if (Integer.parseInt(opt) > 0) {
                    reslist.get((reslist.size()) - 1).catcount = Integer.parseInt((opt));
                    for (int i = 0; i < Integer.parseInt(opt); i++) {
                        reslist.get((reslist.size()) - 1).sections.add(new Menu_Section());
                        count = 1;
                        Menu_Section.cat_count++;
                        System.out.println("Enter name of section " + (i + 1));
                        reslist.get((reslist.size()) - 1).sections.get(i).name = scan.next();
                        while (true) {
                            check2 = 0;
                            check1 = 0;
                            reslist.get((reslist.size()) - 1).sections.get(i).dishes.add(new Dish());
                            System.out.println("Enter Dish number " + count);
                            System.out.println("Enter name of dish:");
                            reslist.get((reslist.size()) - 1).sections.get(i).dishes.get(count - 1).name = scan.next();

                            while (true) {
                                System.out.println("Enter price of dish:");
                                String c_price = scan.next();
                                if (Resturant.isdouble(c_price) == true) {
                                    reslist.get((reslist.size()) - 1).sections.get(i).dishes.get(count - 1).price = Double.parseDouble(c_price);
                                    break;
                                } else {
                                    System.out.println("Invalid Input");
                                    continue;
                                }
                            }
                            System.out.println("Enter origin of dish:");
                            reslist.get((reslist.size()) - 1).sections.get(i).dishes.get(count - 1).origin = scan.next();
                            while (true) {
                                System.out.println("Enter quantity of dish:");
                                String c_quan = scan.next();
                                if (Resturant.isNumeric(c_quan) == true) {
                                    reslist.get((reslist.size()) - 1).sections.get(i).dishes.get(count - 1).quantity = Integer.parseInt(c_quan);
                                    break;
                                } else {
                                    System.out.println("Invalid Input");
                                    continue;
                                }
                            }
                            System.out.println("Enter description of dish:");
                            reslist.get((reslist.size()) - 1).sections.get(i).dishes.get(count - 1).description = scan.next();
                            while (true) {
                                System.out.println("Enter discount of dish:");
                                String c_dis = scan.next();
                                if (Resturant.isdouble(c_dis) == true) {
                                    reslist.get((reslist.size()) - 1).sections.get(i).dishes.get(count - 1).discount = Double.parseDouble(c_dis);
                                    break;
                                } else {
                                    System.out.println("Invalid Input");
                                    continue;
                                }
                            }
                            while (true) {
                                System.out.println("Enter rate of dish:");
                                String c_rate = scan.next();
                                if (Resturant.isdouble(c_rate) == true) {
                                    if (Double.parseDouble(c_rate) >= 0 && Double.parseDouble(c_rate) <= 5) {
                                        reslist.get((reslist.size()) - 1).sections.get(i).dishes.get(count - 1).rate = Double.parseDouble(c_rate);
                                        break;

                                    }
                                    System.out.println("Invalid Input");
                                }else {
                                    System.out.println("Invalid Input");
                                    continue;
                                }
                            }
                            while (true) {
                                try {

                                    System.out.println("0-vegetarian     1- not vegetarian      2-max");
                                    String veg = scan.next();
                                    if (Integer.parseInt(veg) == 1 || Integer.parseInt(veg) == 2 || Integer.parseInt(veg) == 0) {
                                        reslist.get((reslist.size()) - 1).sections.get(i).dishes.get(count - 1).isveg = Integer.parseInt(veg);
                                        Dish.dish_count++;

                                        reslist.get((reslist.size()) - 1).sections.get(i).dishes_count++;
                                        break;
                                    } else {
                                        System.out.println("INVALID CHOICE");
                                        continue;
                                    }
                                } catch (Exception c) {
                                    System.out.println("INVALID CHOICE");
                                    continue;
                                }
                            }
                            while (true) {
                                System.out.println("1-New Dish in the same cat");
                                System.out.println("2-New Dish in New Cat");
                                String input = new String();
                                while (true) {
                                    input = scan.next();
                                    if (input.equals("1")) {
                                        count++;
                                        check1 = 1;
                                        check2 = 1;
                                        break;
                                    } else if (input.equals("2")) {
                                        check1 = 1;
                                        break;
                                    } else {
                                        System.out.println("invalid choice");
                                        continue;
                                    }
                                }
                                if (check1 == 1) {
                                    break;
                                }

                            }
                            if (check2 == 1) {
                                continue;
                            } else {
                                break;
                            }


                        }
                        if (check4 == 1) {
                            break;
                        }
                    }
                    System.out.println("You have Entered All Section's Number");
                    System.out.println("To confirm Changes Exit");
                    menulist.show_admin_restaurant_list(owners, acc, reslist, sections, dishes);
                }
            } catch (Exception c) {
                System.out.println("INVALID Input");
                System.out.println("Enter new number number of Section");
                continue;
            }
            break;


        }
    }

    public static boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isdouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean islong(String s) {
        try {
            Long.parseLong(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void remove(ArrayList<Resturant> reslist, ArrayList<Menu_Section> sections, ArrayList<Dish> dishes, ArrayList<owner> owners, ArrayList<customer> acc) throws IOException, IOException {
        int count = 0;
        for (int i = 0; i < reslist.size(); i++) {
            System.out.println((i + 1) + " " + reslist.get(i).name);
        }
        System.out.println((reslist.size() + 1) + "- BACK");
        while (true) {
            Scanner scan = new Scanner(System.in);
            String input = scan.next();
            if (Resturant.isNumeric(input) == true) {
                if (Integer.parseInt(input) <= reslist.size()) {
                    String remove = new String();
                    while (true) {
                        System.out.println("1-Confrim remove ");
                        System.out.println("2-Back");
                        remove = scan.next();
                        if (remove.equals("1")) {
                            reslist.get(Integer.parseInt((input)) - 1 + (count)).cout_remove = -1;
                            count++;
                            break;
                        } else if (remove.equals("2")) {
                            Resturant.remove(reslist, sections, dishes, owners, acc);
                            break;
                        } else {
                            System.out.println("Invalid Choice");
                            continue;
                        }
                    }
                } else if (Integer.parseInt(input) == reslist.size() + 1) {
                    //back admin list
                } else {
                    System.out.println("Invalid Choice");
                    continue;
                }
                break;
            } else {
                System.out.println("Invalid Choice");
                continue;
            }

        }
        System.out.println("To confirm Changes Exit");
        menulist.show_admin_restaurant_list(owners, acc, reslist, sections, dishes);

    }
    public static void check_owner(ArrayList<Resturant> reslist) {
        for (int i = 0; i < reslist.size(); i++) {
            System.out.println(reslist.get(i).own.getUser_name());
            System.out.println(reslist.get(i).own.getPassword());

        }
    }

    public static void remove_cart(ArrayList<Resturant> resturants, ArrayList<Menu_Section> sections, ArrayList<Dish>dishes, ArrayList<customer> acc, ArrayList<owner> owners, int[] arr, int index1, String inp, customer c) throws FileNotFoundException {
        int check=0;

        while (true){
            try {
                System.out.println("your cart");
                for (int i = 0; i <  acc.get(index1).itmes1.size(); i++) {
                    System.out.println( (i+1)+" - "+  acc.get(index1).itmes1.get(i));

                }

                System.out.println("press any button to back");
                Scanner scan = new Scanner(System.in);

                String input = scan.next();
                if(Integer.parseInt(input)>=1&&Integer.parseInt(input)<= acc.get(index1).itmes1 .size()){

                    System.out.println("1-remove item");
                    System.out.println("press any button to back");
                    try {


                        String input2 = scan.next();
                        {
                            if (Integer.parseInt(input2) == 1) {

                                for (int i = 0; i <acc.get(index1).itmes1.size(); i++) {
                                        acc.get(index1).itmes1.remove (Integer.parseInt(input)-1);
                                    acc.get(index1).itmesprice.remove (Integer.parseInt(input)-1);
                                        System.out.println("the new cart");
                                        break;




                                }



                                continue;





                            } else {
                                continue;
                            }
                        }
                    }catch (Exception n){
                        continue;
                    }
                }
                else {
                    Dish.cat_cart(index1,resturants,sections,dishes,acc,owners,arr, c);
                    break;
                }
            }catch (Exception e) {

                Dish.cat_cart(index1,resturants,sections,dishes,acc,owners,arr, c);
                break;


            }
        }
    }
}