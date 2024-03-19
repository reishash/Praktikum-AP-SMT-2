package Tugas_3_Praktikum;
import java.util.Random;
import java.util.Scanner;

// Class Main
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nSelamat datang di game adu Hero! silahkan isi stats dari kedua Hero anda." 
                        + "\nRules: HP dan ATK = 1-1000, DEF = 1-100 (Berlaku persentase)."
                        + "\nDefense akan berkurang sebanyak 5 setiap ronde");

        Hero hero1 = new Hero();
        System.out.print("\n--------------------------------------------------\nHero 1\n");
        System.out.print("\tName\t\t\t: ");
        hero1.setName(scanner.nextLine());
        
        System.out.print("\tHP\t\t\t: ");
        int hp1 = scanner.nextInt();
        while (hp1 < 1 || hp1 > 1000) {
            System.out.print("\tHP harus antara 1-1000. Silakan masukkan ulang:");
            hp1 = scanner.nextInt();
        }
        hero1.setHp(hp1);
        
        System.out.print("\tAttack\t\t\t: ");
        int atk1 = scanner.nextInt();
        while (atk1 < 1 || atk1 > 1000) {
            System.out.print("\tAttack harus antara 1-1000. Silakan masukkan ulang:");
            atk1 = scanner.nextInt();
        }
        hero1.setAtk(atk1);
        
        System.out.print("\tDefense (1-100)\t\t: ");
        int defense1 = scanner.nextInt();
        while (defense1 < 1 || defense1 > 100) {
            System.out.print("\tDefense harus antara 1-100. Silakan masukkan ulang:");
            defense1 = scanner.nextInt();
        }
        scanner.nextLine();
        hero1.setDef(defense1);

        System.out.print("--------------------------------------------------\nHero 2\n");
        System.out.print("\n\tName\t\t\t: ");
        String name2 = scanner.nextLine();
        
        System.out.print("\tHP\t\t\t: ");
        int hp2 = scanner.nextInt();
        scanner.nextLine();
        while (hp2 < 1 || hp2 > 1000) {
            System.out.print("\tHP harus antara 1-1000. Silakan masukkan ulang:");
            hp2 = scanner.nextInt();
            scanner.nextLine();
        }
        
        System.out.print("\tAttack\t\t\t: ");
        int atk2 = scanner.nextInt();
        scanner.nextLine();
        while (atk2 < 1 || atk2 > 1000) {
            System.out.print("\tAttack harus antara 1-1000. Silakan masukkan ulang:");
            atk2 = scanner.nextInt();
            scanner.nextLine();
        }
        
        System.out.print("\tDefense (1-100)\t\t: ");
        int defense2 = scanner.nextInt();
        scanner.nextLine();
        while (defense2 < 1 || defense2 > 100) {
            System.out.print("\tDefense harus antara 1-100. Silakan masukkan ulang:");
            defense2 = scanner.nextInt();
            scanner.nextLine();
        }
        Hero hero2 = new Hero(name2, hp2, atk2, defense2);

        System.out.println("--------------------------------------------------\nInformasi Hero 1:");
        hero1.printInfo();
        System.out.println("\nInformasi Hero 2:");
        hero2.printInfo();

        System.out.println("\nApakah Anda yakin ingin bertarung? (y/t)");
        String confirm = scanner.nextLine();
        if (!confirm.equalsIgnoreCase("y")) {
            System.out.println("Pertarungan dibatalkan.\n--------------------------------------------------");
            scanner.close();
            return;
        }

        Random random = new Random();
        int attackOrder = random.nextInt(2);

        int round = 1;
        while (hero1.getHp() > 0 && hero2.getHp() > 0) {
            System.out.println("--------------------------------------------------\nRonde " + round + "\n");
            if (attackOrder == 0) {
                hero1.attack(hero2);
                System.out.println("\t" + hero1.getName() + " HP sisa: " + hero1.getHp() + ", Defense: " + hero1.getDef());
                System.out.println("\t" + hero2.getName() + " HP sisa: " + hero2.getHp() + ", Defense: " + hero2.getDef() +"\n");
                if (hero2.getHp() <= 0) {
                    break;
                }
                hero2.attack(hero1);
                System.out.println("\t" + hero1.getName() + " HP sisa: " + hero1.getHp() + ", Defense: " + hero1.getDef());
                System.out.println("\t" + hero2.getName() + " HP sisa: " + hero2.getHp() + ", Defense: " + hero2.getDef());
                if (hero1.getHp() <= 0) {
                    break;
                }
            } else {
                hero2.attack(hero1);
                System.out.println("\t" + hero1.getName() + " HP sisa: " + hero1.getHp() + ", Defense: " + hero1.getDef());
                System.out.println("\t" + hero2.getName() + " HP sisa: " + hero2.getHp() + ", Defense: " + hero2.getDef() +"\n");
                if (hero1.getHp() <= 0) {
                    break;
                }
                hero1.attack(hero2);
                System.out.println("\t" + hero1.getName() + " HP sisa: " + hero1.getHp() + ", Defense: " + hero1.getDef());
                System.out.println("\t" + hero2.getName() + " HP sisa: " + hero2.getHp() + ", Defense: " + hero2.getDef());
                if (hero2.getHp() <= 0) {
                    break;
                }
            }
            round++;
            attackOrder = random.nextInt(2);
        }

        if (hero1.getHp() < 0) {
            System.out.println("\nPertarungan telah usai! " + hero1.getName() + " (Hero 1) telah kalah.");
        } else {
            System.out.println("\nPertarungan telah usai! " + hero2.getName() + " (Hero 2) telah kalah.");
            System.out.println("--------------------------------------------------");
        }
        System.out.println("--------------------------------------------------");
        scanner.close();
    }
}
