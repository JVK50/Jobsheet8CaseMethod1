package smt2.CaseMethod1;
import java.util.Scanner;

public class SistemPeminjamanBuku {
    // Array untuk menyimpan data mahasiswa, buku, dan peminjaman
    private static Mahasiswa[] mahasiswa = new Mahasiswa[10];
    private static Buku[] buku = new Buku[10];
    private static Peminjaman[] peminjaman = new Peminjaman[10];
    
    // Counter untuk jumlah data
    private static int jumlahMahasiswa = 0;
    private static int jumlahBuku = 0;
    private static int jumlahPeminjaman = 0;
    
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initDataMahasiswa();
        initDataBuku();
        initDataPeminjaman();
        
        int pilihan;
        do {
            tampilkanMenu();
            System.out.print("Masukkan pilihan (1-5): ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline
            
            switch (pilihan) {
                case 1:
                    tampilkanDataMahasiswa();
                    break;
                case 2:
                    tampilkanDataBuku();
                    break;
                case 3:
                    inputDataPeminjaman();
                    break;
                case 4:
                    cariMahasiswaByNIM();
                    break;
                case 5:
                    sortingPeminjamanByNIM();
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 0);
        
        System.out.println("Terima kasih telah menggunakan Sistem Peminjaman Buku!");
        scanner.close();
    }

    // Metode untuk menampilkan menu utama
    static void tampilkanMenu() {
        System.out.println("\n========== MENU SISTEM PEMINJAMAN BUKU ==========");
        System.out.println("1. Tampilkan Data Mahasiswa");
        System.out.println("2. Tampilkan Data Buku");
        System.out.println("3. Input Data Peminjaman");
        System.out.println("4. Cari Mahasiswa by NIM");
        System.out.println("5. Sorting Data Peminjaman by NIM");
        System.out.println("0. Keluar");
        System.out.println("================================================");
    }

    // Metode untuk inisialisasi data mahasiswa
    static void initDataMahasiswa() {
        mahasiswa[0] = new Mahasiswa("22001", "Andi", "Teknik Informatika");
        mahasiswa[1] = new Mahasiswa("22002", "Budi", "Teknik Informatika");
        mahasiswa[2] = new Mahasiswa("22003", "Citra", "Sistem Informasi Bisnis");
        jumlahMahasiswa = 3;
    }

    // Metode untuk inisialisasi data buku
    static void initDataBuku() {
        buku[0] = new Buku("B001", "Algoritma", 2020);
        buku[1] = new Buku("B002", "Basis Data", 2019);
        buku[2] = new Buku("B003", "Pemrograman", 2021);
        buku[3] = new Buku("B004", "Fisika", 2024);
        jumlahBuku = 4;
    }

    // Metode untuk inisialisasi data peminjaman
    static void initDataPeminjaman() {
        peminjaman[0] = new Peminjaman("22001", buku[0], 7, 2);
        peminjaman[1] = new Peminjaman("22002", buku[1], 7, 5);
        peminjaman[2] = new Peminjaman("22003", buku[2], 7, 0);
        jumlahPeminjaman = 3;
    }

    // Metode untuk menampilkan data mahasiswa
    static void tampilkanDataMahasiswa() {
        System.out.println("\n========== DATA MAHASISWA ==========");
        if (jumlahMahasiswa == 0) {
            System.out.println("Tidak ada data mahasiswa!");
            return;
        }
        
        System.out.println(String.format("%-10s | %-20s | %-30s", "NIM", "Nama", "Prodi"));
        System.out.println("-".repeat(65));
        
        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.println(String.format("%-10s | %-20s | %-30s",
                    mahasiswa[i].getNim(),
                    mahasiswa[i].getNama(),
                    mahasiswa[i].getProdi()));
        }
        System.out.println("====================================");
    }

    // Metode untuk menampilkan data buku
    static void tampilkanDataBuku() {
        System.out.println("\n========== DATA BUKU ==========");
        if (jumlahBuku == 0) {
            System.out.println("Tidak ada data buku!");
            return;
        }
        
        System.out.println(String.format("%-10s | %-25s | %-15s", "Kode Buku", "Judul", "Tahun Terbit"));
        System.out.println("-".repeat(55));
        
        for (int i = 0; i < jumlahBuku; i++) {
            System.out.println(String.format("%-10s | %-25s | %-15d",
                    buku[i].getKodeBuku(),
                    buku[i].getJudul(),
                    buku[i].getTahunTerbit()));
        }
        System.out.println("==============================");
    }

