package main;

public abstract class Hero implements Visitor, Visitable {
    protected int experience;
    protected int hp;
    protected int level;
    private boolean isDead = false;
    private boolean isRooted = false;

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
        if(this.hp <= 0) {
            this.isDead = true;
        }
    }

    abstract double getLandModifier(LandType land);

    public abstract void takeDmg(Visitor hero, LandType land);

    abstract void levelUp();

    abstract void printStatus();
}
