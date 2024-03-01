package Tugas_1_Praktikum;

public class CategoryDisplayer {
    static String namaKategori;
    
    static String[][] getBuku(int kategori) {
        switch(kategori) {
            case 1:
                namaKategori = "Teknologi";
                return Library.Teknologi;
            case 2:
                namaKategori = "Filsafat";
                return Library.Filsafat;
            case 3:
                namaKategori = "Sejarah";
                return Library.Sejarah;
            case 4:
                namaKategori = "Agama";
                return Library.Agama;
            case 5:
                namaKategori = "Psikologi";
                return Library.Psikologi;
            case 6:
                namaKategori = "Politik";
                return Library.Politik;
            case 7:
                namaKategori = "Fiksi";
                return Library.Fiksi;
            default:
                return null;
        }
    }
}
