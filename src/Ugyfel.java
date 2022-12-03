import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ugyfel extends Felhasznalo {

    public Ugyfel(int azonosito, String email, String jelszo) {
        super(azonosito, email, jelszo);
    }
    public void autoLista(){
        System.out.println(this.adatbazisManager.adatbazis.autok.toString());
    }
    public void autoKolcsonzes() throws IOException{
        System.out.print("Auto rendszam: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String rendszam = reader.readLine();
        System.out.print("Fizet? (Y/n):");
        String valasz=reader.readLine();
        if (valasz.equals("n")){
            System.out.println("Kolcsonzes megszakitva");
        } else {
            System.out.println("Kolcsonzes kifizetve");
            // Kedvezmeny megkerdezese
            this.adatbazisManager.UjKolcsonzes(rendszam, azonosito);
        }
    }
    public void autoLeadas() throws IOException{
        System.out.print("Auto leadas: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String rendszam = reader.readLine();
        this.adatbazisManager.AutoLeadas(rendszam,azonosito);
    };
    @Override
    void Menu() {
        String[] options = {
            "1 - AutoLista",
            "2 - Kolcsonzes",
            "3 - Auto leadas",
            "4 - Sajat adat modositas",
            "0 - Vissza",
        };
        Scanner scanner = new Scanner(System.in);
        int option = 1;
        while (option!=0) {
            App.printMenu(options);
            try {
                option = scanner.nextInt();
                switch (option){
                    case 1 : autoLista();break;
                    case 2: autoKolcsonzes();break;
                    case 3: autoLeadas();break;
                    case 0: break;
                }
            }
            catch (Exception ex){
                System.out.println("Please enter an integer value between 0 and " + (options.length-1));
                scanner.next();
            }
        }
    }
    
}
