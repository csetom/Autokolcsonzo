public abstract class Felhasznalo {
    protected int azonosito;
    protected String email;
    protected String jelszo;
    protected AdatbazisManager adatbazisManager;


    public void setAdatbazisManager(AdatbazisManager adatbazisManager) {
        this.adatbazisManager = adatbazisManager;
    }
    public Felhasznalo(int azonosito, String email, String jelszo) {
        this.azonosito = azonosito;
        this.email = email;
        this.jelszo = jelszo;
    }
    public void adatmodositas(String adatkulcs, String ujErtek) {
        
    }
    public int getAzonosito() {
        return azonosito;
    }
    public void setAzonosito(int azonosito) {
        this.azonosito = azonosito;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
//    public String getJelszo() {
//        return jelszo;
//    }
    public boolean joJelszo(String jelszo) {
        return this.jelszo.equals(jelszo);
    }
    public void setJelszo(String jelszo) {
        this.jelszo = jelszo;
    }
    abstract void Menu();

    @Override
    public String toString() {
        return azonosito+";"+email+";"+jelszo+";";
    }
};
  