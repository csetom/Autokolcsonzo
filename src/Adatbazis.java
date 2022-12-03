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
System.out.println(felhasznalok.toString());
   }
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
                        int azonosito=Integer.parseInt(tmp[0]);
                        String email=tmp[1];
                        String  jelszo=tmp[2];
                        switch (tmp.length) { //TODO: At kell irni teljesen ezt is: 
                            case 10:
                                felhasznalok.add(
                                    new Ugyfel(azonosito, email, jelszo)
                                );
                                break;
                            case 5:
                                //admin
                                felhasznalok.add(
                                    new Admin(azonosito, email, jelszo)
                                );
                                break;
                            case 4:
                                //üzletvezető
//                               felhasznalok.add(new Uzletvezeto(Integer.parseInt(tmp[0]), tmp[1], tmp[2], Integer.parseInt(tmp[3])));
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
    try {//Ennek mintajara auto utanfuto es felhasznalo
        FileWriter myWriter = new FileWriter("kolcsonzesek.txt");
        for (Kolcsonzes k : kolcsonzesek) {
           myWriter.write(k.toString()); 
        };
        myWriter.close();
      } catch (IOException e) {
        e.printStackTrace();
    }
   }
};
