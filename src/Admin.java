import java.util.Scanner;

public class Admin extends Felhasznalo {
    public Admin(int azonosito, String email, String jelszo) {
        super(azonosito, email, jelszo);
    }
    public Admin(int azonosito, String email, String jelszo, Adatbazis adatbazis) {
        super(azonosito, email, jelszo);
    }
    public void kolcsonezTorleseById(Integer kolcsonzesId) {
    };
    public void autoTorlese(Auto auto) {
    };
    public void utanfutoTorlese(Utanfuto utanfuto) {
    };
    public void ugyfelTorlese(Ugyfel ugyfel) {
    };
    public void kolcsonezKezelese(Kolcsonzes newKolcsonzes) {
    };
    public void autoAdatainakKezelese(Auto newAuto) {
    };
    public void utanfutoAdatainakKezelese(Utanfuto newUtanfuto) {
    };
    public void ugyfelAdatainakKezelese(Ugyfel newUgyfel) {
    }

    @Override
    void Menu() {
        String[] options = {
            "------------------",
            "1 - ",
            "2 - ",
            "0 - Vissza",
        };
        Scanner scanner = new Scanner(System.in);
        int option = 1;
        while (option!=0) {
            App.printMenu(options);
            try {
                option = scanner.nextInt();
                switch (option){
                    case 1 : break;
                    case 2: break;
                    case 0: break;
                }
            }
            catch (Exception ex){
                System.out.println("Please enter an integer value between 1 and " + options.length);
                scanner.next();
            }
        }
    };
}
