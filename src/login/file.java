package login;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Cart.*;
import Menu.*;
public class file {
    public static void read_from_file(ArrayList<Resturant> reslist,ArrayList<customer> account_list, ArrayList<owner> owners) throws FileNotFoundException {

        File fis = new File("read_write.txt");
        int section_counter = 0;
        int res_counter = 0;
        int dish_counter = 0;
        try (Scanner scan = new Scanner(fis)) {

            while (scan.hasNextLine()) {

                section_counter = 0;

                reslist.add(new Resturant());
                Resturant.res_count++;
                reslist.get(res_counter).name = scan.nextLine();
                reslist.get(res_counter).id = Integer.parseInt(scan.nextLine());
                reslist.get(res_counter).address = scan.nextLine();
                reslist.get(res_counter).branch = Integer.parseInt(scan.nextLine());
                reslist.get(res_counter).phone_number = scan.nextLine();
                reslist.get(res_counter).type = scan.nextLine().toLowerCase();
                reslist.get(res_counter).rate = Double.parseDouble(scan.nextLine());
                reslist.get(res_counter).origin = scan.nextLine();
                reslist.get(res_counter).own.setUser_name(scan.nextLine());
                reslist.get(res_counter).own.setPassword(scan.nextLine());
                while (scan.hasNextLine()) {
                    String line = scan.nextLine();
                    if (line.isEmpty()) {
                        break;
                    } else {


                        reslist.get(res_counter).extra_name.add(line);
                        reslist.get(res_counter).extra_price.add(Double.parseDouble(scan.nextLine()));
                        continue;


                    }

                }

                while (scan.hasNextLine()) {
                    dish_counter = 0;
                    String line = scan.nextLine();
                    if (line.isEmpty()) {
                        break;
                    }
                    reslist.get(res_counter).sections.add(new Menu_Section());
                    reslist.get(res_counter).sections.get(section_counter).name = line;
                    reslist.get(res_counter).catcount++;
                    Menu_Section.cat_count++;
                    while (scan.hasNextLine()) {
                        String line1 = scan.nextLine();
                        if (line1.isEmpty()) {
                            break;
                        }
                        reslist.get(res_counter).sections.get(section_counter).dishes.add(new Dish());
                        reslist.get(res_counter).sections.get(section_counter).dishes.get(dish_counter).name = line1;
                        reslist.get(res_counter).sections.get(section_counter).dishes.get(dish_counter).price = Double.parseDouble(scan.nextLine());
                        reslist.get(res_counter).sections.get(section_counter).dishes.get(dish_counter).origin = scan.nextLine();
                        reslist.get(res_counter).sections.get(section_counter).dishes.get(dish_counter).quantity = Integer.parseInt(scan.nextLine());
                        reslist.get(res_counter).sections.get(section_counter).dishes.get(dish_counter).description = scan.nextLine();
                        reslist.get(res_counter).sections.get(section_counter).dishes.get(dish_counter).discount = Double.parseDouble(scan.nextLine());
                        reslist.get(res_counter).sections.get(section_counter).dishes.get(dish_counter).rate = Double.parseDouble(scan.nextLine());
                        reslist.get(res_counter).sections.get(section_counter).dishes.get(dish_counter).isveg = Integer.parseInt(scan.nextLine());
                        Dish.dish_count++;
                        reslist.get(res_counter).sections.get(section_counter).dishes_count++;
                        dish_counter++;
                    }
                    section_counter++;
                }
                res_counter++;

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }






        File file = new File("accounts.txt");
        Scanner scannerWriter = new Scanner(file);
        int a = customer.counter;
        for (int i = 0; i < a; i++) {
            String name = scannerWriter.nextLine();
            String Username = scannerWriter.nextLine();
            String Password = scannerWriter.nextLine();
            String email = scannerWriter.nextLine();
            String address = scannerWriter.nextLine();
            String phone_number = scannerWriter.nextLine();
            String ques=scannerWriter.nextLine();
            String answer=scannerWriter.nextLine();
            account_list.add(new customer(Username, Password, name, email, address, phone_number,ques,answer));
        }
        File filee = new File("owner.txt");
        Scanner scanneerWriter = new Scanner(filee);
        for (int i = 0; i <reslist.size(); i++) {
            String Username = scanneerWriter.nextLine();
            String Password = scanneerWriter.nextLine();
            owner z=new owner();
            z.setUser_name(Username);
            z.setPassword(Password);
            owners.add(z);
        }



    }

    public static void write_to_file(ArrayList<Resturant> resturants,ArrayList<customer> acc,ArrayList<owner> owners) throws IOException {
        FileWriter fileWriter = new FileWriter("accounts.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter, true);
        int a = customer.counter;
        for (customer account : acc) {
            printWriter.println(account.name);
            printWriter.println(account.getUser_name());
            printWriter.println(account.getPassword());
            printWriter.println(account.email);
            printWriter.println(account.address);
            printWriter.println(account.phone_num);
            printWriter.println(account.ques_number);
            printWriter.println(account.Answer);
        }
        try {
            resturants.size();
            int count = 0;
            int check = 0;

            File fis1 = new File("read_write.txt");
            PrintWriter fis2 = new PrintWriter(fis1);
            for (int i = 0; i < resturants.size(); i++) {
                if (resturants.get(i).cout_remove == -1) {
                    continue;
                }
                fis2.println(resturants.get(i).name);
                fis2.println(resturants.get(i).id);
                fis2.println(resturants.get(i).address);
                fis2.println(resturants.get(i).branch);
                fis2.println(resturants.get(i).phone_number);
                fis2.println(resturants.get(i).type);
                fis2.println(resturants.get(i).rate);
                fis2.println(resturants.get(i).origin);
                String user = resturants.get(i).own.getUser_name();
                fis2.println(user);
                String pass = resturants.get(i).own.getPassword();
                fis2.println(pass);
                for (int k = 0; k < resturants.get(i).extra_price.size(); k++) {
                    fis2.println(resturants.get(i).extra_name.get(k));
                    fis2.println(resturants.get(i).extra_price.get(k));
                }
                fis2.println("");
                for (int j = 0; j < resturants.get(i).catcount; j++) {
                    count++;
                    fis2.println(resturants.get(i).sections.get(j).name);
                    for (int m = 0; m < resturants.get(i).sections.get(j).dishes_count; m++) {
                        if (resturants.get(i).sections.get(j).dishes.get(m).cout_removedish == -1) {
                            continue;
                        }
                        fis2.println(resturants.get(i).sections.get(j).dishes.get(m).name);
                        fis2.println(resturants.get(i).sections.get(j).dishes.get(m).price);
                        fis2.println(resturants.get(i).sections.get(j).dishes.get(m).origin);
                        fis2.println(resturants.get(i).sections.get(j).dishes.get(m).quantity);
                        fis2.println(resturants.get(i).sections.get(j).dishes.get(m).description);
                        fis2.println(resturants.get(i).sections.get(j).dishes.get(m).discount);
                        fis2.println(resturants.get(i).sections.get(j).dishes.get(m).rate);
                        fis2.println(resturants.get(i).sections.get(j).dishes.get(m).isveg);


                    }
                    if (Menu_Section.cat_count == count) {
                        check = 1;
                        break;
                    }
                    fis2.println("");
                }
                if (check == 1) {
                    break;
                }

                fis2.println("");
            }
            fis2.flush();
            fis2.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        File fis3 = new File("owner.txt");
        PrintWriter fis4 = new PrintWriter(fis3);

        for (int i = 0; i < resturants.size(); i++) {
            if (resturants.get(i).cout_remove == -1) {
                continue;
            }
            String user = resturants.get(i).own.getUser_name();
            fis4.println(user);
            String pass = resturants.get(i).own.getPassword();
            fis4.println(pass);

        }

        fis4.flush();
        fis4.close();
    }
    public static int countLines() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("accounts.txt"));
        int lines = 0;
        try {
            while (reader.readLine() != null) {
                lines++;
            }
        } finally {
            reader.close();
        }
        return lines;
    }
}