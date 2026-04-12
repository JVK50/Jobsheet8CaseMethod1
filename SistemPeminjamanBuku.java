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
                    tampilkanDataPeminjaman();
                    break;
                case 4:
                    sortingPeminjamanByDenda();
                    break;
                case 5:
                    cariPeminjamanByNIM();
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
        System.out.println("3. Tampilkan Data Peminjaman");
        System.out.println("4. Sorting Data Peminjaman by Denda");
        System.out.println("5. Cari Peminjaman By NIM");
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

    // Metode untuk menampilkan semua data peminjaman
    static void tampilkanDataPeminjaman() {
        System.out.println("\n========== DATA PEMINJAMAN ==========");
        
        if (jumlahPeminjaman == 0) {
            System.out.println("Tidak ada data peminjaman!");
            return;
        }
        
        for (int i = 0; i < jumlahPeminjaman; i++) {
            String namaMahasiswa = getMahasiswaNameByNIM(peminjaman[i].getNim());
            System.out.println(namaMahasiswa + " | " + 
                    peminjaman[i].getBuku().getJudul() + " | " +
                    "Lama: " + peminjaman[i].getLamaPinjam() + " | " +
                    "Terlambat: " + peminjaman[i].getTerbambat() + " | " +
                    "Denda: " + peminjaman[i].getDenda());
        }
        System.out.println("====================================");
    }

    // Metode helper untuk mendapatkan nama mahasiswa berdasarkan NIM
    static String getMahasiswaNameByNIM(String nim) {
        for (int i = 0; i < jumlahMahasiswa; i++) {
            if (mahasiswa[i].getNim().equals(nim)) {
                return mahasiswa[i].getNama();
            }
        }
        return "Tidak ditemukan";
    }

    // Metode searching untuk mencari data peminjaman berdasarkan NIM
    static void cariPeminjamanByNIM() {
        System.out.println("\n========== CARI PEMINJAMAN BY NIM ==========");
        System.out.print("Masukkan NIM yang dicari: ");
        String nim = scanner.nextLine();
        
        System.out.println("\n--- Hasil Pencarian ---");
        boolean ditemukan = false;
        
        for (int i = 0; i < jumlahPeminjaman; i++) {
            if (peminjaman[i].getNim().equals(nim)) {
                String namaMahasiswa = getMahasiswaNameByNIM(peminjaman[i].getNim());
                System.out.println(namaMahasiswa + " | " + 
                        peminjaman[i].getBuku().getJudul() + " | " +
                        "Lama: " + peminjaman[i].getLamaPinjam() + " | " +
                        "Terlambat: " + peminjaman[i].getTerbambat() + " | " +
                        "Denda: " + peminjaman[i].getDenda());
                ditemukan = true;
            }
        }
        
        if (!ditemukan) {
            System.out.println("Tidak ada data peminjaman untuk NIM " + nim);
        }
        System.out.println("==========================================");
    }

    // Helper method untuk melakukan binary search pada mahasiswa berdasarkan NIM
    static int cariMahasiswaByNIMHelper(String nim) {
        int left = 0;
        int right = jumlahMahasiswa - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = mahasiswa[mid].getNim().compareTo(nim);
            
            if (comparison == 0) {
                return mid;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // Helper method untuk mencari buku berdasarkan kode dengan binary search
    static int cariBukuByKode(String kodeBuku) {
        int left = 0;
        int right = jumlahBuku - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = buku[mid].getKodeBuku().compareTo(kodeBuku);
            
            if (comparison == 0) {
                return mid;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // Helper method untuk mencari peminjaman berdasarkan NIM dengan binary search
    static int cariPeminjamanByNIMBinary(String nim) {
        int left = 0;
        int right = jumlahPeminjaman - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = peminjaman[mid].getNim().compareTo(nim);
            
            if (comparison == 0) {
                return mid;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // Metode sorting menggunakan insertion sort 
    static void sortingPeminjamanByDenda() {
        System.out.println("\n========== DATA PEMINJAMAN (SORTED BY DENDA - TERBESAR DULU) ==========");
        
        if (jumlahPeminjaman == 0) {
            System.out.println("Tidak ada data peminjaman!");
            return;
        }
        
        // Copy data ke array temporary untuk sorting
        Peminjaman[] temp = new Peminjaman[jumlahPeminjaman];
        for (int i = 0; i < jumlahPeminjaman; i++) {
            temp[i] = peminjaman[i];
        }
        
        // insertion sort by Denda 
        insertionSortByDenda(temp);
        
        for (int i = 0; i < jumlahPeminjaman; i++) {
            String namaMahasiswa = getMahasiswaNameByNIM(temp[i].getNim());
            System.out.println(namaMahasiswa + " | " + 
                    temp[i].getBuku().getJudul() + " | " +
                    "Lama: " + temp[i].getLamaPinjam() + " | " +
                    "Terlambat: " + temp[i].getTerbambat() + " | " +
                    "Denda: " + temp[i].getDenda());
        }
        System.out.println("========================================================================");
    }

    // Metode insertion sort by Denda 
    static void insertionSortByDenda(Peminjaman[] arr) {
        int n = arr.length;
        
        for (int i = 1; i < n; i++) {
            Peminjaman key = arr[i];
            int j = i - 1;
            
            // Untuk descending order: geser elemen yang lebih kecil ke kanan
            while (j >= 0 && arr[j].getDenda() < key.getDenda()) {
                arr[j + 1] = arr[j];
                j--;
            }
            
            // Sisipkan key pada posisi yang tepat
            arr[j + 1] = key;
        }
    }
}
