package main;

public abstract class Hero implements Visitor, Visitable {
    protected int experience;
    protected int hp;
    protected int level;
    protected boolean isDead = false;
    protected int debuffDamage;
    protected boolean isRooted = false;
    protected int debuffDuration = 0;

    int getLevel() {
        return this.level;
    }

    int getHp() {
        return this.hp;
    }

    boolean isRooted() {
        return this.isRooted;
    }

    boolean isDead() {
        return this.isDead;
    }

    void getHit(int dmg) {
        this.hp -= dmg;
    }

    void debuff(int dmg, Boolean root, int rounds) {
        this.debuffDamage = dmg;
        this.isRooted = root;
        this.debuffDuration = rounds;
    }

    void applyDebuff() {
        if (this.debuffDuration == 0) {
            this.isRooted = false;
            return;
        }
        this.debuffDuration --;
        this.getHit(debuffDamage);
    }

    void checkHp() {
        if(this.hp <= 0) {
            this.isDead = true;
        }
    }

    abstract float getLandModifier(LandType land);

    public abstract void takeDmg(Visitor hero, LandType land);

    abstract void levelUp();

    void printStatus() {
        System.out.print(this.level
                + " "
                + this.experience
                + " "
                + this.hp
                + " ");
    }

    abstract void printHeroClass();
}
