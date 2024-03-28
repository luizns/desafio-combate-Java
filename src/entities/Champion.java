package entities;

public class Champion {
    private String name;
    private int attack;
    private int armor;
    private int life;

    public Champion() {
    }

    public Champion(String name, int attack, int armor, int life) {
        this.name = name;
        this.attack = attack;
        this.armor = armor;
        this.life = life;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getLife() {
        return this.life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void takeDamage(Champion opponent) {
        int damage = opponent.attack - this.armor;
        damage = Math.max(damage, 1);
        this.life -= damage;
        this.life = Math.max(this.life, 0);
    }

    public String status() {
        if (this.life > 0) {
            return name + ": " + life + " de vida";
        } else {
            return name + ": 0 de vida (morreu)";
        }
    }

}
