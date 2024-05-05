package Every;
import login.*;
import Cart.*;
import Menu.*;
import java.io.IOException;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Menu_Section> catList = new ArrayList<>();
        ArrayList<Dish> dishList = new ArrayList<>();
        ArrayList<Resturant> reslist = new ArrayList<>();
        ArrayList<owner> owners = new ArrayList<>();
        ArrayList<customer> accounts = new ArrayList<>();
        file.read_from_file( reslist,accounts, owners);
        free.palestine();
        menulist.show_main_menu(owners, accounts, reslist, catList, dishList);
        file.write_to_file(reslist,accounts, owners);
    }
}