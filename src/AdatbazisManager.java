public class AdatbazisManager {
    Adatbazis adatbazis=new Adatbazis();
    AdatbazisManager(){
        //beolvassa az adatbazist.
    }
    public Felhasznalo getFelhasznaloByEmail(String email){
        return adatbazis.getFelhasznaloByEmail(email);
    };
}
