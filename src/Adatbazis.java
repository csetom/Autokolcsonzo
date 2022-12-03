import java.util.ArrayList;

public class Adatbazis {
   ArrayList<Felhasznalo> felhasznalok; 
   ArrayList<Auto> autok;
   ArrayList<Utanfuto> utanfutok;
   ArrayList<Kolcsonzes> kolcsonzesek;

public void autoCreateOrModify(Auto newAuto) {

}
public void kolcsonzesCreateOrModify(Kolcsonzes newKolcsonzes) {
}
public void ugyfelCreateOrModify(Ugyfel newUgyfel) {
}
public void utanfutoCreateOrModify(Utanfuto newUtanfuto) {
}
public void kolcsonzesDelete(Kolcsonzes kolcsonzes) {
}
public void autoDelete(Auto auto) {
}
public void utanfutoDelete(Utanfuto utanfuto) {
}
public void ugyfelDelete(Ugyfel ugyfel) {
}
public Felhasznalo getFelhasznaloByEmail(String email) {
    return felhasznalok.stream().filter((Felhasznalo f)->{
        return f.getEmail().equalsIgnoreCase(email);
    }).findFirst().orElseThrow();
}
}
