package Tugas_2_Praktikum;

public class Book {
    String judul;
    String penulis;
    String tahun;
    String hal;
    String sinopsis;

    public Book(String judul, String penulis, String tahun, String hal, String sinopsis) {
        this.judul = judul;
        this.penulis = penulis;
        this.tahun = tahun;
        this.hal = hal;
        this.sinopsis = sinopsis;
    }
    public int hitungSinopsis() {
        String[] kata = this.sinopsis.split("\\s+");
        return kata.length;
    }
    public double cekKesamaan(Book bukuLain) {
        int jumlahAtribut = 5;
        int kesamaan = 0;

        if (this.judul.equals(bukuLain.judul)) kesamaan++;
        if (this.penulis.equals(bukuLain.penulis)) kesamaan++;
        if (this.tahun.equals(bukuLain.tahun)) kesamaan++;
        if (this.hal.equals(bukuLain.hal)) kesamaan++;
        if (this.sinopsis.equals(bukuLain.sinopsis)) kesamaan++;

        double persentaseKesamaan = (double) kesamaan / jumlahAtribut * 100;

        return persentaseKesamaan;
    }
    @Override
    public String toString() {
        return String.format("Judul\t\t\t: %s\n" +
                             "Penulis\t\t\t: %s\n" +
                             "Tahun terbit\t\t: %s\n" +
                             "Jumlah Halaman\t\t: %s\n" +
                             "Sinopsis\t\t: %s\n" +
                             "Jumlah kata sinopsis\t: %d\n" +
                             "---------------------------------------------------------------",
                             judul, penulis, tahun, hal, sinopsis, hitungSinopsis());
    }
}
