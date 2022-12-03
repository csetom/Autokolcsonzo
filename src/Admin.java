public class Admin extends Felhasznalo {
    private Adatbazis adatbazis = new Adatbazis();
    public Admin(int azonosito, String email, String jelszo, Adatbazis adatbazis) {
        super(azonosito, email, jelszo);
        this.adatbazis=adatbazis;
    }
    public void kolcsonezTorlese(Kolcsonzes kolcsonzes) {
        adatbazis.kolcsonzesDelete(kolcsonzes);
    };
    public void autoTorlese(Auto auto) {
        adatbazis.autoDelete(auto);
    };
    public void utanfutoTorlese(Utanfuto utanfuto) {
        adatbazis.utanfutoDelete(utanfuto);
    };
    public void ugyfelTorlese(Ugyfel ugyfel) {
        adatbazis.ugyfelDelete(ugyfel);
    };
    public void kolcsonezKezelese(Kolcsonzes newKolcsonzes) {
        adatbazis.kolcsonzesCreateOrModify(newKolcsonzes);
    };
    public void autoAdatainakKezelese(Auto newAuto) {
        adatbazis.autoCreateOrModify(newAuto);
    };
    public void utanfutoAdatainakKezelese(Utanfuto newUtanfuto) {
        adatbazis.utanfutoCreateOrModify(newUtanfuto);
    };
    public void ugyfelAdatainakKezelese(Ugyfel newUgyfel) {
        adatbazis.ugyfelCreateOrModify(newUgyfel);
    }
    @Override
    void Menu() {
        // TODO Auto-generated method stub
        
    };
}
