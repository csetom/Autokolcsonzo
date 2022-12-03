import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Adatbazis {
   public ArrayList<Felhasznalo> felhasznalok = new ArrayList<Felhasznalo>(); 
   public ArrayList<Auto> autok = new ArrayList<Auto>();
   public ArrayList<Utanfuto> utanfutok = new ArrayList<Utanfuto>();
   public ArrayList<Kolcsonzes> kolcsonzesek = new ArrayList<Kolcsonzes>();
   public Adatbazis(){
        ReadFelhasznalok();
        ReadKolcsonzesek();
        ReadAutok();
System.out.println(felhasznalok.toString());
   }
   private void ReadAutok() {
                BufferedReader bufferedReader;
                try {
                    bufferedReader = new BufferedReader(new FileReader("autok.txt"));
                    String[] tmp;
                    while ((tmp = bufferedReader.readLine().split(";")) != null) {
                        String rendszam=tmp[0];
                        String tipus=tmp[1];
                        String modell=tmp[2];
                        String uzemanyag=tmp[3];
                        int ferohely=Integer.parseInt(tmp[4]);
                        String szin= tmp[5];
                        autok.add(new Auto(rendszam,tipus,modell,uzemanyag,ferohely,szin));
                    }

                } catch (FileNotFoundException ex) {

                } catch (IOException | NullPointerException ex) {

                }
   };
   private void ReadKolcsonzesek() {
                BufferedReader bufferedReader;
                try {
                    bufferedReader = new BufferedReader(new FileReader("kolcsonzesek.txt"));
                    String[] tmp;
                    while ((tmp = bufferedReader.readLine().split(";")) != null) {
                      int kolcsonzesId=Integer.parseInt(tmp[0]);
                      int UgyfelAzonosito=Integer.parseInt(tmp[1]);
                      String rendszam=tmp[2];
                      String datum=tmp[3];
                      int ar=Integer.parseInt(tmp[4]);
                      kolcsonzesek.add(new Kolcsonzes(kolcsonzesId, UgyfelAzonosito, rendszam, datum,ar,null));
                    }

                } catch (FileNotFoundException ex) {

                } catch (IOException | NullPointerException ex) {

                }
   };
   private void ReadFelhasznalok() {

                BufferedReader bufferedReader;
                try {
                    bufferedReader = new BufferedReader(new FileReader("felhasznalok.txt"));
                    String[] tmp;
                    while ((tmp = bufferedReader.readLine().split(";")) != null) {
                        String tipus=tmp[0];
                        int azonosito=Integer.parseInt(tmp[1]);
                        String email=tmp[2];
                        String  jelszo=tmp[3];
                        switch (tipus) { 
                            case "ugyfel":
                                felhasznalok.add(
                                    new Ugyfel(azonosito, email, jelszo)
                                );
                                break;
                            case "admin":
                                //admin
                                felhasznalok.add(
                                    new Admin(azonosito, email, jelszo)
                                );
                                break;
                            case "uzletvezeto":
                                //üzletvezető
                                felhasznalok.add(
                                    new Uzletvezeto(azonosito, email, jelszo)
                                );
                                break;
                            default:
                                break;
                        }
                    }

                } catch (FileNotFoundException ex) {

                } catch (IOException | NullPointerException ex) {

                }
   };
   public void save() {
    //Save kolcsonzesek
    try {//Ennek mintajara auto utanfuto es felhasznalo
        FileWriter myWriter = new FileWriter("kolcsonzesek.txt");
        for (Kolcsonzes k : kolcsonzesek) {
           myWriter.write(k.toString()+ "\n"); 
        };
        myWriter.close();
      } catch (IOException e) {
        e.printStackTrace();
    }
    //Save felhasznalo
    try {//Ennek mintajara auto utanfuto es felhasznalo
        FileWriter myWriter = new FileWriter("felhasznalok.txt");
        for (Felhasznalo f : felhasznalok) {
           myWriter.write(f.toString()+"\n"); 
        };
        myWriter.close();
      } catch (IOException e) {
        e.printStackTrace();
    }
    //Save auto
    try {//Ennek mintajara auto utanfuto es felhasznalo
        FileWriter myWriter = new FileWriter("autok.txt");
        for (Auto a : autok) {
           myWriter.write(a.toString()+"\n"); 
        };
        myWriter.close();
      } catch (IOException e) {
        e.printStackTrace();
    }
   }
};
