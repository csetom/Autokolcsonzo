import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Uzletvezeto extends Felhasznalo{

    public Uzletvezeto(int azonosito, String email, String jelszo) {
        super(azonosito, email, jelszo);
    }
    public void autoLista(){
        System.out.println(this.adatbazisManager.adatbazis.autok.toString());
    }
    public void autoLeadas() throws IOException{
        System.out.print("Auto leadas: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String rendszam = reader.readLine();
        this.adatbazisManager.AutoLeadasUzletvezeto(rendszam);
    };
    public void ujAuto() throws IOException {
        System.out.println(
            "Rendszam; tipus; modell; uzemanyag; ferohely; szin;"
        );
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String rendszam=reader.readLine();
        String tipus=reader.readLine();
        String modell=reader.readLine();
        String uzemanyag=reader.readLine();
        int ferohely=Integer.parseInt(reader.readLine());
        String szin= reader.readLine();
        Auto a =new Auto(rendszam,tipus,modell,uzemanyag,ferohely,szin);
        adatbazisManager.addAuto(a);
    }
    public void modAuto() throws IOException {
        System.out.print("rendszam: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String rendszam=reader.readLine();
        Auto auto=adatbazisManager.adatbazis.autok.stream().filter((Auto a)->a.getRendszam().equals(rendszam)).findFirst().orElse(null);
        if (auto !=null) {
            adatbazisManager.adatbazis.autok.remove(auto);
            System.out.println(auto.toString());
            ujAuto();
        } else {
            System.out.println("Nincs ilyen auto");
        }
    }

    @Override
    void Menu() {
        String[] options = {
            "1 - AutoLista", //+
            "2 - Auto leadas",//+
            "3 - Uj auto felvitele",//+
            "4 - Meglevo auto modositasa",//+
            "5 - Uj utanfuto modositasa",
            "6 - Uj utanfuto bevitele",
            "7 - Sajat adat modositas",
            "0 - LogOut",
        };

        Scanner scanner = new Scanner(System.in);
        int option = 1;
        while (option!=0) {
            App.printMenu(options);
            try {
                option = scanner.nextInt();
                switch (option){
                    case 1 : autoLista();break;
                    case 2: autoLeadas();break;
                    case 3: ujAuto();break;
                    case 4: modAuto();break;
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
