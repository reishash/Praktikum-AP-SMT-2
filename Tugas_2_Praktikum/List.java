package Tugas_2_Praktikum;

import java.util.Scanner;

public class List {
    public static void Display() {
            System.out.printf("---------------------------------------------------------------\n");
            System.out.printf("Selamat datang di Perpustakaan Online!\n\n");
            System.out.printf("Silakan pilih kategori atau apa yang ingin Anda lakukan:\n");
            System.out.printf("1. Teknologi\n2. Filsafat\n3. Sejarah\n4. Agama\n5. Psikologi\n6. Politik\n7. Fiksi\n");
            System.out.printf("8. Tampilkan Semua Buku\n");
            System.out.printf("9. Cek kesamaan 2 Buku");
            System.out.printf("0. Keluar\n");
            System.out.printf("\nMasukkan nomor kategori atau pilihan Anda: ");
    }

    public static void Kategori(int kategori) {
        String namaKategori;
        switch (kategori) {
            case 1:
                namaKategori = "Teknologi";
                break;
            case 2:
                namaKategori = "Filsafat";
                break;
            case 3:
                namaKategori = "Sejarah";
                break;
            case 4:
                namaKategori = "Agama";
                break;
            case 5:
                namaKategori = "Psikologi";
                break;
            case 6:
                namaKategori = "Politik";
                break;
            case 7:
                namaKategori = "Fiksi";
                break;
            default:
                System.out.println("Kategori invalid");
                return;
        }
        
        Book[] buku = Library.getBuku(namaKategori);
        System.out.println("\nBerikut adalah daftar buku dalam kategori " + namaKategori + ":\n");
        for (int i = 0; i < buku.length; i++) {
            System.out.println(buku[i].toString());
        }
    }

    public static void All() {
        for (int i = 1; i < 8; i++) {
            Kategori(i);
        }
    }
    public static void cekKesamaan() {
        All();
        Scanner scan = new Scanner(System.in);
        System.out.println("Masukkan kategori dan indeks buku pertama (misal: Teknologi 1):");
        String input1 = scan.nextLine();
        String[] parts1 = input1.split(" ");
        String kategori1 = parts1[0];
        int index1 = Integer.parseInt(parts1[1]) - 1;

        Book[] buku1 = Library.getBuku(kategori1);
        if (index1 >= buku1.length || index1 < 0) {
            System.out.println("Buku tidak ditemukan.");
            return;
        }

        System.out.println("Masukkan kategori dan indeks buku kedua (misal: Fiksi 2):");
        String input2 = scan.nextLine();
        String[] parts2 = input2.split(" ");
        String kategori2 = parts2[0];
        int index2 = Integer.parseInt(parts2[1]) - 1;

        Book[] buku2 = Library.getBuku(kategori2);
        if (index2 >= buku2.length || index2 < 0) {
            System.out.println("Buku tidak ditemukan.");
            return;
        }

        double persentaseKesamaan = buku1[index1].cekKesamaan(buku2[index2]);
        System.out.println("Persentase Kesamaan: " + persentaseKesamaan + "%");
    }
}