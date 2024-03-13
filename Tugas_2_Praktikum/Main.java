package Tugas_2_Praktikum;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        boolean exit = false;
        Scanner scan = new Scanner(System.in);

        do {
            List.Display();
            int choice = scan.nextInt();

            switch (choice) {
                case 0:
                    exit = true;
                    break;
                case 8:
                    List.All();
                    break;
                case 9:
                    List.cekKesamaan();
                    break;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    List.Kategori(choice);
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }

            if (choice != 0) {
                System.out.printf("Apakah anda ingin kembali ke main menu? (y/t)\n");
                String cek = scan.next();
                if (cek.equalsIgnoreCase("y")) {
                    exit = false;
                } else {
                    exit = true;
                }
            }
        } while (!exit);

        System.out.println("\nTerima kasih telah berkunjung di Perpustakaan online!");
        System.out.println("---------------------------------------------------------------");
        scan.close();
    }
}