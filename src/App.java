import java.util.Hashtable;
import java.util.Scanner;
import java.util.function.Function;

import static java.lang.System.exit;
;

public class App {
    static AdatbazisManager adatbazisManager = new AdatbazisManager();
    public static void main(String[] args) throws Exception {
        MainMenu();
    }
    public static void printMenu(String[] options){
        for (String option : options){
            System.out.println(option);
        }
        System.out.print("Choose your option : ");
    }
    public static void MainMenu() {
        String[] options = {
            "------------------",
            "1 - Bejelentkezes",
            "2 - Regisztracio",
            "3 - Kilepes",
        };
        Scanner scanner = new Scanner(System.in);
        int option = 1;
        while (option!=3) {
            printMenu(options);
            try {
                option = scanner.nextInt();
                switch (option){
                    case 1: bejelentkezes(); break;
                    case 2: regisztracio(); break;
                    case 3: exit(0);
                }
            }
            catch (Exception ex){
                System.out.println("Please enter an integer value between 1 and " + options.length);
                scanner.next();
            }
        }
    }
// Options
    private static void bejelentkezes() {
        System.out.print("email: ");
        Scanner scanner = new Scanner(System.in);
        Felhasznalo felhasznalo;
        try {
           String email=scanner.nextLine(); 
System.out.println((email));
            felhasznalo=adatbazisManager.getFelhasznaloByEmail(email);
        } catch(Exception ex) {
            System.out.println("Nincs ilyen felhasznalo");
            return;
        }
        System.out.print("jelszo: ");
        if(felhasznalo.joJelszo(scanner.nextLine())){
        } else {
            System.out.println("Rossz Jelszo");
        }

    }
    private static void regisztracio() {
        System.out.println("Thanks for choosing option 2");
    }
}
