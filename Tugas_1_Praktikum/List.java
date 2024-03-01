package Tugas_1_Praktikum;

public class List {
    public static void Display() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Selamat datang di Perpustakaan Online!\n");
        System.out.println("Silakan pilih kategori atau apa yang ingin Anda lakukan:");
        System.out.println("1. Teknologi\n2. Filsafat\n3. Sejarah\n4. Agama\n5. Psikologi\n6. Politik\n7. Fiksi");
        System.out.println("8. Tampilkan Semua Buku");
        System.out.println("0. Keluar");
        System.out.print("\nMasukkan nomor kategori atau pilihan Anda: ");
    }
    public static void Kategori(int kategori) {
        String[][] buku = CategoryDisplayer.getBuku(kategori);
        System.out.println("\nBerikut adalah daftar buku dalam kategori " + CategoryDisplayer.namaKategori + ":\n");
        for (int i = 0; i < buku.length; i++) {
            System.out.printf("Judul\t\t:%s\n", buku[i][0]);
            System.out.printf("Penulis\t\t:%s\n", buku[i][1]);
            System.out.printf("Tahun terbit\t:%s\n", buku[i][2]);
            System.out.printf("Jumlah Halaman\t:%s\n", buku[i][3]);
            System.out.println("---------------------------------------------------------------");
        }
    }
    public static void All() {
        for (int i = 1; i < 8; i++) {
            Kategori(i);
        }
    }
}