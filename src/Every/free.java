package Every;
import login.*;
import Cart.*;
import Menu.*;

public class free {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String BLACK = "\u001B[30m";
    public static final String WHITE = "\u001B[37m";


    public static void palestine() {
        // Top stripe
        System.out.println("\nDon't Forget To Pray To Our People In Palestine\n");
        System.out.println("\n                FREE PALESTINE            \n");
        System.out.println(RED + "||||" + BLACK + "|||||||||||||||||||||||||||||||||||||||||||||||||||||" + RESET);
        System.out.println(RED + "|||||||" + BLACK + "||||||||||||||||||||||||||||||||||||||||||||||||||" + RESET);
        System.out.println(RED + "||||||||||" + BLACK + "|||||||||||||||||||||||||||||||||||||||||||||||" + RESET);
        System.out.println(RED + "|||||||||||||||||" + WHITE + "||||||||||||||||||||||||||||||||||||||||" + RESET);
        System.out.println(RED + "||||||||||||||||||||||" + WHITE + "|||||||||||||||||||||||||||||||||||" + RESET);
        System.out.println(RED + "|||||||||||||||||" + WHITE + "||||||||||||||||||||||||||||||||||||||||" + RESET);
        System.out.println(RED + "||||||||||" + GREEN + "|||||||||||||||||||||||||||||||||||||||||||||||" + RESET);
        System.out.println(RED + "|||||||" + GREEN + "||||||||||||||||||||||||||||||||||||||||||||||||||" + RESET);
        System.out.println(RED + "||||" + GREEN + "|||||||||||||||||||||||||||||||||||||||||||||||||||||" + RESET);
    }
    public static void thank(){
        System.out.println();
        System.out.println();
        System.out.print("\t\t\t\t  #######  ##    ##   ######   ####    ##  ##   ##    ##    ##     ##      ##    ##\n");  ;
        System.out.print("\t\t\t\t    ##     ##    ##  ##    ##  ## ##   ##  ##  ##      ##  ##    ##  ##    ##    ##\n");;
        System.out.print("\t\t\t\t    ##     ########  ########  ##  ##  ##  ## ##         ##     ##    ##   ##    ##\n");;
        System.out.print("\t\t\t\t    ##     ##    ##  ##    ##  ##   ## ##  ##  ##        ##      ##  ##     ##  ##\n");
        System.out.print("\t\t\t\t    ##     ##    ##  ##    ##  ##    ####  ##   ##       ##        ##         ##\n\n");

    }

        public static void heart() {
            // Print the top part of the heart
            for (double y = 1.5; y > -1.5; y -= 0.1) {
                for (double x = -1.5; x < 1.5; x += 0.05) {
                    double a = x * x + y * y - 1;
                    System.out.print(a * a * a - x * x * y * y * y <= 0.0 ? '*' : ' ');
                }
                System.out.println();
            }
        }
    }
