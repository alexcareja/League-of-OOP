package main;

public class Wizard extends Hero {
    private float drain;
    private float deflect;
    private int deflectFlatDmg;

    Wizard() {
        this.hp = Constants.WIZ_INIT_HP;
        this.drain = Constants.DRAIN_FLAT_PERCENTAGE;
        this.deflect = Constants.DEFLECT_FLAT_PERCENTAGE;
        this.deflectFlatDmg = 0;
    }

    void setDmgToDeflect(int dmg) {
        this.deflectFlatDmg = dmg;
    }

    @Override
    public float getLandModifier(LandType land) {
        if(land == LandType.Desert) {
            return Constants.DESERT_WIZ;
        }
        return 1;
    }

    @Override
    public void dealDmg(Knight hero, LandType land) {
        int heroMaxHp = Constants.KNIGHT_INIT_HP + hero.getLevel() * Constants.KNIGHT_HP_GROWTH;
        float landMod = this.getLandModifier(land);
        int drainDmg = Math.round(this.drain * Math.min(0.3f * heroMaxHp, hero.getHp()) * landMod * Constants.DRAIN_APPLIED_TO_KNIGHT);
        int deflectDmg = Math.round(this.deflectFlatDmg * this.deflect * Constants.DEFLECT_APPLIED_TO_KNIGHT);
        hero.getHit(drainDmg + deflectDmg);
        if (hero.getHp() <= 0) {
            this.experience += Math.max(0, 200 - (this.level - hero.getLevel()) * Constants.LEVEL_DIFF_EXP_MULTIPLIER);
        }
        this.deflectFlatDmg = 0;
    }

    @Override
    public void dealDmg(Pyromancer hero, LandType land) {
        int heroMaxHp = Constants.PYRO_INIT_HP + hero.getLevel() * Constants.PYRO_HP_GROWTH;
        float landMod = this.getLandModifier(land);
        int drainDmg = Math.round(this.drain * Math.min(0.3f * heroMaxHp, hero.getHp()) * landMod * Constants.DRAIN_APPLIED_TO_PYRO);
        int deflectDmg = Math.round(this.deflectFlatDmg * this.deflect * Constants.DEFLECT_APPLIED_TO_PYRO);
        hero.getHit(drainDmg + deflectDmg);
        if (hero.getHp() <= 0) {
            this.experience += Math.max(0, 200 - (this.level - hero.getLevel()) * Constants.LEVEL_DIFF_EXP_MULTIPLIER);
        }
        this.deflectFlatDmg = 0;
    }

    @Override
    public void dealDmg(Wizard hero, LandType land) {
        this.deflectFlatDmg = 0;
        int heroMaxHp = Constants.WIZ_INIT_HP + hero.getLevel() * Constants.WIZ_HP_GROWTH;
        float landMod = this.getLandModifier(land);
        int drainDmg = Math.round(this.drain * Math.min(0.3f * heroMaxHp, hero.getHp()) * landMod * Constants.DRAIN_APPLIED_TO_WIZ);
        hero.getHit(drainDmg);
        if (hero.getHp() <= 0) {
            this.experience += Math.max(0, 200 - (this.level - hero.getLevel()) * Constants.LEVEL_DIFF_EXP_MULTIPLIER);
        }
    }

    @Override
    public void dealDmg(Rogue hero, LandType land) {
        int heroMaxHp = Constants.ROGUE_INIT_HP + hero.getLevel() * Constants.ROGUE_HP_GROWTH;
        float landMod = this.getLandModifier(land);
        int drainDmg = Math.round(this.drain * Math.min(0.3f * heroMaxHp, hero.getHp()) * landMod * Constants.DRAIN_APPLIED_TO_ROGUE);
        int deflectDmg = Math.round(this.deflectFlatDmg * this.deflect * Constants.DEFLECT_APPLIED_TO_ROGUE);
        hero.getHit(drainDmg + deflectDmg);
        if (hero.getHp() <= 0) {
            this.experience += Math.max(0, 200 - (this.level - hero.getLevel()) * Constants.LEVEL_DIFF_EXP_MULTIPLIER);
        }
        this.deflectFlatDmg = 0;
    }

    @Override
    public void takeDmg(Visitor v, LandType land) {
        v.dealDmg(this, land);
    }

    @Override
    void levelUp() {
        int i = 0;
        while(this.experience > Constants.LEVEL_ONE_EXPERIENCE + i * Constants.EXPERIENCE_PER_LEVEL) {
            i++;
        }
        if(i > this.level) {
            this.level = i;
            this.hp = Constants.WIZ_INIT_HP + i * Constants.WIZ_HP_GROWTH;
            this.drain = Constants.DRAIN_FLAT_PERCENTAGE + i * Constants.DRAIN_PERCENT_PER_LEVEL;
            this.deflect = Constants.DEFLECT_FLAT_PERCENTAGE + i * Constants.DEFLECT_PERCENT_PER_LEVEL;
            if(this.deflect > Constants.DEFLECT_MAX_PERCENTAGE) {
                this.deflect = Constants.DEFLECT_MAX_PERCENTAGE;
            }
        }
    }

    @Override
    void printHeroClass() {
        System.out.print("W ");
    }

}
