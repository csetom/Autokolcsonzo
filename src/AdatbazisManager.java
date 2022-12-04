import java.text.SimpleDateFormat;
import java.util.Date;

public class AdatbazisManager {
    Adatbazis adatbazis=new Adatbazis();
    AdatbazisManager(){
    }
    public Felhasznalo getFelhasznaloByEmail(String email){
         return adatbazis.felhasznalok.stream().filter((Felhasznalo f)->
             f.getEmail().equalsIgnoreCase(email)
        ).findFirst().orElse(null);
    };
    public void UjKolcsonzes(String rendszam, int azonosito) {
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        int id=adatbazis.kolcsonzesek.get(adatbazis.kolcsonzesek.size()-1).getKolcsonzesId();
        id++;
        Kolcsonzes k = new Kolcsonzes(id,azonosito,rendszam,date,1234,"Kolcsonozve");
        adatbazis.kolcsonzesek.add(k);
        adatbazis.save();
    }
    public void AutoLeadas(String rendszam, int azonosito) {
        adatbazis.kolcsonzesek.removeIf(
            (Kolcsonzes k )->{
            return (k.getRendszam().equalsIgnoreCase(rendszam) && k.getUgyfelAzonosito()==azonosito) ;
        });
        adatbazis.save();
    }

    public void AutoLeadasUzletvezeto(String rendszam) {
        adatbazis.kolcsonzesek.removeIf(
            (Kolcsonzes k )->{
            return (k.getRendszam().equalsIgnoreCase(rendszam)) ;
        });
        adatbazis.save();
    }
    public void addAuto(Auto a) {
        adatbazis.autok.add(a);
        adatbazis.save();
    }
    public void UjUgyfel(String email, String jelszo) {
        int azonosito=adatbazis.felhasznalok.get(adatbazis.felhasznalok.size()-1).getAzonosito();
        azonosito++;
        adatbazis.felhasznalok.add(new Ugyfel(azonosito,email,jelszo));
        adatbazis.save(); 
    }
}
