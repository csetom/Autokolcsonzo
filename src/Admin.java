import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Admin extends Felhasznalo {
    public Admin(int azonosito, String email, String jelszo) {
        super(azonosito, email, jelszo);
    }
    public void kolcsonezTorleseById() throws NumberFormatException, IOException {
        System.out.print("Kolcsonzes id: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int kolcsonzesId=Integer.parseInt(reader.readLine());
        adatbazisManager.adatbazis.kolcsonzesek.removeIf((Kolcsonzes k)-> {
            return k.getKolcsonzesId()==kolcsonzesId;
        });
        adatbazisManager.adatbazis.save();
    };
    public void autoTorlese() throws IOException {
        System.out.print("Auto rendszama: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String rendszam=reader.readLine();
        adatbazisManager.adatbazis.autok.removeIf((Auto a)-> {
            return a.getRendszam().equals(rendszam);
        });
        adatbazisManager.adatbazis.save();
    };
    public void ugyfelTorlese() throws NumberFormatException, IOException {
        System.out.print("Ugyfel azonositoja: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int ugyfelAzonosito=Integer.parseInt(reader.readLine());
        adatbazisManager.adatbazis.felhasznalok.removeIf((Felhasznalo f)-> {
            return f.getAzonosito()==ugyfelAzonosito;
        });
        adatbazisManager.adatbazis.save();
    };
    public void kolcsonezKezelese(Kolcsonzes newKolcsonzes) {

    };
    public void autoAdatainakKezelese(Auto newAuto) {

    };
    public void utanfutoAdatainakKezelese(Utanfuto newUtanfuto) {

    };
    public void ugyfelAdatainakKezelese(Ugyfel newUgyfel) {

    };
    public void utanfutoTorlese(Utanfuto utanfuto) {
    };

    @Override
    void Menu() {
        String[] options = {
            "1 - Kolcsonzes torlese",
            "2 - Ugyfel torlese",
            "3 - Auto torlese",
            "0 - Vissza",
        };
        Scanner scanner = new Scanner(System.in);
        int option = 1;
        while (option!=0) {
            App.printMenu(options);
            try {
                option = scanner.nextInt();
                switch (option){
                    case 1 :kolcsonezTorleseById(); break;
                    case 2: ugyfelTorlese(); break;
                    case 3: autoTorlese(); break;
                    case 0: break;
                }
            }
            catch (Exception ex){
                System.out.println("Please enter an integer value between 0 and " + (options.length-1));
                scanner.next();
            }
        }
    };
    
    @Override
    public String toString() {
        return "admin;"+super.toString();
    }
}
