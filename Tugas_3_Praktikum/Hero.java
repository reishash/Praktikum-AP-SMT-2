package Tugas_3_Praktikum;

public class Hero {
    private String name;
    private int hp;
    private int atk;
    private int def;

    public Hero() {
    }

    public Hero(String name, int hp, int atk, int def) {
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void attack(Hero target) {
        int damage = (int) (this.atk * (1 - (target.getDef() / 100.0)));
        int newHp = target.getHp() - damage;
        if (newHp < 0) {
            newHp = 0;
        }
        target.setHp(newHp);
        System.out.println(this.name + " menyerang " + target.getName() + " sebesar " + damage + " damage.\n");
        target.setDef(Math.max(0, target.getDef() - 5));
    }

    public void printInfo() {
        System.out.println("Name\t\t\t: " + this.name);
        System.out.println("Health Point\t\t: " + this.hp);
        System.out.println("Attack\t\t\t: " + this.atk);
        System.out.println("Defense\t\t\t: " + this.def);
    }
}
