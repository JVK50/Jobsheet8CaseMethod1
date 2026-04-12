package smt2.CaseMethod1;

public class Buku {
    private String kodeBuku;
    private String judul;
    private int tahunTerbit;

    // Constructor dengan parameter
    public Buku(String kodeBuku, String judul, int tahunTerbit) {
        this.kodeBuku = kodeBuku;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
    }

    // Getter untuk kodeBuku
    public String getKodeBuku() {
        return kodeBuku;
    }

    // Setter untuk kodeBuku
    public void setKodeBuku(String kodeBuku) {
        this.kodeBuku = kodeBuku;
    }

    // Getter untuk judul
    public String getJudul() {
        return judul;
    }

    // Setter untuk judul
    public void setJudul(String judul) {
        this.judul = judul;
    }

    // Getter untuk tahunTerbit
    public int getTahunTerbit() {
        return tahunTerbit;
    }

    // Setter untuk tahunTerbit
    public void setTahunTerbit(int tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    // toString untuk menampilkan data buku
    @Override
    public String toString() {
        return "Buku{" +
                "kodeBuku='" + kodeBuku + '\'' +
                ", judul='" + judul + '\'' +
                ", tahunTerbit=" + tahunTerbit +
                '}';
    }
}
