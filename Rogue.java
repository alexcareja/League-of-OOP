package main;

public class Rogue extends Hero {
    private int backstab;
    private int paralysis;
    private int backstabCount;

    Rogue() {
        this.hp = Constants.ROGUE_INIT_HP;
        this.backstab = Constants.BACKSTAB_FLAT_DMG;
        this.paralysis = Constants.PARALYSIS_FLAT_DMG;
    }

    @Override
    public double getLandModifier(LandType land) {
        if(land == LandType.Woods) {
            return Constants.WOODS_ROGUE;
        }
        return 1;
    }

    @Override
    public void dealDmg(Knight hero, LandType land) {
        backstabCount++;
        int duration = Constants.PARALYSIS_DURATION;
        double backstabCrit = 1;
        if(land == LandType.Woods) {
            duration *= 2;
            if(backstabCount % 3 == 0) {
                backstabCrit = 1.5;
            }
        }
        double landMod = this.getLandModifier(land);
        int backstabDmg = (int) Math.round(this.backstab * Constants.BACKSTAB_APPLIED_TO_KNIGHT * landMod * backstabCrit);
        int paralysisDmg = (int) Math.round(this.paralysis * Constants.PARALYSIS_APPLIED_TO_KNIGHT * landMod);
        hero.debuff(paralysisDmg, true, duration);
        hero.getHit(backstabDmg + paralysisDmg);
        if (hero.isDead()) {
            this.experience += Math.max(0, 200 - (this.level - hero.getLevel()) * Constants.LEVEL_DIFF_EXP_MULTIPLIER);
        }
    }

    @Override
    public void dealDmg(Pyromancer hero, LandType land) {
        backstabCount++;
        int duration = Constants.PARALYSIS_DURATION;
        double backstabCrit = 1;
        if(land == LandType.Woods) {
            duration *= 2;
            if(backstabCount % 3 == 0) {
                backstabCrit = 1.5;
            }
        }
        double landMod = this.getLandModifier(land);
        int backstabDmg = (int) Math.round(this.backstab * Constants.BACKSTAB_APPLIED_TO_PYRO * landMod * backstabCrit);
        int paralysisDmg = (int) Math.round(this.paralysis * Constants.PARALYSIS_APPLIED_TO_PYRO * landMod);
        hero.debuff(paralysisDmg, true, duration);
        hero.getHit(backstabDmg + paralysisDmg);
        if (hero.isDead()) {
            this.experience += Math.max(0, 200 - (this.level - hero.getLevel()) * Constants.LEVEL_DIFF_EXP_MULTIPLIER);
        }
    }

    @Override
    public void dealDmg(Wizard hero, LandType land) {
        backstabCount++;
        int duration = Constants.PARALYSIS_DURATION;
        double backstabCrit = 1;
        if(land == LandType.Woods) {
            duration *= 2;
            if(backstabCount % 3 == 0) {
                backstabCrit = 1.5;
            }
        }
        double landMod = this.getLandModifier(land);
        int backstabDmg = (int) Math.round(this.backstab * Constants.BACKSTAB_APPLIED_TO_WIZ * landMod * backstabCrit);
        int paralysisDmg = (int) Math.round(this.paralysis * Constants.PARALYSIS_APPLIED_TO_WIZ * landMod);
        hero.debuff(paralysisDmg, true, duration);
        hero.getHit(backstabDmg + paralysisDmg);
        if (hero.isDead()) {
            this.experience += Math.max(0, 200 - (this.level - hero.getLevel()) * Constants.LEVEL_DIFF_EXP_MULTIPLIER);
        }
    }

    @Override
    public void dealDmg(Rogue hero, LandType land) {
        backstabCount++;
        int duration = Constants.PARALYSIS_DURATION;
        double backstabCrit = 1;
        if(land == LandType.Woods) {
            duration *= 2;
            if(backstabCount % 3 == 0) {
                backstabCrit = 1.5;
            }
        }
        double landMod = this.getLandModifier(land);
        int backstabDmg = (int) Math.round(this.backstab * Constants.BACKSTAB_APPLIED_TO_ROGUE * landMod * backstabCrit);
        int paralysisDmg = (int) Math.round(this.paralysis * Constants.PARALYSIS_APPLIED_TO_ROGUE * landMod);
        hero.debuff(paralysisDmg, true, duration);
        hero.getHit(backstabDmg + paralysisDmg);
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

    }

    @Override
    void printHeroClass() {
        System.out.print("R ");
    }

}
