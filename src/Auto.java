public class Auto {
   private String rendszam;
   private String tipus;
   private String modell;
   private String uzemanyag;
   private int ferohely;
   private String szin;
public Auto(String rendszam, String tipus, String modell, String uzemanyag, int ferohely, String szin) {
    this.rendszam = rendszam;
    this.tipus = tipus;
    this.modell = modell;
    this.uzemanyag = uzemanyag;
    this.ferohely = ferohely;
    this.szin = szin;
}
public String getRendszam() {
    return rendszam;
}
public void setRendszam(String rendszam) {
    this.rendszam = rendszam;
}
public String getTipus() {
    return tipus;
}
public void setTipus(String tipus) {
    this.tipus = tipus;
}
public String getModell() {
    return modell;
}
public void setModell(String modell) {
    this.modell = modell;
}
public String getUzemanyag() {
    return uzemanyag;
}
public void setUzemanyag(String uzemanyag) {
    this.uzemanyag = uzemanyag;
}
public int getFerohely() {
    return ferohely;
}
public void setFerohely(int ferohely) {
    this.ferohely = ferohely;
}
public String getSzin() {
    return szin;
}
public void setSzin(String szin) {
    this.szin = szin;
}

@Override
public String toString() {
    return rendszam + ";" + tipus + ";" + modell + ";" + uzemanyag + ";" + ferohely + ";" + szin;
}
}
