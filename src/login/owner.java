package login;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Cart.*;
import Menu.*;
public class owner {
    private String user_name;
    private String password;
    public static int count;
    static Scanner scanner=new Scanner(System.in);
    public String getUser_name() {
        return user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public static int log_in(ArrayList<owner> owners, ArrayList<customer> accounts , ArrayList<Resturant> reslist , ArrayList<Menu_Section> catList, ArrayList<Dish> dishList) throws IOException {
        int index=-1;
        while (true) {
            System.out.println("enter user name ");
            String user = scanner.nextLine();
            System.out.println("enter password");
            String password = scanner.nextLine();
            boolean flag=false;
            for (int i = 0; i < owners.size(); i++) {
                if(user.equals(owners.get(i).user_name)&&password.equals(owners.get(i).password)){
                    System.out.println("success");
                    index=i;
                    break;
                }
            }
            if(index!=-1){
                break;
            }
            else {
                System.out.println("user name or password is wrong");
                System.out.println("1-TRY AGAIN");
                System.out.println(" PRESS ANY BUTTON FOR BACK");
                String choice=scanner.nextLine();
                if(choice.equals("1")){
                    continue;
                }
                else {
                    menulist.show_main_menu(owners,accounts,reslist,catList,dishList);
                    break;
                }
            }
        }
        return index;
    }

    public static void add_dish(ArrayList<owner> owners,ArrayList<customer> accounts , ArrayList<Resturant> reslist , ArrayList<Menu_Section> catList, ArrayList<Dish> dishList,int index) throws IOException {
        Scanner scan=new Scanner(System.in);

        for(int i=0;i<reslist.get(index).catcount;i++){
            System.out.println((i+1)+" "+reslist.get(index).sections.get(i).name);
        }
        System.out.println(reslist.get(index).catcount+1+"- back");
        System.out.println("enter number");
        while (true) {
            String i = scanner.next();

            if (Resturant.isNumeric(i) == true) {
                if(Integer.parseInt(i)>0&&Integer.parseInt(i)<reslist.get(index).catcount){
                    int s=Integer.parseInt(i);
                    while (true) {
                        reslist.get(index).sections.get(s - 1).dishes.add(new Dish());
                        System.out.println("Enter name of dish:");
                        reslist.get(index).sections.get(s - 1).dishes.get(reslist.get(index).sections.get(s - 1).dishes_count).name = scanner.next();

                        while (true) {
                            System.out.println("Enter price of dish:");
                            String c_price = scanner.next();
                            if (Resturant.isdouble(c_price) == true) {
                                reslist.get(index).sections.get(s - 1).dishes.get(reslist.get(index).sections.get(s - 1).dishes_count).price = Double.parseDouble(c_price);
                                break;
                            } else {
                                System.out.println("Invalid Input");
                                continue;
                            }
                        }
                        System.out.println("Enter origin of dish:");
                        reslist.get(index).sections.get(s - 1).dishes.get(reslist.get(index).sections.get(s - 1).dishes_count).origin = scan.next();
                        while (true) {
                            System.out.println("Enter quantity of dish:");
                            String c_quan = scan.next();
                            if (Resturant.isNumeric(c_quan) == true) {
                                reslist.get(index).sections.get(s - 1).dishes.get(reslist.get(index).sections.get(s - 1).dishes_count).quantity = Integer.parseInt(c_quan);
                                break;
                            } else {
                                System.out.println("Invalid Input");
                                continue;
                            }
                        }
                        System.out.println("Enter description of dish:");
                        reslist.get(index).sections.get(s - 1).dishes.get(reslist.get(index).sections.get(s - 1).dishes_count).description = scan.next();
                        while (true) {
                            System.out.println("Enter discount of dish:");
                            String c_dis = scan.next();
                            if (Resturant.isdouble(c_dis) == true) {
                                reslist.get(index).sections.get(s - 1).dishes.get(reslist.get(index).sections.get(s - 1).dishes_count).discount = Double.parseDouble(c_dis);
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
                                reslist.get(index).sections.get(s - 1).dishes.get(reslist.get(index).sections.get(s - 1).dishes_count).rate = Double.parseDouble(c_rate);
                                break;
                            } else {
                                System.out.println("Invalid Input");
                                continue;
                            }
                        }
                        while (true) {
                            try {

                                System.out.println("0-vegetarian     1- not vegetarian      2-max");
                                String veg = scanner.next();
                                if (Integer.parseInt(veg) == 1 || Integer.parseInt(veg) == 2 || Integer.parseInt(veg) == 0) {
                                    reslist.get(index).sections.get(s - 1).dishes.get(reslist.get(index).sections.get(s - 1).dishes_count).isveg = Integer.parseInt(veg);
                                    Dish.dish_count++;

                                    reslist.get(index).sections.get(s - 1).dishes_count++;
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
                        System.out.println("1-add new dish");
                        System.out.println("PRESS ANY BUTTON FOR BACK");
                        String c=scan.next();
                        if(c.equals("1")) {
                            add_dish(owners, accounts, reslist, catList, dishList,index);
                            break;
                        }
                        else {
                            menulist.show_main_owner_list(owners,accounts,reslist,catList,dishList,index);
                            break;
                        }

                    }

                } else if (Integer.parseInt(i)==reslist.get(index).catcount+1) {
                    //owner list();
                    break;
                }
                else{
                    System.out.println("invalid");
                    System.out.println("enter new number");
                    continue;
                }

            }
            else {
                System.out.println("INVALID");
                continue;
            }
            break;
        }

    }
    public static void remove_dish(ArrayList<owner> owners, ArrayList<customer> accounts, ArrayList<Resturant> reslist, ArrayList<Menu_Section> catList, ArrayList<Dish> dishList, int index) throws IOException {
        while (true) {
            System.out.println("Enter Number of Category");
            Scanner scan = new Scanner(System.in);
            //int var=0;
            for (int i = 0; i < reslist.get(index).catcount; i++) {
                System.out.println((i + 1) + " " + reslist.get(index).sections.get(i).name);
            }
            System.out.println(reslist.get(index).catcount + 1 + "- back");
            String in = scan.next();
            if (Integer.parseInt(in) > 0 && Integer.parseInt(in) <= reslist.get(index).catcount) {
                int i;
                int var = Integer.parseInt(in);
                System.out.println("Enter Desired Dish");
                System.out.println("------------------");
                for (i = 0; i < reslist.get(index).sections.get(var - 1).dishes_count; i++) {
                    System.out.println((i + 1) + " " + reslist.get(index).sections.get(var - 1).dishes.get(i).name);
                }
                System.out.println(reslist.get(index).sections.get(var-1).dishes_count+ 1 + "- back");
                int got = scan.nextInt();
                if(Integer.parseInt(in) == reslist.get(index).sections.get(var-1).dishes_count+ 1){
                    menulist.show_main_owner_list(owners,accounts,reslist,catList,dishList,index);
                    return;
                }
                else {
                    while (true) {
                        System.out.println("Do you Want to Delete " + reslist.get(index).sections.get(var - 1).dishes.get(got - 1).name + " Dish?(Y /N)");
                        char z = scan.next().charAt(0);
                        if (z == 'Y' || z == 'N' || z == 'y' || z == 'n') {
                            if (z == 'Y' || z == 'y') {
                                reslist.get(index).sections.get(var - 1).dishes.get(got - 1).cout_removedish = -1;
                                System.out.println("Exit from System To Save Changes.");
                                menulist.show_main_owner_list(owners, accounts, reslist, catList, dishList, index);
                                return;

                            }
                            else {
                                //System.out.println("Exit from System i Save Changes.");
                                System.out.println("1-Back");
                                int e = scan.nextInt();
                                menulist.show_main_owner_list(owners, accounts, reslist, catList, dishList, index);
                                return;
                            }
                        }
                        else {
                            System.out.println("Enter Valid Char");
                            continue;
                        }
                    }
                }
//                menulist.show_main_owner_list(owners, accounts, reslist, catList, dishList, index);
//                break;
            }
            else if (Integer.parseInt(in) == reslist.get(index).catcount + 1) {
                menulist.show_main_owner_list(owners, accounts, reslist, catList, dishList, index);
                return;
            }
        }
    }
    public static void update_price(ArrayList<owner> owners, ArrayList<customer> accounts, ArrayList<Resturant> reslist, ArrayList<Menu_Section> catList, ArrayList<Dish> dishList, int index) throws IOException {
        while (true) {
            System.out.println("Enter Number of Category");
            Scanner scan = new Scanner(System.in);
            //int var=0;
            for (int i = 0; i < reslist.get(index).catcount; i++) {
                System.out.println((i + 1) + " " + reslist.get(index).sections.get(i).name);
            }
            System.out.println(reslist.get(index).catcount + 1 + "- back");
            String in = scan.next();
            if (Integer.parseInt(in) > 0 && Integer.parseInt(in) <= reslist.get(index).catcount) {
                int i;
                int var = Integer.parseInt(in);
                System.out.println("Enter Desired Dish");
                System.out.println("------------------");
                for (i = 0; i < reslist.get(index).sections.get(var - 1).dishes_count; i++) {
                    System.out.println((i + 1) + " " + reslist.get(index).sections.get(var - 1).dishes.get(i).name);
                }
                System.out.println(reslist.get(index).sections.get(var-1).dishes_count+ 1 + "- back");
                int got = scan.nextInt();
                if(Integer.parseInt(in) == reslist.get(index).sections.get(var-1).dishes_count+ 1){
                    menulist.show_main_owner_list(owners,accounts,reslist,catList,dishList,index);
                    return;
                }
                else {
                    while (true) {
                        System.out.println("Do you Want To Change Price Of " + reslist.get(index).sections.get(var - 1).dishes.get(got - 1).name + " Dish?(Y /N)");
                        char z = scan.next().charAt(0);
                        if (z == 'Y' || z == 'N' || z == 'y' || z == 'n') {
                            if (z == 'Y' || z == 'y') {
                                while (true) {
                                    System.out.println("Enter  New price of dish:");
                                    String c_price = scanner.next();
                                    if (Resturant.isdouble(c_price) == true) {
                                        reslist.get(index).sections.get(var - 1).dishes.get(got-1).price = Double.parseDouble(c_price);
                                        System.out.println("Price Updated Successful");
                                        break;
                                    } else {
                                        System.out.println("Invalid Input");
                                        continue;
                                    }
                                }
                                System.out.println("Exit from System To Save Changes.");
                                menulist.show_main_owner_list(owners, accounts, reslist, catList, dishList, index);
                                return;

                            }
                            else {

                                menulist.show_main_owner_list(owners, accounts, reslist, catList, dishList, index);
                                return;
                            }
                        }
                        else {
                            System.out.println("Enter Valid Char");
                            continue;
                        }
                    }
                }

            }
            else if (Integer.parseInt(in) == reslist.get(index).catcount + 1) {
                menulist.show_main_owner_list(owners, accounts, reslist, catList, dishList, index);
                return;
            }
        }
    }
    public static boolean isNumeric(String s){
        try {
            Integer.parseInt(s);
            return  true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }
    public static boolean isdouble(String s){
        try {
            Double.parseDouble(s);
            return  true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }
}