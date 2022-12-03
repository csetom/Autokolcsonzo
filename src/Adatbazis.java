import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Adatbazis {
   public ArrayList<Felhasznalo> felhasznalok = new ArrayList<Felhasznalo>(); 
   public ArrayList<Auto> autok = new ArrayList<Auto>();
   public ArrayList<Utanfuto> utanfutok = new ArrayList<Utanfuto>();
   public ArrayList<Kolcsonzes> kolcsonzesek = new ArrayList<Kolcsonzes>();
   public Adatbazis(){
        ReadFelhasznalok();
System.out.println("Adatbazis!");
   }
   private void ReadFelhasznalok() {

                BufferedReader bufferedReader;
                try {
                    bufferedReader = new BufferedReader(new FileReader("felhasznalok.txt"));
                    String[] tmp;
                    while ((tmp = bufferedReader.readLine().split(";")) != null) {
                        switch (tmp.length) {
                            case 10:
                                //ügyfél
//                                felhasznalok.add(new Ugyfel(Integer.parseInt(tmp[0]), tmp[1], tmp[2], Integer.parseInt(tmp[3]), tmp[4], tmp[5], tmp[6], tmp[7], Integer.parseInt(tmp[8]), Integer.parseInt(tmp[9])));
                                break;
                            case 5:
                                //admin
                                System.out.println(tmp.toString());
                                int azonosito=Integer.parseInt(tmp[0]);
                                String email=tmp[1];
                                String  jelszo=tmp[2];
                                felhasznalok.add(
                                    new Admin(azonosito, email, jelszo, this)
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
};
