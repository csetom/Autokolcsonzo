public class Kolcsonzes {
    private int kolcsonzesId;
    private int UgyfelAzonosito;
    private String rendszam;
    private String datum;
    private Integer ar;
    private String kolcsonzesAllapota; //nem tom mi ez
    public Kolcsonzes(int ugyfelAzonosito, String rendszam, Integer ar) {
        UgyfelAzonosito = ugyfelAzonosito;
        this.rendszam = rendszam;
        this.ar = ar;
    }
    public Kolcsonzes(int kolcsonzesId, int ugyfelAzonosito, String rendszam, String datum, Integer ar,
            String kolcsonzesAllapota) {
        this.kolcsonzesId = kolcsonzesId;
        UgyfelAzonosito = ugyfelAzonosito;
        this.rendszam = rendszam;
        this.datum = datum;
        this.ar = ar;
        this.kolcsonzesAllapota = kolcsonzesAllapota;
    }
    public int getKolcsonzesId() {
        return kolcsonzesId;
    }
    public void setKolcsonzesId(int kolcsonzesId) {
        this.kolcsonzesId = kolcsonzesId;
    }
    public int getUgyfelAzonosito() {
        return UgyfelAzonosito;
    }
    public void setUgyfelAzonosito(int ugyfelAzonosito) {
        UgyfelAzonosito = ugyfelAzonosito;
    }
    public String getRendszam() {
        return rendszam;
    }
    public void setRendszam(String rendszam) {
        this.rendszam = rendszam;
    }
    public String getDatum() {
        return datum;
    }
    public void setDatum(String datum) {
        this.datum = datum;
    }
    public Integer getAr() {
        return ar;
    }
    public void setAr(Integer ar) {
        this.ar = ar;
    }
    public String getKolcsonzesAllapota() {
        return kolcsonzesAllapota;
    }
    public void setKolcsonzesAllapota(String kolcsonzesAllapota) {
        this.kolcsonzesAllapota = kolcsonzesAllapota;
    }
    @Override
    public String toString() {
        return kolcsonzesId + ";" + UgyfelAzonosito + ";"
                + rendszam + ";" + datum + ";" + ar + ";" + kolcsonzesAllapota + "\n";
    }
}
