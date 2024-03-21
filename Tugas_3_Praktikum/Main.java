package Tugas_3_Praktikum;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("\nSelamat datang di game adu Hero! silahkan isi stats dari kedua Hero anda." 
                        + "\nRules: HP dan ATK = 1-1000, DEF = 1-100 (Berlaku persentase)."
                        + "\nDefense akan berkurang sebanyak 5 setiap ronde");

        Hero hero1 = new Hero();
        System.out.print("\n--------------------------------------------------\nHero 1\n");
        System.out.print("\tName\t\t\t: ");
        hero1.setName(scan.nextLine());
        hero1.setHp(getValidInput(scan, "HP", 1, 1000));
        hero1.setAtk(getValidInput(scan, "Attack", 1, 1000));
        hero1.setDef(getValidInput(scan, "Defense", 1, 100));

        System.out.print("--------------------------------------------------\nHero 2\n");
        System.out.print("\tName\t\t\t: ");
        String name2 = scan.nextLine();
        int hp2 = getValidInput(scan, "HP", 1, 1000);
        int atk2 = (getValidInput(scan, "Attack", 1, 1000));
        int def2 = (getValidInput(scan, "Defense", 1, 100));
        Hero hero2 = new Hero(name2, hp2, atk2, def2);

        System.out.println("--------------------------------------------------\nInformasi Hero 1:");
        hero1.printInfo();
        System.out.println("\nInformasi Hero 2:");
        hero2.printInfo();

        System.out.println("\nApakah Anda yakin ingin bertarung? (y/t)");
        String confirm = scan.nextLine();
        if (!confirm.equalsIgnoreCase("y")) {
            System.out.println("Pertarungan dibatalkan.\n--------------------------------------------------");
            scan.close();
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
        scan.close();
    }
    private static int getValidInput(Scanner scan, String attribute, int min, int max) {
        int value = 0;
        while (true) {
            System.out.print("\t" + attribute + " (1-" + max + ")\t\t: ");
            value = scan.nextInt();
            if (value >= min && value <= max) {
                break;
            }
            System.out.println(attribute + " harus antara " + min + "-" + max + ". Silakan masukkan ulang:");
        }
        scan.nextLine();
        return value;
    }
}
