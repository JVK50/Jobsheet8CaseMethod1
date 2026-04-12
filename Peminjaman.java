package smt2.CaseMethod1;

public class Peminjaman {
    private String nim;
    private Buku buku;
    private int lamaPinjam;
    private int terbambat;
    private int denda;

    // Constructor dengan parameter
    public Peminjaman(String nim, Buku buku, int lamaPinjam, int terbambat) {
        this.nim = nim;
        this.buku = buku;
        this.lamaPinjam = lamaPinjam;
        this.terbambat = terbambat;
        this.denda = hitungDenda();
    }

    // Getter untuk nim
    public String getNim() {
        return nim;
    }

    // Setter untuk nim
    public void setNim(String nim) {
        this.nim = nim;
    }

    // Getter untuk buku
    public Buku getBuku() {
        return buku;
    }

    // Setter untuk buku
    public void setBuku(Buku buku) {
        this.buku = buku;
    }

    // Getter untuk lamaPinjam
    public int getLamaPinjam() {
        return lamaPinjam;
    }

    // Setter untuk lamaPinjam
    public void setLamaPinjam(int lamaPinjam) {
        this.lamaPinjam = lamaPinjam;
    }

    // Getter untuk terbambat
    public int getTerbambat() {
        return terbambat;
    }

    // Setter untuk terbambat
    public void setTerbambat(int terbambat) {
        this.terbambat = terbambat;
        this.denda = hitungDenda();
    }

    // Getter untuk denda
    public int getDenda() {
        return denda;
    }

    // Setter untuk denda
    public void setDenda(int denda) {
        this.denda = denda;
    }

    // Metode untuk menghitung denda
    // Rp 2.000 per hari terbambat
    public int hitungDenda() {
        return terbambat * 2000;
    }

    // toString untuk menampilkan data peminjaman
    @Override
    public String toString() {
        return "Peminjaman{" +
                "nim='" + nim + '\'' +
                ", buku=" + buku +
                ", lamaPinjam=" + lamaPinjam +
                ", terbambat=" + terbambat +
                ", denda=Rp " + denda +
                '}';
    }
}
