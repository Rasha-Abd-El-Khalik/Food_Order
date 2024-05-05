package Cart;
import login.*;
import Menu.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Usercart {
    public static MainCart cart=new MainCart() ;

    public Usercart() {
        this.cart = new MainCart();
    }

    public static void  addToCartInteractive(int[] arr, ArrayList<Resturant> resturants, ArrayList<Menu_Section> sections, ArrayList<Dish> dishes, ArrayList<customer> acc, ArrayList<owner> owners, int index1, String input, String sec, customer c) {
        Scanner scanner = new Scanner(System.in);
       String  ans = "n";

        boolean check = true;
        while (true){
            try {
                Dish selectedMeal = resturants.get(arr[0]).sections.get(Integer.parseInt(sec)-1).dishes.get(Integer.parseInt(input)-1);
                if (resturants.get(arr[0]).sections.get(arr[1]).dishes.get(arr[2]).quantity == 0) {
                    System.out.println("The Dish Not Avaliable Now Choose Another Dish ");
                    Dish.cart_dish(index1,resturants, sections, dishes, acc, owners, arr,sec, c);
                } else {
                    System.out.println("Enter Quantity:");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    CartItem cartItem = new CartItem(selectedMeal, quantity);
                    boolean invalidin = true;

                    while (true){
                        String  ans2 ;
                        try {
                            System.out.println("Do you want add an extra? (Y/N)");
                            ans2 = scanner.next();
                            scanner.nextLine();
                            if (ans2 .equals("y") || ans2 .equals("Y") || ans2 .equals("n") || ans2 .equals("N") ) {
                                if (ans2 .equals("y") || ans2 .equals("Y")) {

                                    System.out.println("Available Extars :");
                                    for (int i = 0; i < resturants.get(arr[0]).extra_name.size(); i++) {
                                        System.out.println((i + 1) + " - " + resturants.get(arr[0]).extra_name.get(i) + " Price=" + resturants.get(arr[0]).extra_price.get(i));
                                    }
                                    System.out.println("Enter the number of extra to add :");
                                    int selectednum = Integer.parseInt(scanner.nextLine());
                                    if (selectednum >= 1 && selectednum <= resturants.get(arr[0]).extra_name.size()) {
                                        cartItem.addextratocart(resturants.get(arr[0]).extra_name.get(selectednum - 1), resturants.get(arr[0]).extra_price.get(selectednum - 1));

                                    } else {
                                        System.out.println("Invalid Extra number.");
                                    }
                                }
                                break;
                            }

                            else {
                                System.out.println("Invalid input. Please enter 'Y' or 'N'.");
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please enter 'Y' or 'N'.");scanner.nextLine(); // Consume the invalid input
                        }
                    }
                    System.out.println("Added to cart: ");
                    if (cartItem.extra == null) {
                        double total=((selectedMeal.price-(selectedMeal.price*selectedMeal.discount/100))*cartItem.getQuantity());
                        acc.get(index1).itmes1.add(  selectedMeal.name);
                        acc.get(index1).itmesprice.add(total);
                        acc.get(index1).itmesquan.add(cartItem.getQuantity());;


                    } else {
                        double total=((selectedMeal.price-(selectedMeal.price*selectedMeal.discount/100))*cartItem.getQuantity())+cartItem.extra_price;
                        acc.get(index1).itmes1.add( selectedMeal.name + " with " + cartItem.extra);
                        acc.get(index1).itmesprice.add(total);
                        acc.get(index1).itmesquan.add(cartItem.getQuantity());

                    }
                    for (int i=0;i<  acc.get(index1).itmes1.size();i++)
                    {

                        System.out.println(  acc.get(index1).itmes1.get(i));
                    }
                    break;


                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        do {
            try {
                System.out.println("1-Add Another Meal? (Y/N)");
                System.out.println("2-Remove Another Meal");
                String opt=scanner.next();
                if(opt.equals("1")){

                    ans = scanner.next();
                    scanner.nextLine();
                    if (ans .equals("y") || ans.equals("Y") || ans .equals("n") || ans .equals("N") ){

                        check = false;
                        if (ans .equals("y") || ans.equals("Y")) {
                            Dish.cat_cart(index1,resturants,sections,dishes,acc,owners,arr, c);
                            return;
                        }
                        else if(  ans .equals("n") || ans .equals("N")){

                            FoodDeliverySystem.Ord(arr,resturants,acc,index1, owners,sections,dishes, c);
                            return;
                        }
                        else{
                            System.out.println("Invalid input. Please enter 'Y' or 'N'.");
                            continue;

                        }

                    } else {
                        System.out.println("Invalid input. Please enter 'Y' or 'N'.");
                    }
                } else if (opt.equals("2")) {
                    Resturant.remove_cart(resturants,sections,dishes,acc,owners,arr,index1,sec, c);
                    return;
                }
                else {
                    System.out.println("Invalid Choice");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter 'Y' or 'N'.");
                scanner.nextLine(); // Consume the invalid input
            }
        } while (check);

    }

}