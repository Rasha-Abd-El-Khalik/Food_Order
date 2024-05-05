package login;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Menu.*;
public class customer extends user {
    public String email;
    public String address;
    public String phone_num;
    public String ques_number;
    public String Answer;
    public static int counter;
    public ArrayList<String> itmes1 = new ArrayList<>();
    public ArrayList<Integer>itmesquan = new ArrayList<>();
    public ArrayList<Double> itmesprice = new ArrayList<>();
    static {
        try {
            counter = file.countLines()/8;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static Scanner scanner=new Scanner(System.in);
    public customer(String user_name, String password, String name, String email, String address, String phone_num,String ques,String answer) {
        super(user_name, password, name);
        this.email = email;
        this.address = address;
        this.phone_num = phone_num;
        this.ques_number=ques;
        this.Answer=answer;
        counter++;
    }
    public static String check_passord(){
        System.out.print("Password : (At Least 8 Digit!!)");
        String PASS=scanner.next();
        while(true){
            boolean containsOnlyLetters = PASS.matches("[a-zA-Z]+");
            boolean containsOnlyNumbers = PASS.matches("\\d+");
            if(PASS.length()>=8){
                if(!containsOnlyLetters&&!containsOnlyNumbers){
                    System.out.println(" ENTER CONFIRM PASSWORD");
                }
                else{
                    System.out.println("YOUR PASSWORD IS WEAK ENTER ANOTHER ONE");
                    PASS=scanner.next();
                    continue;
                }
                String confirm_pass = scanner.next();
                if(PASS.equals(confirm_pass)){
                    //correct password
                    return PASS;

                }
                else{
                    System.out.println("NOT MATCHING WITH PASSwORD");
                    continue;
                }
            }
            else{
                System.out.println("YOU MUST ENTER AT LEAST 8 DIGITS");
                PASS=scanner.next();
                continue;
            }

        }
    }
    public static void create_account(ArrayList<owner> owners, ArrayList<customer> acc , ArrayList<Resturant> res , ArrayList<Menu_Section> cat, ArrayList<Dish> dih) throws IOException {
        System.out.println("1-Enter Your Data");
        System.out.println("2-Press Any Button To Back");
        String q = scanner.nextLine();
        if(q.equals("1")) {
            System.out.print("User Name :");
            String UN = scanner.nextLine();
            boolean check2 = false;
            while (check2 == false&&customer.counter!=0){
                for (customer s : acc) {
                    if (s.getUser_name().equals(UN)) {
                        System.out.println("Enter Another User Name this is exist");
                        System.out.print("User Name :");
                        UN = scanner.nextLine();
                        check2 = false;
                        break;
                    }
                    else {
                        check2 = true;
                    }
                }
            }
            System.out.print("NAME :");
            String NAME = scanner.nextLine();
            //
            System.out.print("Email :");
            String mail = scanner.nextLine();
            boolean check1 = false;
            while (check1 == false&&customer.counter!=0) {
                for (customer s : acc) {
                    if (s.email.equals(mail)) {
                        System.out.println("Enter Another Email this is exist");
                        System.out.print("Email :");
                        mail = scanner.nextLine();
                        check1 = false;
                        break;
                    }
                    else {
                        check1 = true;
                    }
                }
            }
            System.out.print("Phone Number :");
            String Phone = scanner.nextLine();
            boolean check3 = false;
            while (check3 == false&&customer.counter!=0) {
                for (customer s : acc) {
                    if (s.phone_num.equals(Phone)) {
                        System.out.println("Enter Another Phone Number this is exist");
                        System.out.print("Phone Number :");
                        Phone = scanner.nextLine();
                        check3 = false;
                        break;
                    }
                    else if(Phone.length()!=11){
                        System.out.println("WRONG INFO MUST BE 11 DIGIT");
                        System.out.print("Phone Number :");
                        Phone = scanner.nextLine();
                        check3 = false;
                        break;
                    }
                    else {
                        check3 = true;
                    }
                }
            }
            System.out.print("Address :");
            String ADRS=scanner.nextLine();
            //
            System.out.println("\t\t\t--------------------------------------\t\t");
            System.out.println("\t\t\t|       CHOOSE SECURITY QUESTION :   |\t\t");
            System.out.println("\t\t\t|------------------------------------|\t\t");
            System.out.println("\t\t\t|1- WHAT CITY WERE YOU BORN IN?      |");
            System.out.println("\t\t\t|2- WHAT IS YOUR HOBBY?              |");
            System.out.println("\t\t\t|3- WHAT IS YOUR NICKNAME?           |");
            System.out.println("\t\t\t|4- WHAT IS YOUR FAVORITE FOOD?      |");
            System.out.println("\t\t\t|5- WHO IS YOUR SUPER HERO?          |");
            System.out.println("\t\t\t--------------------------------------\t\t");
            System.out.println("\t\t YOUR CHOICE:) : ");
            String ques=scanner.next();
            System.out.println("Enter Your Answer");
            String answer=scanner.next();
            String PASS=check_passord();
            acc.add(new customer(UN,PASS,NAME,mail,ADRS,Phone,ques,answer));
            System.out.println("You Have Created Account Successfully");
            System.out.println("--------------------------------------");
            menulist.show_main_menu(owners,acc,res,cat,dih);
        }
        else if (q.equals("2")){
            menulist.show_main_menu(owners,acc , res , cat , dih);
        }


    }
    public static int login(ArrayList<customer> acc , ArrayList<owner> owners , ArrayList<Resturant> res , ArrayList<Menu_Section> cat, ArrayList<Dish> dih) throws IOException {
        System.out.println("1-SIGN IN ");
        System.out.println("2-BACK ");
        while (true) {
            String o = scanner.next();
            if (o.equals("1")) {
                while (true) {
                    System.out.println("ENTER YOUR USER_NAME \\ E-MAIL \\ PHONE_NUMBER");
                    String uep = scanner.next();
                    for (customer c : acc) {
                        String u = c.getUser_name();
                        String e = c.email;
                        String ph = c.phone_num;
                        String pa = c.getPassword();
                        if (((u.equals(uep)) || (e.equals(uep)) || (ph.equals(uep)))) {
                            password(c , acc , owners,res,cat, dih);
                            Settings(c ,acc,owners,res,cat,dih);
                            return acc.indexOf(c);
                        }
                    }
                    System.out.println("NOT FOUND..PLEASE ENTER VALID ACCOUNT");
                    continue;
                }
            }
            else if (o.equals("2")) {
                try {
                    menulist.show_main_menu(owners , acc ,res , cat ,dih);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                return(10000);
            } else {
                System.out.println("Invalid Choice...PLEASE ENTER VALID OPTION");
                continue;
            }
        }

    }

    public static void password(customer c, ArrayList<customer> acc , ArrayList<owner> owners , ArrayList<Resturant> res , ArrayList<Menu_Section> cat, ArrayList<Dish> dih ) {
        System.out.println("ENTER YOUR PASSWORD :");
        while (true) {
            String pass = scanner.next();
            if (pass.equals(c.getPassword())) {
                System.out.println("WELCOME " + c.name.toUpperCase());
                break;
            } else {
                System.out.println("WRONG PASSWORD..");
                System.out.println("1-TRY AGAIN");
                System.out.println("2-PRESS ANY BUTTON FOR BACK");
                String o = scanner.next();
                if (o.equals("1")) {
                    System.out.println("ENTER YOUR PASSWORD");
                    continue;
                } else {
                    try {
                        menulist.show_main_menu(owners,acc,res,cat,dih);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                }
            }

        }
    }

    public static void forget_password(ArrayList<owner> owners, ArrayList<customer> acc , ArrayList<Resturant>res , ArrayList<Menu_Section> cat, ArrayList<Dish> dih) throws IOException {
        while (true) {
            System.out.println("ENTER YOUR USER NAME OR YOUR EMAIL OR YOUR PHONE NUMBER ");
            String user = scanner.next();
            boolean flag = false;
            int index1=-1;
            int index2=-1;
            for (customer c : acc) {
                index1++;
                if (c.getUser_name().equals(user) || c.email.equals(user) || c.phone_num.equals(user)) {
                    index2=index1;
                    flag = true;
                    break;
                }
            }
            if(flag){
                while (true) {
                    System.out.println("\t\t\t--------------------------------------\t\t");
                    System.out.println("\t\t\t|       CHOOSE SECURITY QUESTION :   |\t\t");
                    System.out.println("\t\t\t|------------------------------------|\t\t");
                    System.out.println("\t\t\t|1- WHAT CITY WERE YOU BORN IN?      |");
                    System.out.println("\t\t\t|2- WHAT IS YOUR HOBBY?              |");
                    System.out.println("\t\t\t|3- WHAT IS YOUR NICKNAME?           |");
                    System.out.println("\t\t\t|4- WHAT IS YOUR FAVORITE FOOD?      |");
                    System.out.println("\t\t\t|5- WHO IS YOUR SUPER HERO?          |");
                    System.out.println("\t\t\t--------------------------------------\t\t");
                    System.out.println("\t\t YOUR CHOICE:) : ");
                    String ques = scanner.next();
                    System.out.println("ENTER YOUR ANSWER");
                    String answer = scanner.next();
                    if (acc.get(index2).ques_number.equals(ques) && acc.get(index2).Answer.equals(answer)) {
                        String pass= check_passord();
                        System.out.println("YOUR PASSWORD UPDATED SUCCESSFUL");
                        acc.get(index2).setPassword(pass);
                        menulist.show_main_menu(owners,acc , res , cat , dih);
                        return;
                    }
                    else {
                        System.out.println("QUESTION OR ANSWER IS WRONG");
                        System.out.println("1-TRY AGAIN");
                        System.out.println("2-BACK");
                        String CHOICE=scanner.next();
                        if(CHOICE.equals("1"))
                            continue;
                        else if (CHOICE.equals("2")) {
                            menulist.show_main_menu(owners,acc , res , cat , dih);
                            return;
                        }
                    }
                }

            }
            else{
                System.out.println(" ACCOUNT DOES NOT EXIST!!!!");
                System.out.println("1-TRY AGAIN");
                System.out.println("2-BACK");
                String CHOICE=scanner.next();
                if(CHOICE.equals("1"))
                    continue;
                else if (CHOICE.equals("2")) {
                    menulist.show_main_menu(owners,acc , res , cat , dih);
                    break;
                }
            }

        }
    }
    public static void Settings(customer c, ArrayList<customer> acc, ArrayList<owner> owner, ArrayList<Resturant> reslist, ArrayList<Menu_Section> catlist, ArrayList<Dish> dishlist) throws IOException {
        int index1=0;
        System.out.println("________________________________");
        System.out.println("1-->DISPLAY PERSONAL INFORMATION");
        System.out.println("2-->EDIT PERSONAL INFORMATION   ");
        System.out.println("3-->Search                      ");
        System.out.println("4-->LOGOUT                      ");
        System.out.println("________________________________");
        while(true)
        {
            boolean flag=false;
            String option = scanner.next();
            if(option.equals("1"))
            {
                System.out.println("=====================================");
                System.out.println("| NAME:"+c.name+"                   |");
                System.out.println("| USER NAME:"+c.getUser_name()+"    |");
                System.out.println("| PASSWORD:"+c.getPassword()+"      |");
                System.out.println("| PHONE NUMBER:"+c.phone_num+"      |");
                System.out.println("| ADDRESS:"+c.address+"             |");
                System.out.println("| EMAIL:"+c.email+"                 |");
                System.out.println("=====================================");
                System.out.println(" PRESS 1 TO BACK TO Menu");
                while(true) {
                    String o = scanner.next();
                    if (o.equals("1")) {
                        customer.Settings(c,acc,owner,reslist,catlist,dishlist);
                        return;
                    }
                    else
                    {
                        System.out.println("INVALID OPTION PRESS AGAIN");
                        continue;
                    }
                }
            }
            else if(option.equals("2"))
            {
                System.out.println("=====================================");
                System.out.println("|   1-CHANGE YOUR USER NAME         |");
                System.out.println("|   2-CHANGE YOUR PASSWORD          |");
                System.out.println("|   3-LOGOUT                        |");
                System.out.println("=====================================");
                while(true)
                {
                    String op = scanner.next();
                    if(op.equals("1"))
                    {
                        System.out.println("ENTER NEW USER NAME:");
                        while(true)
                        {
                            boolean ch =false;
                            String new_uname=scanner.next();
                            for(customer cust:acc)
                            {
                                String u = cust.getUser_name();
                                if(u.equals(new_uname)){
                                    System.out.println("THIS USER NAME IS ALREADY EXIST ENTER ANOTHER:");
                                    ch=true;
                                    break;
                                }
                            }
                            if(ch)
                            {
                                continue;
                            }
                            else
                            {
                                System.out.println(" PRESS 1 TO SAVE CHANGES:");
                                System.out.println(" PRESS 2 TO BACK TO HOME PAGE:");
                                while (true)
                                {
                                    String s = scanner.next();
                                    if (s.equals("1")) {
                                        c.setUser_name(new_uname);
                                        break;
                                    }
                                    else if(s.equals("2"))
                                    {
                                        customer.Settings(c,acc,owner,reslist,catlist,dishlist);
                                        return;

                                    }
                                    else{
                                        System.out.println("INVALID OPTION");
                                        continue;
                                    }
                                }
                                break;
                            }
                        }

                        customer.Settings(c,acc,owner,reslist,catlist,dishlist);
                        return;//customer page
                    }
                    else if(op.equals("2"))
                    {
                        System.out.println("ENTER YOUR NEW PASSWORD");
                        String new_password=check_passord();
                        System.out.println(" PRESS 1 TO SAVE CHANGES:");
                        System.out.println("PRESS 2 TO BACK FOR HOME PAGE");
                        while(true)
                        {
                            String p=scanner.next();
                            if(p.equals("1"))
                            {
                                c.setPassword(new_password);
                                break;
                            }
                            else if(p.equals("2"))
                            {
                                customer.Settings(c,acc,owner,reslist,catlist,dishlist);
                                return;
                                //home page
                            }
                            else
                            {
                                continue;
                            }
                        }
                        customer.Settings(c,acc,owner,reslist,catlist,dishlist);
                        return;//customer page
                    }
                    else if(op.equals("3"))
                    {
                        customer.Settings(c,acc,owner,reslist,catlist,dishlist);
                        return;
                    }
                    else
                    {
                        System.out.println("ENTER VALID OPTION..");
                        continue;
                    }
                }
            }
            else if(option.equals("3"))
            {
                for(int h=0;h<acc.size();h++){
                    String user=acc.get(h).getUser_name();
                    String user1=c.getUser_name();
                    if(user.equals(user1)){
                        index1=h;
                        break;
                    }
                }
                Resturant.Search(index1,reslist,catlist,dishlist,owner,acc, c);
                return;
                //customer home
            }
            else if(option.equals("4"))
            {
                menulist.show_main_menu(owner,acc,reslist,catlist,dishlist);
                return;
                //customer home
            }
            else
            {
                System.out.println("INVALID OPTION TRY AGAIN:");
                continue;
            }
        }
    }
    public static int REturn_index(ArrayList<customer> acc , ArrayList<owner> owners , ArrayList<Resturant> res , ArrayList<Menu_Section> cat, ArrayList<Dish> dih,String uep) throws IOException {
        while (true) {
            for (customer c : acc) {
                String u = c.getUser_name();
                String e = c.email;
                String ph = c.phone_num;
                String pa = c.getPassword();
                if (((u.equals(uep)) || (e.equals(uep)) || (ph.equals(uep)))) {
                    return acc.indexOf(c);
                }
            }
        }
    }
}