    // Metode untuk memasukkan data peminjaman baru
    static void inputDataPeminjaman() {
        System.out.println("\n========== INPUT DATA PEMINJAMAN ==========");
        
        if (jumlahPeminjaman >= peminjaman.length) {
            System.out.println("Array peminjaman sudah penuh!");
            return;
        }
        
        System.out.print("Masukkan NIM Mahasiswa: ");
        String nim = scanner.nextLine();
        
        // Validasi NIM
        int idxMahasiswa = cariMahasiswaByNIMHelper(nim);
        if (idxMahasiswa == -1) {
            System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan!");
            return;
        }
        
        System.out.print("Masukkan Kode Buku: ");
        String kodeBuku = scanner.nextLine();
        
        // Validasi Kode Buku
        int idxBuku = cariBukuByKode(kodeBuku);
        if (idxBuku == -1) {
            System.out.println("Buku dengan kode " + kodeBuku + " tidak ditemukan!");
            return;
        }
        
        System.out.print("Masukkan Lama Pinjam (hari): ");
        int lamaPinjam = scanner.nextInt();
        
        System.out.print("Masukkan Hari Terbambat: ");
        int terbambat = scanner.nextInt();
        scanner.nextLine(); // Membersihkan newline
        
        peminjaman[jumlahPeminjaman] = new Peminjaman(nim, buku[idxBuku], lamaPinjam, terbambat);
        jumlahPeminjaman++;
        
        System.out.println("Data peminjaman berhasil ditambahkan!");
        System.out.println("Denda yang harus dibayar: Rp " + peminjaman[jumlahPeminjaman - 1].getDenda());
    }

    // Metode searching dengan linear search untuk mencari mahasiswa berdasarkan NIM
    static void cariMahasiswaByNIM() {
        System.out.println("\n========== CARI MAHASISWA BY NIM ==========");
        System.out.print("Masukkan NIM yang dicari: ");
        String nim = scanner.nextLine();
        
        int idx = cariMahasiswaByNIMHelper(nim);
        
        if (idx != -1) {
            System.out.println("\nData mahasiswa ditemukan:");
            System.out.println("NIM        : " + mahasiswa[idx].getNim());
            System.out.println("Nama       : " + mahasiswa[idx].getNama());
            System.out.println("Prodi      : " + mahasiswa[idx].getProdi());
        } else {
            System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan!");
        }
    }

    // Helper method untuk melakukan linear search
    static int cariMahasiswaByNIMHelper(String nim) {
        for (int i = 0; i < jumlahMahasiswa; i++) {
            if (mahasiswa[i].getNim().equals(nim)) {
                return i;
            }
        }
        return -1;
    }

    // Helper method untuk mencari buku berdasarkan kode
    static int cariBukuByKode(String kodeBuku) {
        for (int i = 0; i < jumlahBuku; i++) {
            if (buku[i].getKodeBuku().equals(kodeBuku)) {
                return i;
            }
        }
        return -1;
    }

    // Metode sorting menggunakan selection sort
    static void sortingPeminjamanByNIM() {
        System.out.println("\n========== DATA PEMINJAMAN (SORTED BY NIM) ==========");
        
        if (jumlahPeminjaman == 0) {
            System.out.println("Tidak ada data peminjaman!");
            return;
        }
        
        // Copy data ke array temporary untuk sorting
        Peminjaman[] temp = new Peminjaman[jumlahPeminjaman];
        for (int i = 0; i < jumlahPeminjaman; i++) {
            temp[i] = peminjaman[i];
        }
        
        // Selection sort
        selectionSort(temp);
        
        System.out.println(String.format("%-10s | %-20s | %-15s | %-15s | %-15s",
                "NIM", "Judul Buku", "Lama Pinjam", "Terbambat", "Denda"));
        System.out.println("-".repeat(80));
        
        for (int i = 0; i < jumlahPeminjaman; i++) {
            System.out.println(String.format("%-10s | %-20s | %-15d | %-15d | %-15s",
                    temp[i].getNim(),
                    temp[i].getBuku().getJudul(),
                    temp[i].getLamaPinjam(),
                    temp[i].getTerbambat(),
                    "Rp " + temp[i].getDenda()));
        }
        System.out.println("===================================================================");
    }

    // Metode selection sort
    static void selectionSort(Peminjaman[] arr) {
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            
            for (int j = i + 1; j < n; j++) {
                // Membandingkan NIM secara lexicographically
                if (arr[j].getNim().compareTo(arr[minIndex].getNim()) < 0) {
                    minIndex = j;
                }
            }
            
            // Tukar elemen
            if (minIndex != i) {
                Peminjaman temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
}
