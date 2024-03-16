package Tugas_3_Praktikum;
import java.util.Scanner;

// Class Main
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Hero hero1 = new Hero();
        System.out.print("--------------------------------------------------\nHero 1\n");
        System.out.print("Name\t\t\t: ");
        hero1.setName(scanner.nextLine());
        System.out.print("HP\t\t\t: ");
        hero1.setHp(scanner.nextInt());
        scanner.nextLine(); 
        System.out.print("Attack\t\t\t: ");
        hero1.setAtk(scanner.nextInt());
        scanner.nextLine(); 
        System.out.print("Defense (1-100)\t\t: ");
        int defense1 = scanner.nextInt();
        while (defense1 < 1 || defense1 > 100) {
            System.out.println("Defense harus antara 1-100. Silakan masukkan ulang:");
            defense1 = scanner.nextInt();
        }
        hero1.setDef(defense1);
        scanner.nextLine();

        System.out.print("--------------------------------------------------\nHero 2\n");
        System.out.print("\nName\t\t\t: ");
        String name2 = scanner.nextLine();
        System.out.print("HP\t\t\t: ");
        int hp2 = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Attack\t\t\t: ");
        int attack2 = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Defense (1-100)\t\t: ");
        int defense2 = scanner.nextInt();
        while (defense2 < 1 || defense2 > 100) {
            System.out.println("Defense harus antara 1-100. Silakan masukkan ulang:");
            defense2 = scanner.nextInt();
        }
        scanner.nextLine();
        Hero hero2 = new Hero(name2, hp2, attack2, defense2);

        System.out.println("--------------------------------------------------\nInformasi Hero 1:");
        hero1.printInfo();
        System.out.println("\nInformasi Hero 2:");
        hero2.printInfo();

        System.out.println("\nApakah Anda yakin ingin bertarung? (y/n)");
        String confirm = scanner.nextLine();
        if (!confirm.equalsIgnoreCase("y")) {
            System.out.println("Pertarungan dibatalkan.\n--------------------------------------------------");
            scanner.close();
            return;
        }

        int round = 1;
        while (hero1.getHp() > 0 && hero2.getHp() > 0) {
            System.out.println("--------------------------------------------------\nRonde " + round + "\n");
            hero1.attack(hero2);
            System.out.println(hero1.getName() + " HP sisa: " + hero1.getHp() + ", Defense: " + hero1.getDef());
            System.out.println(hero2.getName() + " HP sisa: " + hero2.getHp() + ", Defense: " + hero2.getDef() +"\n");
            if (hero2.getHp() <= 0) {
                break;
            }
            hero2.attack(hero1);
            System.out.println(hero1.getName() + " HP sisa: " + hero1.getHp() + ", Defense: " + hero1.getDef());
            System.out.println(hero2.getName() + " HP sisa: " + hero2.getHp() + ", Defense: " + hero2.getDef());
            if (hero1.getHp() <= 0) {
                break;
            }
            round++;
        }

        if (hero1.getHp() < 0) {
            System.out.println("\nPertarungan telah usai! " + hero1.getName() + " (Hero 1) telah kalah.");
        } else {
            System.out.println("\nPertarungan telah usai! " + hero2.getName() + " (Hero 2) telah kalah.");
        }
        System.out.println("--------------------------------------------------");
        scanner.close();
    }
}
