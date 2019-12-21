package heroes;

import utils.Constants;
import map.LandType;
import visitor.Visitable;
import visitor.Visitor;

public abstract class Hero implements Visitor, Visitable {
    protected int experience;
    protected int id;
    protected int hp;
    protected int maxHp;
    protected int level;
    protected boolean isDead = false;
    protected int debuffDamage;
    protected boolean isRooted = false;
    protected int debuffDuration = 0;
    protected float angelModifier = 0;

    public final int getId() {
        return this.id;
    }

    public final int getLevel() {
        return this.level;
    }

    public final int getHp() {
        return this.hp;
    }

    public final boolean isRooted() {
        return this.isRooted;
    }

    public final boolean isDead() {
        return this.isDead;
    }

    public final void getHit(final int dmg) {
        this.hp -= dmg;
    }

    public final void debuff(final int dmg, final Boolean root, final int rounds) {
        // Setez parametrii de debuff
        this.debuffDamage = dmg;
        this.isRooted = root;
        this.debuffDuration = rounds;
    }

    public final void applyDebuff() {
        // Aplic debuff-ul daca exista
        if (this.debuffDuration == 0) {
            this.isRooted = false;
            return;
        }
        this.debuffDuration--;
        this.getHit(debuffDamage);
    }

    public final void checkHp() {
        // Schimba statutul eroului (din viu in mort) daca are sub 0 hp
        if (this.hp <= 0) {
            this.isDead = true;
        }
    }

    public final void heal(final int heal) {
        this.hp = Math.min(this.hp + heal, this.maxHp);
    }

    public final void modAngelModifier(final float x) {
        this.angelModifier += x;
    }

    public final void gainExperience(final int exp) {
        this.experience += exp;
        this.levelUp();
    }

    public final void getLeveledUp() {
        this.experience = Constants.LEVEL_ONE_EXPERIENCE
                + this.level * Constants.EXPERIENCE_PER_LEVEL;
        this.levelUp();
    }

    public final void revive(final int heal) {
        this.hp = heal;
        this.isDead = false;
    }

    public final String getStatus() {
        return this.level
                + " "
                + this.experience
                + " "
                + this.hp
                + " ";
    }

    /**
     * @param land - tipul de teren pe care se desfasoara lupta
     * @return - 1, daca nu se afla pe taramul cu bonus, sau modificatorul de teren pentru clasa
     *          respectiva daca se afla pe taramul cu bonus
     */
    public abstract float getLandModifier(LandType land);

    public abstract void levelUp();

    public abstract String getHeroClass();

    public abstract String getHeroType();
}
