package main;

public class Pyromancer extends Hero {
    private int fireblast;
    private int ignite;
    private int igniteOt;
    private int igniteDuration;

    Pyromancer() {
        this.hp = Constants.PYRO_INIT_HP;
        this.fireblast = Constants.FIREBLAST_FLAT_DMG;
        this.ignite = Constants.IGNITE_FLAT_DMG;
        this.igniteOt = Constants.IGNITE_OT_DMG;
        this.igniteDuration = 2;
    }

    @Override
    public double getLandModifier(LandType land) {
        if(land == LandType.Volcanic) {
            return Constants.VOLCANIC_PYRO;
        }
        return 1;
    }

    @Override
    public void dealDmg(Knight hero, LandType land) {
        double landMod = this.getLandModifier(land);
        int fireblastDmg = (int) Math.round(this.fireblast * Constants.FIREBLAST_APPLIED_TO_KNIGHT * landMod);
        int igniteDmg = (int) Math.round(this.ignite * Constants.IGNITE_APPLIED_TO_KNIGHT * landMod);
        int igniteDot = (int) Math.round(this.igniteOt * Constants.IGNITE_APPLIED_TO_KNIGHT * landMod);
        hero.debuff(igniteDot, false, 2);
        hero.getHit(fireblastDmg + igniteDmg);
        if (hero.isDead()) {
            this.experience += Math.max(0, 200 - (this.level - hero.getLevel()) * Constants.LEVEL_DIFF_EXP_MULTIPLIER);
        }
    }

    @Override
    public void dealDmg(Pyromancer hero, LandType land) {
        double landMod = this.getLandModifier(land);
        int fireblastDmg = (int) Math.round(this.fireblast * Constants.FIREBLAST_APPLIED_TO_PYRO * landMod);
        int igniteDmg = (int) Math.round(this.ignite * Constants.IGNITE_APPLIED_TO_PYRO * landMod);
        int igniteDot = (int) Math.round(this.igniteOt * Constants.IGNITE_APPLIED_TO_PYRO * landMod);
        hero.debuff(igniteDot, false, 2);
        hero.getHit(fireblastDmg + igniteDmg);
        if (hero.isDead()) {
            this.experience += Math.max(0, 200 - (this.level - hero.getLevel()) * Constants.LEVEL_DIFF_EXP_MULTIPLIER);
        }
    }

    @Override
    public void dealDmg(Wizard hero, LandType land) {
        double landMod = this.getLandModifier(land);
        int fireblastDmg = (int) Math.round(this.fireblast * Constants.FIREBLAST_APPLIED_TO_WIZ * landMod);
        int igniteDmg = (int) Math.round(this.ignite * Constants.IGNITE_APPLIED_TO_WIZ * landMod);
        int igniteDot = (int) Math.round(this.igniteOt * Constants.IGNITE_APPLIED_TO_WIZ * landMod);
        hero.debuff(igniteDot, false, 2);
        hero.getHit(fireblastDmg + igniteDmg);
        if (hero.isDead()) {
            this.experience += Math.max(0, 200 - (this.level - hero.getLevel()) * Constants.LEVEL_DIFF_EXP_MULTIPLIER);
        }
    }

    @Override
    public void dealDmg(Rogue hero, LandType land) {
        double landMod = this.getLandModifier(land);
        int fireblastDmg = (int) Math.round(this.fireblast * Constants.FIREBLAST_APPLIED_TO_ROGUE * landMod);
        int igniteDmg = (int) Math.round(this.ignite * Constants.IGNITE_APPLIED_TO_ROGUE * landMod);
        int igniteDot = (int) Math.round(this.igniteOt * Constants.IGNITE_APPLIED_TO_ROGUE * landMod);
        hero.debuff(igniteDot, false, 2);
        hero.getHit(fireblastDmg + igniteDmg);
        if (hero.isDead()) {
            this.experience += Math.max(0, 200 - (this.level - hero.getLevel()) * Constants.LEVEL_DIFF_EXP_MULTIPLIER);
        }
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
            this.hp = Constants.PYRO_INIT_HP + i * Constants.PYRO_HP_GROWTH;
            this.fireblast = Constants.FIREBLAST_FLAT_DMG + i * Constants.FIREBLAST_DMG_PER_LEVEL;
            this.ignite = Constants.IGNITE_FLAT_DMG + i * Constants.IGNITE_FLAT_DMG_PER_LEVEL;
            this.igniteOt = Constants.IGNITE_OT_DMG + i * Constants.IGNITE_OT_DMG_PER_LEVEL;
        }
    }

    @Override
    void printHeroClass() {
        System.out.print("P ");
    }


}
