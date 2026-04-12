package smt2.CaseMethod1;

public class Mahasiswa {
    private String nim;
    private String nama;
    private String prodi;

    // Constructor dengan parameter
    public Mahasiswa(String nim, String nama, String prodi) {
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
    }

    // Getter untuk nim
    public String getNim() {
        return nim;
    }

    // Setter untuk nim
    public void setNim(String nim) {
        this.nim = nim;
    }

    // Getter untuk nama
    public String getNama() {
        return nama;
    }

    // Setter untuk nama
    public void setNama(String nama) {
        this.nama = nama;
    }

    // Getter untuk prodi
    public String getProdi() {
        return prodi;
    }

    // Setter untuk prodi
    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    // toString untuk menampilkan data mahasiswa
    @Override
    public String toString() {
        return "Mahasiswa{" +
                "nim='" + nim + '\'' +
                ", nama='" + nama + '\'' +
                ", prodi='" + prodi + '\'' +
                '}';
    }
}
