public class AdatbazisManager {
    Adatbazis adatbazis=new Adatbazis();
    AdatbazisManager(){
    }
    public Felhasznalo getFelhasznaloByEmail(String email){
System.out.println("SIZE: "+adatbazis.felhasznalok.size());
         return adatbazis.felhasznalok.stream().filter((Felhasznalo f)->
             f.getEmail().equalsIgnoreCase(email)
        ).findFirst().orElseThrow();
    };
}
